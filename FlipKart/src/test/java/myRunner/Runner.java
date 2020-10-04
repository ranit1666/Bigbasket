package myRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;


import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)          
@CucumberOptions(
		features = "E:\\Workspace\\FlipKart\\src\\test\\java\\features\\Login.feature", //the path of the feature files
		glue={"stepDefinitions"}, //the path of the step definition files
		plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		//format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false, //to check the mapping is proper between feature file and step def file
		tags = {"~@SmokeTest" , "~@RegressionTest", "@End2End"}	
		
		       )
 


public class Runner {

	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File("./ConfigFiles/extent-config.xml"));
	 Reporter.setSystemInfo("User Name", "AJ");
	 Reporter.setSystemInfo("Application Name", "Test App ");
	 Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	 Reporter.setSystemInfo("Environment", "Production");
	 Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
	
}