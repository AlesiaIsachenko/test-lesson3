package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;

public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}
	
  public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.cssSelector("nav")));
    return this;
  }
  
  @FindBy(css = "nav a[href $= '?go=profile']")
  private WebElement userProfileLink;

  @FindBy(css = "nav a[href $= '?go=users']")
  private WebElement userManagementLink;

  @FindBy(css = "nav a[href $= '?logout']")
  private WebElement logoutLink;
  
  @FindBy(css = "img[alt=\"Add movie\"]")
  private WebElement filmAdd;
  
  @FindBy(className = "movie_box")
  private WebElement movie_box;
  
  public UserProfilePage clickUserProfilePage() {
    userProfileLink.click();
    return pages.userProfilePage;
  }

  public UserManagementPage clickUserManagementLink() {
    userManagementLink.click();
    return pages.userManagementPage;
  }
  
  public LoginPage clickLogoutLink() {
    logoutLink.click();
    wait.until(alertIsPresent()).accept();
    return pages.loginPage;
  }
  
  public FilmAddPage clickFilmAdd() {
	  	filmAdd.click();
	    return pages.filmAddPage;
	  }
  
  public FilmViewPage selectFilm(Film film){
	  driver.findElement(By.xpath("//div [@alt = '" + film.getTitle()+ "']")).click();
	  return pages.filmViewPage;
  }
  
  public int count_movie_box(){
	  return driver.findElements(By.className("movie_box")).size();
  }
  
}
