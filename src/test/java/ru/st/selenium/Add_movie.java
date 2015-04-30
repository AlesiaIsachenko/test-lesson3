package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import ru.st.selenium.model.User;
import ru.st.selenium.model.Film;

public class Add_movie extends ru.st.selenium.pages.TestBase {

  @BeforeMethod
  public void mayBeLogout() {
    if (app.getUserHelper().isNotLoggedIn()) {
    	User user = new User().setLogin("admin").setPassword("admin");
   	  	app.getUserHelper().loginAs(user);
    	return;
    }
    app.getUserHelper().logout();
    User user = new User().setLogin("admin").setPassword("admin");
	app.getUserHelper().loginAs(user);
  }
  
  @Test
  public void AddMovie() throws Exception {
	  
	//подсчитываем количество элементов
	  int k1 = app.getFilmHelper().countfilm();
	  
	//добавляем фильм только с обязательными данными
	  Film film = new Film().setTitle("Happy New Year!").setYear("2005");
	  app.getFilmHelper().create(film);
	  app.getNavigationHelper().gotoInternalPage();
   
	//подсчитываем количество элементов
	  int k2 = app.getFilmHelper().countfilm();
	  if (k2 != k1 + 1){
    	System.out.println("Ошибка добавления элемента.");
	  }
	  app.getUserHelper().logout();
  }
  
  
  @Test
  public void AddMovieNeg1() throws Exception {
	  
	//пытаемся создать описание фильма без года
	  Film film = new Film().setTitle("Litle story.").setYear("");
	  app.getFilmHelper().create(film);

	  app.getUserHelper().logout();
  }
  
  @Test
  public void AddMovieNeg2() throws Exception {
	 
	//пытаемся создать описание фильма без названия
	  Film film = new Film().setTitle("").setYear("2007");
	  app.getFilmHelper().create(film);
	   
	  app.getUserHelper().logout();  
  }
  
  @Test
  public void DeleteMovie() throws Exception {
	
	  Film film = new Film().setTitle("Delete.").setYear("2007");
	  app.getFilmHelper().create(film);
	  app.getNavigationHelper().gotoInternalPage();
	  
	  app.getFilmHelper().delete(film);
	  
	  app.getUserHelper().logout();   
	
  }

}

