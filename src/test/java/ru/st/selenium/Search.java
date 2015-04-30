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

import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;

public class Search extends ru.st.selenium.pages.TestBase {
	
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
  public void Search() throws Exception {
	//добавляем фильм
	  Film film1 = new Film().setTitle("Happy New Year1!").setYear("2005");
	  app.getFilmHelper().create(film1);
	  app.getNavigationHelper().gotoInternalPage();
	  Film film2 = new Film().setTitle("Happy New Year2!").setYear("2006");
	  app.getFilmHelper().create(film2);
	  app.getNavigationHelper().gotoInternalPage();
	
	//находим фильм по имени
	   app.getFilmHelper().search ("Happy New Year1!");
	   if (app.getFilmHelper().isElementPresent() == false){
		   System.out.println ("Ошибка поиска!");
	   }
	   
	 //находим фильм по году
	   app.getFilmHelper().search ("2006");
	   if (app.getFilmHelper().isElementPresent() == false){
		   System.out.println ("Ошибка поиска!");
	   }
	
	   //не находим ни один элемент
	   app.getFilmHelper().search ("1997");
	   if (app.getFilmHelper().isElementPresent() == true){
		   System.out.println ("Ошибка поиска1!");
	   }
    
    app.getUserHelper().logout();
  }

}
