package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmListPage extends AnyPage {

	public FilmListPage(PageManager pages) {
		super(pages);
	}
	
  public FilmListPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.cssSelector("nav")));
    return this;
  }
  
  @FindBy(id = "q")
  private WebElement searchField;
  
  public FilmListPage setSearchField(String text) {
	  searchField.clear();
	  searchField.sendKeys(text);
	  return this;
  }
}
