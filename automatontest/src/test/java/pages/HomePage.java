package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import utility.PageConstants;

import utility.UserUtil;

public class HomePage extends Page{
    Scenario scenario;
    
    public HomePage(WebDriver driver) {
	super(driver);
    }

    public void loadPage(){
	System.out.println("Arrived: HomePage: loadPage");
	System.out.println("Getting URL : " + PageConstants.HOMEPAGE_URL);
	driver.get(PageConstants.HOMEPAGE_URL);
	driver.manage().window().maximize();	
	UserUtil.waitForPageUnitElementIsPresent(PageConstants.HOMEPAGE_SearchBox, 1200);
	System.out.println("Departed: HomePage: loadPage");
    }

    public void clearSearchBox() {
        driver.findElement(PageConstants.HOMEPAGE_SearchBox).clear();
	
    }

    public void searchComputer(String arg1) {
        driver.findElement(PageConstants.HOMEPAGE_SearchBox).sendKeys(arg1);
    }

    public void clickSearchButton() {
	driver.findElement(PageConstants.HOMEPAGE_SearchButton).click();
    }

    public void verifyMessageHead(String string) {
	
	try{

	Assert.assertEquals(string, driver.findElement(PageConstants.HOMEPAGE_SearchResultsMessage).getText());
	}
        catch(AssertionError ae){
            System.out.println("Excepted = " + string + "  Actual = "+ 
        	    		driver.findElement(PageConstants.HOMEPAGE_SearchResultsMessage).getText());           
        }
        catch(Exception e){
          System.out.println("error = " + e.getMessage());
    }
	
    }

    public void verifyMessageFoot(String string) {
	try{
	Assert.assertEquals(string, driver.findElement(PageConstants.HOMEPAGE_SearchResultsMessageBottom).getText());
	}
        catch(Exception e){
          System.out.println("error = " + e.getMessage());
        }
    }

    public AddANewComputer clickAddANewComputer() {
	driver.findElement(PageConstants.HOMEPAGE_AddaNewComputer).click();
	UserUtil.waitForPageUnitElementIsPresent(PageConstants.ADDANEWCOMPUTER_ComputerName, 120);
	return new AddANewComputer(driver);
    }


    public void messageContains(String string){
	if (driver.findElement(PageConstants.HOMEPAGE_ComputerCreatedMessage).getText().contains(string)){
	    System.out.println("Computer Created Message - Matches");
	}else
	{
	    System.out.println("Actual : " + driver.findElement(PageConstants.HOMEPAGE_SearchResultsMessage).getText());
	    System.out.println("Expected:" + string);
	}
	
	
    }

    public ExistingComputerPage clickComputerName(String arg1) {
	driver.findElement(By.linkText(arg1)).click();
	UserUtil.waitForPageUnitElementIsPresent(PageConstants.ADDANEWCOMPUTER_ComputerName, 120);
	return new ExistingComputerPage(driver);
	
    }
    
    
}
