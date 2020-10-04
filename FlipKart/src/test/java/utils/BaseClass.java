package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;	
	public String filename="config.properties";

	public BaseClass()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\ConfigFiles\\"+filename);

			prop.load(fis);
		} catch (FileNotFoundException e) 
		{

			e.printStackTrace();
		} catch (IOException e) 
		{

			e.printStackTrace();
		}



	}

	public static void openbrowser(String url)
	{
		String BrowserName=prop.getProperty("browser");

		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();		
		}

		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
           driver=new FirefoxDriver();	*/	
		}

		else if(BrowserName.equalsIgnoreCase("IE"))
		{
			/*System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
           driver=new InternetExplorerDriver();		*/
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);

	}

	public void wait(int time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getReportConfigPath()
	{
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	}

	public void waitForElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeClickable(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
	}

	public void waitForVisibilityOfElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForVisibilityOfElement(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	}

	public void moveToElementAndClick(WebElement ele)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).click().build().perform();
	}


	public void scrollIntoView(WebElement element)
	{
		JavascriptExecutor js=	(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	public void moveToElement(WebElement element)
	{
		Actions oactions=new Actions(driver);	
		oactions.moveToElement(element).perform();

	}


	public void clickUsingJavascriptExecutor(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
	}
	
	
	
	
	
	
	

}
