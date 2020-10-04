package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class Home extends BaseClass
{
	
	
	static String expectedPrice="";
	String newProQty="";
	
	
	
	
	
	
	@FindBy(xpath="//input[@id='input']")
     WebElement search;
	
	@FindBy(xpath="//input[@id='input']/parent::div/child::div/button")
    WebElement searchIcon;
	
	@FindBy(xpath="(//p[text()='You are viewing our product catalogue in'])[1]")
    WebElement locationNotification;
	
	@FindBy(xpath="(//a[text()='Continue'])[1]")
    WebElement btn_Continue;
	
	@FindBy(xpath="(//a[text()='Change Location'])[1]")
    WebElement btn_ChangeLocation;
	
	@FindBy(xpath="//p[text()='Select your city to start shopping']/following-sibling::form/descendant::input[1]")
    WebElement btn_selectLocation;
	
	@FindBy(xpath="//p[text()='Select your city to start shopping']/following-sibling::form/descendant::ul/descendant::span")
    WebElement label_selectLocation;
	
	@FindBy(xpath="//p[text()='Select your city to start shopping']/following-sibling::form/descendant::span[text()='Select your city']/following-sibling::span/span")
    WebElement label_defaultCity;
	
	@FindBy(xpath="//span[text()='1860 123 1000']/ancestor::li/following-sibling::li/div/a")
    WebElement link_Location;
	
	@FindBy(xpath="//input[@id='areaselect']")
    WebElement input_area;
	
	@FindBy(xpath="(//button[text()='Continue'])[1]")
    WebElement btn_locationContinue;
	
	@FindBy(xpath="//span[text()='My Basket']")
    WebElement label_MyBasket;
	
	@FindBy(xpath="//div[@class='product-name']/a")
    WebElement label_BasketProductDescription;
	
	@FindBy(xpath="//input[@ng-model='cartItem.quantity']")
    WebElement label_BasketProductQty;
	
	@FindBy(xpath="//span[@qa='priceMB']")
    WebElement label_BasketProdutPrice;
	
	@FindBy(xpath="//span[@qa='subTotalMB']")
    WebElement label_BasketSubtotal;
	
	@FindBy(xpath="//button[@qa='incQtyMB']")
    WebElement btn_MyBasketIncrease;
	
	@FindBy(xpath="//button[@qa='decQtyMB']")
    WebElement btn_MyBasketDecrease;
	
	public Home()
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	
	public void search(String item)
	{
		waitForVisibilityOfElement(search);
		search.sendKeys(item);
	}
	
	public void clickSearch()
	{
		waitForElementToBeClickable(searchIcon);
		moveToElementAndClick(searchIcon);
		
	}
	
	public void selectProduct(String product,String productQty,String quantity)
	{
		wait(20000);
		List<WebElement> allProducts= driver.findElements(By.xpath("//div[@qa='product_name']"));
		for(int i=1;i<=allProducts.size();i++)
		{
		By productxpath=By.xpath("(//div[@qa='product_name'])["+i+"]/child::a");
		
		WebElement productName=driver.findElement(productxpath);
		
		if(product.contains(productName.getText()))
		{
			
			WebElement dropdown= driver.findElement(By.xpath("(//div[@qa='product_name'])["+i+"]/following-sibling::div[1]/descendant::button[1]"));
			wait(2000);
			scrollIntoView(dropdown);
			
			//moveToElementAndClick(dropdown);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
			// wait(10000);
			 List<WebElement> noOfproductQty=driver.findElements(By.xpath("(//div[@qa='product_name'])["+i+"]/following-sibling::div[1]/descendant::ul/li/a"));
				for(int j=1;j<=noOfproductQty.size();j++)
				{
					
				WebElement proQty=driver.findElement(By.xpath("(//div[@qa='product_name'])["+i+"]/following-sibling::div[1]/descendant::ul/li["+j+"]/a/span[1]"));
				String actualQty=proQty.getText();
				if(productQty.equals(actualQty))
					{
					wait(2000);
					//moveToElementAndClick(proQty);
					WebElement label_productPrice=driver.findElement(By.xpath("(//div[@qa='product_name'])["+i+"]/following-sibling::div[1]/descendant::ul/li["+j+"]/a/span[3]"));
					expectedPrice=label_productPrice.getText();
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", proQty);
					break;
					}
				}
				
				int qty=Integer.parseInt(quantity);  //qty refers to the number of product user adds 2 cart
				if(qty>1)
				{
					WebElement input_qty=driver.findElement(By.xpath("(//div[@qa='product_name'])["+i+"]/following-sibling::div[2]/descendant::input[1]"));
					input_qty.clear();
					wait(1000);
					String qtyValue=String.valueOf(qty);
					input_qty.sendKeys(qtyValue);
				}
				wait(4000);
				WebElement btn_addToCart=driver.findElement(By.xpath("(//div[@qa='product_name'])["+i+"]/following-sibling::div[2]/descendant::button[1]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_addToCart);
				//moveToElementAndClick(btn_addToCart);
				
				break;
			}
		
		}
		
		
	}
	
	
	public void verifyLocationPopupisDisplayed()
	{
		waitForVisibilityOfElement(locationNotification);
		if(locationNotification.isDisplayed())
		Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
		
	}
	
	public void selectCity(String city)
	{
		waitForVisibilityOfElement(locationNotification);
		if(locationNotification.isDisplayed())
		{
			moveToElementAndClick(btn_ChangeLocation);
			wait(2000);
			while(!label_defaultCity.getText().equalsIgnoreCase(city))
			{
				label_defaultCity.click();	
			driver.findElement(By.xpath("//p[text()='Select your city to start shopping']/following-sibling::form/descendant::ul/descendant::span[text()='"+city+"']")).click();
			break;
			}
			
		}	
		
		else
		{
			moveToElementAndClick(link_Location);
			btn_selectLocation.click();	
			driver.findElement(By.xpath("//p[text()='Select your city to start shopping']/following-sibling::form/descendant::ul/descendant::span[text()='"+city+"']")).click();
			
		}	
			
		
	}
	
	public void selectArea(String locationInfo,String area)
	{
		waitForVisibilityOfElement(input_area);
		input_area.clear();
		input_area.sendKeys(locationInfo);
		wait(2000);
		input_area.sendKeys(Keys.ENTER);
		//WebElement areaValue=driver.findElement(By.xpath("//input[@id='areaselect']/following-sibling::ul/child::li[contains(text(),'"+area+"')]"));
		//moveToElementAndClick(areaValue);
	}
	
	
	public void clickLocationContinue()
	{
		waitForElementToBeClickable(btn_locationContinue);
		moveToElementAndClick(btn_locationContinue);
	}
	
	
	public void hoverToMyBasket()
	{
		waitForElementToBeClickable(label_MyBasket);
		moveToElementAndClick(label_MyBasket);
		
	}
	
	public void verifyProductQtyInBasket(String qty)
	{
		waitForVisibilityOfElement(label_BasketProductQty);
		String proQty=label_BasketProductQty.getAttribute("value");
		Assert.assertEquals(qty, proQty);
	}
	
	public void verifySizeOfProductInBasket(String qty)
	{
		waitForVisibilityOfElement(label_BasketProductDescription);
		String text=label_BasketProductDescription.getText();
		if(text.contains(qty))
		    Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
	
	public void verifyMyBasketPrice()
	{
		waitForVisibilityOfElement(label_BasketProdutPrice);
		String actualProductPrice=label_BasketProdutPrice.getText();
		Assert.assertEquals(expectedPrice, actualProductPrice);
	}
	
	
	public void verifyBasketSubtotal(String qty)
	{
		waitForVisibilityOfElement(label_BasketProdutPrice);
		float totalQty=Float.parseFloat(qty);
		float expectedProductPrice=Float.parseFloat(expectedPrice);
		float subtotal=(totalQty*expectedProductPrice);
		System.out.println(subtotal);
		String actualSubtotal=label_BasketSubtotal.getText();
		float actualProductSubtotal=Float.parseFloat(actualSubtotal);
		System.out.println(actualProductSubtotal);
		//Assert.assertEquals(subtotal, actualProductSubtotal);
		Assert.assertEquals(subtotal, actualProductSubtotal, 0.0f);
	}
	
	
	public void increasedQty(String qty)
	{
		waitForVisibilityOfElement(label_BasketProductQty);
		String proQty=label_BasketProductQty.getAttribute("value");
		int newQty=Integer.parseInt(proQty);
		int expectedQty=Integer.parseInt(qty);
		while(newQty!=expectedQty)
		{
			wait(2000);
			clickUsingJavascriptExecutor(btn_MyBasketIncrease);
			newQty++;
		}
		wait(10000);
		System.out.println(newQty);
	    newProQty=String.valueOf(newQty);
		verifyBasketSubtotal(newProQty);
		
		
		
	}
	
	public void decreasedQty(String qty)
	{
		waitForVisibilityOfElement(label_BasketProductQty);
		String proQty=label_BasketProductQty.getAttribute("value");
		int newQty=Integer.parseInt(proQty);
		int expectedQty=Integer.parseInt(qty);
		while(newQty!=expectedQty)
		{
			wait(12000); //committed by archan
			clickUsingJavascriptExecutor(btn_MyBasketDecrease);
			newQty--;
		}

		wait(100000); //committed by archan
System.out.println(newQty);
	    newProQty=String.valueOf(newQty);
		verifyBasketSubtotal(newProQty);
		
		//comment added by ranit
		
	}
	
	
	
}
