package stepDefinitions;

import cucumber.api.java.en.Then;
import pages.Home;
import utils.BaseClass;

public class HomeSteps extends BaseClass
{
	Home objHome;
	
	@Then("^user search for a product$")
	public void user_search_for_a_product() throws Throwable {
	  
		objHome= new Home();
		objHome.search(prop.getProperty("item1"));
		objHome.clickSearch();
		objHome.selectProduct(prop.getProperty("productName"),prop.getProperty("productQty"),prop.getProperty("Quantity"));
	}	
	
	
	@Then("^user verify if location popup is present$")
	public void user_verify_if_location_popup_is_present() throws Throwable {
	    
		objHome.verifyLocationPopupisDisplayed();
		
	}
	
	@Then("^user select city$")
	public void user_select_city() throws Throwable {
	    
		objHome.selectCity(prop.getProperty("city"));	
		
	}

	@Then("^user select delivery area$")
	public void user_select_delivery_area() throws Throwable {
	   
		objHome.selectArea(prop.getProperty("location"), prop.getProperty("areaOption"));
		
	}

	@Then("^user click continue button after area selection$")
	public void user_click_continue_button_after_area_selection() throws Throwable {
	   
		objHome.clickLocationContinue();
		
		
	}
	
	
	@Then("^user verify product details in cart$")
	public void user_verify_product_details_in_cart() throws Throwable {
	    
		objHome.hoverToMyBasket();
		objHome.verifyProductQtyInBasket(prop.getProperty("Quantity"));
		objHome.verifySizeOfProductInBasket(prop.getProperty("productQty"));
		objHome.verifyMyBasketPrice();
		
	}

	@Then("^user verify subTotal in cart$")
	public void user_verify_subTotal_in_cart() throws Throwable {
	   
		objHome.verifyBasketSubtotal(prop.getProperty("Quantity"));
		
	}

	@Then("^user increase product qty and verify subtotal$")
	public void user_increase_product_qty_and_verify_subtotal() throws Throwable {
	    
		objHome.increasedQty(prop.getProperty("increasedQty"));
		
	}

	@Then("^user decrease product qty and verify subtotal$")
	public void user_decrease_product_qty_and_verify_subtotal() throws Throwable {
	   
		objHome.decreasedQty(prop.getProperty("decreasedQty"));
		
	}
	
	
	
}
