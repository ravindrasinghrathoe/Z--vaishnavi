package Tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc001 {

@Test
	public void login()throws Exception {
		String path = "C:\\New folder\\extentreport\\target\\report\\report.html";
		ExtentReports report = new ExtentReports(path);
		ExtentTest test = report.startTest("tc001");
		WebDriverManager.chromedriver().setup();
		test.log(LogStatus.INFO, "Webdrivermanger setup is successfull");
		WebDriver driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser launch successfull");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser maximum successfull");
		driver.get("https://www.saucedemo.com");
		test.log(LogStatus.INFO, "invoke the url successfull");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		test.log(LogStatus.INFO, "Enter the username successfull");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		test.log(LogStatus.INFO, "Enter the password successfull");
		driver.findElement(By.id("login-button")).click();
		test.log(LogStatus.INFO, "Login successfull");
  if(driver.findElement(By.xpath("//span[@class='title']")).isDisplayed()){
	  test.log(LogStatus.PASS,test.addScreenCapture(Screenshotcapture(driver,"Login Successful"))+"Pass Login is  successfull");
  }
  
  else{
	  test.log(LogStatus.PASS,"Fail Login is not Successfull");
	  
  }
  driver.close();
  report.endTest(test);
  report.flush();
  report.close();
  test.log(LogStatus.INFO,"close the browser");
   
	
}
public String Screenshotcapture(WebDriver driver,String name) throws Exception {
	String path1="C:\\New folder\\extentreport\\target\\report\\"+name+".png";
	File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f1,new File(path1));
	
	return path1;
	
}

}
