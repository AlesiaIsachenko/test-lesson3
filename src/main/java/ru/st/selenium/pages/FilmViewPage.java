package ru.st.selenium.pages;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmViewPage extends AnyPage {

	public FilmViewPage(PageManager pages) {
		super(pages);
	}
	
  public FilmViewPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.id("movie")));
    return this;
  }
 
  @FindBy(linkText = "Home")
  private WebElement goHome;
  
  @FindBy(css = "nav a[href $= '?go=profile']")
  private WebElement userProfileLink;

  @FindBy(css = "nav a[href $= '?go=users']")
  private WebElement userManagementLink;

  @FindBy(css = "nav a[href $= '?logout']")
  private WebElement logoutLink;
  
  @FindBy(css = "img[alt=\"Remove\"]")
  private WebElement remove;
  
  
  public InternalPage clicGoHomeLink() {
	    goHome.click();
	    return pages.internalPage;
	  }
  
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
  
  public InternalPage deleteFilm (){
	  remove.click();
	  wait.until(alertIsPresent()).accept();
	  pages.internalPage.ensurePageLoaded();
	  return pages.internalPage;
  }
  
}