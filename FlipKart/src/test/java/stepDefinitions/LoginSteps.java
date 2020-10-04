package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.BaseClass;

public class LoginSteps extends BaseClass
{

	
	@Given("^user opens the browser for BigBasket$")
	public void user_opens_the_browser_for_BigBasket() throws Throwable {
		openbrowser(prop.getProperty("url")); 
		//wait(8000);
		
	}

	@Then("^user login with useremail and password$")
	public void user_login_with_useremail_and_password() throws Throwable {
	    
		
		
	}
	
	
	

	@Then("^user select a product$")
	public void user_select_a_product() throws Throwable {
	    
	}

	@Then("^user adjust the quantity$")
	public void user_adjust_the_quantity() throws Throwable {
	    
	}

	@Then("^user select the pack size$")
	public void user_select_the_pack_size() throws Throwable {
	    
	}

	@Then("^user add the product to basket$")
	public void user_add_the_product_to_basket() throws Throwable {
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
