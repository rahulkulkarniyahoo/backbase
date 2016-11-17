package utility;

import org.openqa.selenium.By;

public class PageConstants {

    public static final String HOMEPAGE_URL = "http://computer-database.herokuapp.com/computers";
    
    public static final By HOMEPAGE_SearchBox 			= By.id("searchbox");
    public static final By HOMEPAGE_SearchButton 		= By.id("searchsubmit");
    public static final By HOMEPAGE_SearchResultsMessageBottom 	= By.cssSelector("div.well");
    public static final By HOMEPAGE_SearchResultsMessage 	= By.xpath("//section[@id='main']/h1");
    public static final By HOMEPAGE_ComputerCreatedMessage 	= By.xpath("//*[@id='main']/div[1]");
    
    public static final By HOMEPAGE_AddaNewComputer 		= By.id("add");

    public static final By ADDANEWCOMPUTER_ComputerName		= By.id("name");
    public static final By ADDANEWCOMPUTER_IntoducedDate	= By.id("introduced");
    public static final By ADDANEWCOMPUTER_DiscontinuedDate	= By.id("discontinued");
    public static final By ADDANEWCOMPUTER_Company		= By.id("company");
    public static final By ADDANEWCOMPUTER_CreateThisComputer 	= By.cssSelector("input.btn.primary");
    
    public static final By EXISTINGCOMPUTERPAGE_DeleteButton 	=By.cssSelector("input.btn.danger");
    
    public static final By EXISTINGCOMPUTERPAGE_ComputerName	= By.id("name");
    public static final By EXISTINGCOMPUTERPAGE_IntoducedDate	= By.id("introduced");
    public static final By EXISTINGCOMPUTERPAGE_DiscontinuedDate= By.id("discontinued");
    public static final By EXISTINGCOMPUTERPAGE_Company		= By.id("company");
 
    public static final By EXISTINGCOMPUTERPAGE_SaveThisComputer = By.xpath("//input[@value='Save this computer']");
}
