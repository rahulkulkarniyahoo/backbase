package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utility.PageConstants;
import utility.UserUtil;


public class AddANewComputer extends Page{

    public AddANewComputer(WebDriver driver) {
	super(driver);
    }

    public void AddNewComputerValues(String arg1, String arg2, String arg3, String arg4) {


	 driver.findElement(PageConstants.ADDANEWCOMPUTER_ComputerName).sendKeys(arg1);

	 driver.findElement(PageConstants.ADDANEWCOMPUTER_IntoducedDate).sendKeys(arg2);

	 driver.findElement(PageConstants.ADDANEWCOMPUTER_DiscontinuedDate).sendKeys(arg3);


	 Select ddEXISTINGCASE_DD_SupplierParty = new Select(driver.findElement(PageConstants.ADDANEWCOMPUTER_Company));
	 ddEXISTINGCASE_DD_SupplierParty.selectByVisibleText(arg4);

	
    }

    public HomePage clickCreateThisComputer() {
	driver.findElement(PageConstants.ADDANEWCOMPUTER_CreateThisComputer).click();
	UserUtil.waitForPageUnitElementIsPresent(PageConstants.HOMEPAGE_SearchBox, 120);
	return new HomePage(driver);
    }
    
    

}
