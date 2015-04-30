package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmAddPage extends AnyPage {

	public FilmAddPage(PageManager pages) {
		super(pages);
	}
  
  @FindBy(name = "imdbid")
	private WebElement imdbidField;
	
  @FindBy(name = "name")
	private WebElement titleField;
  
  @FindBy(name = "year")
 	private WebElement yearField;
  
  @FindBy(name = "notes")
 	private WebElement notesField;
 
  @FindBy(id = "submit")
  private WebElement submitButton;

  public FilmAddPage setTitleField(String text) {
	  titleField.sendKeys(text);
	  return this;
  }
  
  public FilmAddPage setYearField(String text) {
	  yearField.sendKeys(text);
	  return this;
  }
  
  public FilmAddPage setNotesField(String text) {
	  notesField.sendKeys(text);
	  return this;
  }

  public void clickSubmitButton() {
	  submitButton.click();
  }
  
  public FilmAddPage ensurePageLoaded() {
	  super.ensurePageLoaded();
	  wait.until(presenceOfElementLocated(By.cssSelector("nav")));
	  return this;
  }
	
}
