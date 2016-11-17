package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Page;

public class UserUtil extends Page{
	
	public UserUtil(WebDriver driver) {
		super(driver);

	}

	public static WebElement waitForPageUnitElementIsPresent(By locator, int maxSeconds) {
		return (new WebDriverWait(driver, maxSeconds))
				.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
	}
	
	
	public static String dateGenerator(String sDatePaperPurchased){
		System.out.println("Arrived: UserUtil: dateGenerator");

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		
		if (sDatePaperPurchased!=""){
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(df.parse(reportDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			int iDatePaperPurchased = Integer.parseInt(sDatePaperPurchased);
			c.add(Calendar.DATE, iDatePaperPurchased);  // number of days to add
			reportDate = df.format(c.getTime());
			System.out.println("Now the reportDate = " + reportDate);
			System.out.println("Departed: UserUtil: dateGenerator");
			return reportDate;
			
		}
		else{
			System.out.println("Departed: UserUtil: dateGenerator");
			return reportDate;
		}
		
	}
	
	public static String getCurrentDate() {
		System.out.println("Arrived: UserUtil: getCurrentDate");

		String PATTERN="dd/MM/yyyy";
		SimpleDateFormat dateFormat=new SimpleDateFormat();
		dateFormat.applyPattern(PATTERN);
		System.out.println(dateFormat.format(Calendar.getInstance().getTime()));
		System.out.println("Departed: UserUtil: getCurrentDate");
		return dateFormat.format(Calendar.getInstance().getTime());
		
	}
	
	public static String takeScreenShot(String name) {
		System.out.println("Arrived: UserUtil: takeScreenShot, name =" + name);
		
		String fileName = null;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		if (name.substring(name.length()-1).equals(".")){
			name = name.substring(0, name.length()-1);
			fileName = name + timeStamp + ".png";
			fileName = fileName.replace(" ", ""); // Remove spaces for the FileName
			System.out.println("FileName = " + fileName);
		}
		else{
			fileName = name+ timeStamp+  ".png";
			fileName = fileName.replace(" ", ""); // Remove spaces for the FileName
			System.out.println("FileName = " + fileName);}
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		
		try {
			FileUtils.copyFile(scrFile, new File ("src/com/resources/" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" ******** ERROR: Screenshot has been placed in src/com/resources/ FOLDER !!  ********");
		System.out.println("Departed: UserUtil: takeScreenShot");
		return "src/com/resources/" + fileName;
	}
	
	public static boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
}
