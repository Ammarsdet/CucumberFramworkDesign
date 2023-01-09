package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboradPage;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagementSteps {
	
	CraterLoginPage craterLogin = new CraterLoginPage();
	CraterDashboradPage dashboard = new CraterDashboradPage();
	BrowserUtils utils  = new BrowserUtils();

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
	    Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	}
	
		@When("user enters valid {string} and {string}")
		public void user_enters_valid_and(String useremail, String password) {
			utils.sendKeysWithActionsClass(craterLogin.useremail, useremail);
			utils.sendKeysWithActionsClass(craterLogin.password, password);
		  
		}
		
	    
	@When("clicks on login button")
	public void clicks_on_login_button() {
		craterLogin.loginButton.click();
	   
	}
	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		utils.waitUntilElementVisible(dashboard.amountDueText);
		Assert.assertTrue(dashboard.amountDueText.isDisplayed());
	    
	}
	
	//invalid login steps
	
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_and(String invalidUseremail, String invalidPassword) {
		utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUseremail);
		utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}

	@Then("an error message appears")
	public void an_error_message_appears() {
	   utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
	   Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
	}

	@Then("user is not logged in")
	public void user_is_not_logged_in() {
		Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
	    Assert.assertTrue(craterLogin.loginButton.isDisplayed());
	    
	}
	
	//invalid login scenario outline
	boolean useremailEmpty;
	boolean passwordEmpty;

	@When("user enters invalid useremail {string} and password {string}")
	public void user_enters_invalid_useremail_and_password(String invalidUseremail, String invalidPassword) {
		useremailEmpty = invalidUseremail.isBlank();
		passwordEmpty = invalidPassword.isBlank();
		
		utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUseremail);
		utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}
	
	@Then("error messages appear")
	public void error_messages_appear() {
		if (useremailEmpty || passwordEmpty) {
			utils.waitUntilElementVisible(craterLogin.fieldRequriedMsg);
		Assert.assertTrue(craterLogin.fieldRequriedMsg.isDisplayed());	
		} else {
			utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
			Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
			
		}
		
	   
	}


}
