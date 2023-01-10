package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class AmazonMainPage {
	
	public AmazonMainPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	public WebElement searchBox;
	
	@FindBy (id = "nav-search-submit-button")
	public WebElement searchBtn;
	
	@FindBy (xpath = "//span[@class='a-color-state a-text-bold']")
	public WebElement searchedItemText;

}
