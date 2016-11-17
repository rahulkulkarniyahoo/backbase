package pages;

import org.openqa.selenium.WebDriver;

import utility.PageConstants;
import utility.UserUtil;

public class ExistingComputerPage extends Page {

    public ExistingComputerPage(WebDriver driver) {
	super(driver);
    }

    public void clickDeleteButton() {
	driver.findElement(PageConstants.EXISTINGCOMPUTERPAGE_DeleteButton).click();
    }

    public void updateComputerName(String arg1, String arg2) {
	UserUtil.waitForPageUnitElementIsPresent(PageConstants.EXISTINGCOMPUTERPAGE_ComputerName, 1200);
	driver.findElement(PageConstants.EXISTINGCOMPUTERPAGE_ComputerName).clear();
	  driver.findElement(PageConstants.EXISTINGCOMPUTERPAGE_ComputerName).sendKeys(arg2);
	
	
    }

    public void clickSaveThisComputer() {
	driver.findElement(PageConstants.EXISTINGCOMPUTERPAGE_SaveThisComputer).click();
    }

}
