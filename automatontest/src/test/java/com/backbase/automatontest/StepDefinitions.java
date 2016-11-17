
package com.backbase.automatontest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.PageConstants;
import utility.UserUtil;

import pages.HomePage;
import pages.AddANewComputer;
import pages.ExistingComputerPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	public WebDriver driver;
	public DesiredCapabilities caps;
	HomePage hPage;
	AddANewComputer aancPage;
	ExistingComputerPage ecPage;
	
	ExtentReports 	report;
	ExtentTest 	logger;
	
	
	@After 
	public void tearDown(Scenario scenario){
		if (scenario.isFailed()) {

				System.out.println(" *******************************************");
				System.out.println(" ***************Test Failed !***************");
				System.out.println(" *******************************************");
				String screenshot_path = System.getProperty("user.dir")+"/"+UserUtil.takeScreenShot(scenario.getName());
				System.out.println("@@@@@@@@@@@@   Screenshot path = " + screenshot_path);
				
				System.out.println(" scenario.getSourceTagNames()" + scenario.getSourceTagNames());
				System.out.println(" scenario.getName()" + scenario.getName());
				System.out.println(" scenario.getId()" + scenario.getId());
				
				String image = logger.addScreenCapture(screenshot_path);
				
				
				logger.log(LogStatus.FAIL, "Verification", image);
		
		}
		System.out.println(".... Test Ends .... ");
		report.endTest(logger);
		report.flush();
		//driver.get("/src/com/resources/"+"LearnHTML.html");
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		driver.close();
	}

	@Before 
	public void setUp() throws Exception{
		
		System.out.println("************  user dir :" + System.getProperty("user.dir"));
		System.out.println("**********    user dir :" + System.getProperty("user.home"));

	   
		if (System.getProperty("os.name").contains("Mac")){
		System.out.println("Hello Mac Operating System");
		System.setProperty("webdriver.chrome.driver",  "src/test/resources/chromedriver");
	}
	    else if (System.getProperty("os.name").contains("Windows")){
				System.out.println("Hello Windodws Operating System");
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			}
	    	
	driver = new ChromeDriver();
/*		System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver");
		driver = new FirefoxDriver();*/
			hPage = new HomePage(driver);
			report = new ExtentReports("src/com/resources/"+"LearnHTML.html");
			logger = report.startTest("I am on Test Main Page");
			logger.log(LogStatus.INFO, "Browser Started");
			
			System.out.println(".... Test Begins ...");
	    }
	
	
    
    @Given("^I am on test main page$")
    public void i_am_on_test_main_page() throws Throwable {

	
	hPage.loadPage();
	try{
	Assert.assertTrue(driver.getTitle().contains("a"));
	logger.log(LogStatus.PASS, "Title Verified");
	System.out.println("PAAAAAAASSSSSSEEEEEEDDDDDDD");
	String screenshot_path = System.getProperty("user.dir")+"/"+UserUtil.takeScreenShot("I am on test main page");
	    String image = logger.addScreenCapture(screenshot_path);
		logger.log(LogStatus.PASS, "Verification", image);
	}
	catch (AssertionError ae){
	    System.out.println("****** AE Failed **********");
	    logger.log(LogStatus.FAIL, "Title NOT Verified");  
		String screenshot_path = System.getProperty("user.dir")+"/"+UserUtil.takeScreenShot("I am on test main page");
	    String image = logger.addScreenCapture(screenshot_path);
		logger.log(LogStatus.FAIL, "Verification", image);
	}
    }
    
    
    @When("^I search for computer \"([^\"]*)\"$")
    public void i_search_for_computer(String arg1) throws Throwable {
	hPage.clearSearchBox();
	hPage.searchComputer(arg1);

    }
   
    
    @When("^click on search button$")
    public void click_on_search_button() throws Throwable {
       hPage.clickSearchButton();

        
    }
    
    @Then("^i can verify that the computer does not exist$")
    public void i_can_verify_that_the_computer_does_not_exist() {
	hPage.verifyMessageHead("No computers found");
	hPage.verifyMessageFoot("Nothing to display");
	
	System.out.println("No computers found - Confirmed");
	
    }	
    
    
    @When("^I click on Add a new computer button$")
    public void i_click_on_Add_a_new_computer_button() throws Throwable {
	System.out.println("I click on Add a new computer button");
	aancPage  = hPage.clickAddANewComputer();
    }
    	
    @When("^Enter valid data values for \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void enter_valid_data_values_for(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	aancPage.AddNewComputerValues(arg1,arg2, arg3, arg4);
    }
    
    @When("^Click on Create this computer button$")
    public void click_on_Create_this_computer_button() throws Throwable {
	System.out.println("Click on Create this computer button");
	hPage = aancPage.clickCreateThisComputer();
    }
    
    @Then("^I can verify \"([^\"]*)\" has been added$")
    public void i_can_verify_has_been_added(String arg1) throws Throwable {
	hPage.messageContains(arg1);
    }
    
    @Then("^I can click on the computer \"([^\"]*)\"$")
    public void i_can_click_on_the_computer(String arg1) throws Throwable {
	 ecPage = hPage.clickComputerName(arg1);
    }


    @Then("^I can verify \"([^\"]*)\" has been deleted$")
    public void i_can_verify_has_been_deleted(String arg1) throws Throwable {
	    hPage.messageContains(arg1);
	    System.out.println(arg1 + " has been deleted - Confirmed");
    }

    @Then("^I can delete the computer$")
    public void i_can_delete_the_computer() throws Throwable {
	ecPage.clickDeleteButton();
    }
   
    @Then("^I can update the \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_can_update_the_to(String arg1, String arg2) throws Throwable {
	ecPage.updateComputerName(arg1, arg2);
	ecPage.clickSaveThisComputer();
    }

    @Then("^I can verify \"([^\"]*)\" has been updated$")
    public void i_can_verify_has_been_updated(String arg1) throws Throwable {
	hPage.messageContains(arg1);
    }

    
    
    
}
	


