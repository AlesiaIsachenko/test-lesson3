package ru.st.selenium.applogic2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.UserProfilePage;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
	  pages.internalPage.ensurePageLoaded().clickFilmAdd().ensurePageLoaded();
	  pages.filmAddPage.ensurePageLoaded()
	  .setTitleField(film.getTitle())
	  .setYearField(film.getYear())
	  .clickSubmitButton();
  }
 
  @Override
  public void delete(Film film) {
	  pages.internalPage.ensurePageLoaded().selectFilm(film).ensurePageLoaded().deleteFilm();
  }
  
  @Override
  public int countfilm() {
	  int k = pages.internalPage.ensurePageLoaded().count_movie_box();
	  return k;
  }

  @Override
  public List<Film> search(String title) {
	  pages.filmListPage.ensurePageLoaded()
      .setSearchField(title+ Keys.RETURN);
    return null;
  }
  
  public boolean isElementPresent() {
	  pages.internalPage.ensurePageLoaded();
	  if (driver.findElements(By.className("movie_box")).size() != 0){
		  return true;
	  }else return false;  
  }
  
  
 // @Override
 // public void searchResalt(Film film) {
    // TODO Auto-generated method stub

  //}

}
