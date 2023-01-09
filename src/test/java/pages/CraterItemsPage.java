package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CraterItemsPage {
	
	public CraterItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//h3[text()='Items']")
	public WebElement itemsHeaderText;
	
	@FindBy(xpath = "//button[text()=' Add Item']")
	public WebElement addItemBtn;
	
	@FindBy(xpath = "//button[text()='Filter ']")
	public WebElement filterItemBtn;
	
	@FindBy(xpath = "//div[@name='name']/input")
	public WebElement filterNameField;
	
	
	//add item window 
	@FindBy (xpath = "//h3[text()='New Item']")
	public WebElement addNewItemHeader;
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	public WebElement addNewItemNameField;
	
	@FindBy (xpath = "//div[@class='flex flex-col mt-1']/input")
	public WebElement addNewItemPriceField;
	
	@FindBy (xpath = "(//div[@class='flex flex-col mt-1']/div/input)[2]")
	public WebElement addNewItemUnitField;
	
	@FindBy (xpath = "//textarea[@name='description']")
	public WebElement addNewItemDescriptionField;
	
	@FindBy (xpath = "//button[text()=' Save Item']")
	public WebElement saveNewItemBtn;
	
	@FindBy (xpath = "//span[text()='pc']")
	public WebElement pc_unit;
	
	@FindBy (xpath ="//p[text()='Item created successfully']")
	public WebElement createdItemSuccessMessage;

}
