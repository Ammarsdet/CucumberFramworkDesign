package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonMainPage;
import utils.Driver;
import utils.TestDataReader;

public class AmazonSearchSteps {
	
	AmazonMainPage amazonPage = new AmazonMainPage();
	
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
		Driver.getDriver().get(TestDataReader.getProperty("amazonURl"));
	    
	}
	@When("I enter the search term {string}")
	public void i_enter_the_search_term(String item) {
		amazonPage.searchBox.sendKeys(item);
		
	   
	}
	@When("click on search button")
	public void click_on_search_button() {
		
		amazonPage.searchBtn.click();
	    
	}
	@Then("I should see the search item {string} on the search result page")
	public void i_should_see_the_search_item_on_the_search_result_page(String item) {
	  String finalSearchedItemText = amazonPage.searchedItemText.getText().substring(1, item.length()+1);
	  Assert.assertEquals(finalSearchedItemText, item);
	}
	@Then("the page title should conatin the searched {string}")
	public void the_page_title_should_conatin_the_searched(String item) {
	String searchItemPageTitle = Driver.getDriver().getTitle();
	
	Assert.assertEquals(searchItemPageTitle.substring(searchItemPageTitle.length() - item.length()), item);
		
	   
	}



}
