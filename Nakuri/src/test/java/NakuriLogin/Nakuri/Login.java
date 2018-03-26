package NakuriLogin.Nakuri;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login
{
	public WebDriver driver;
	public ExtentReports reports;
	public String ResultExtentReport="C:\\Users\\shravan\\Desktop\\nakuriReports.html";
	
@Test	
public void nakurilogin() throws Exception
{
	reports=new ExtentReports(ResultExtentReport);
	

	System.setProperty("webdriver.gecko.driver","C:\\Users\\shravan\\Desktop\\selenium\\geckodriver.exe");
	driver=new FirefoxDriver();
	Thread.sleep(3000);
	ExtentTest Test=reports.startTest("nakurilogin");
	
	//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.get("https://www.naukri.com");

  String parenthandle = driver.getWindowHandle();
     String parent = driver.getWindowHandle();

     //close all the pop ups
     Set<String> pops=driver.getWindowHandles();
     Iterator<String> it =pops.iterator();
     while (it.hasNext()){    
        String popupHandle=it.next().toString();
        if(!popupHandle.contains(parent))
        {
        driver.switchTo().window(popupHandle);
        System.out.println("Pop Up Title: "+ driver.switchTo().window(popupHandle).getTitle());
        driver.close();
        }
     }

     System.out.println("the system handle is"+parenthandle);
    Test.log(LogStatus.PASS, "pop ups closed"); 

     driver.switchTo().window(parent);
     
     Thread.sleep(2000);
     driver.findElement(By.linkText("Login")).click();
	driver.findElement(By.name("email")).sendKeys("samshettyshravan19@gmail.com");
	driver.findElement(By.id("pLogin")).sendKeys("shra1raj");
	//driver.findElement(By.linkText("Login")).click();
 
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);		
	
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	System.out.println(" succesfully logged in ");
	Test.log(LogStatus.PASS,"login successfully");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[contains(@href,'//my.naukri.com/Profile/edit?id=&altresid=')]")).click();
	//driver.findElement(By.xpath("//INPUT[contains(@id,'name')]")).clear();
	System.out.println("Snapshot Button clicked");
	Thread.sleep(20000);
	
	//driver.findElement(By.xpath("//INPUT[contains(@id,'name')]")).sendKeys("samshetty shravan ");
	driver.findElement(By.name("name")).clear();
	Thread.sleep(1000);
	
	driver.findElement(By.name("name")).sendKeys("samshetty Shravan");
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[@class='w150bt fl']")).click();
	System.out.println("save button  clicked" );
	

	reports.endTest(Test);
	
	reports.flush();
//driver.get("file:///C:/Users/shravan/Desktop/nakuriReports.htmlw");		
	
}

	
}
