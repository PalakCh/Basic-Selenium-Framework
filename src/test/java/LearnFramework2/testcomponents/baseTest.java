package LearnFramework2.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import LearnFramework2.PageObjects.LandingPage;

public class baseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException
	{
				
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//LearnFramework2//resources/globaldata.properties");
		prop.load(fis);
		
		String browser=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browser.contains("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			
			if (browser.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		lp=new LandingPage(driver);
		lp.goTo();	
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeDriver()
	{
		driver.close();
	}
	
	public String takeScreenshort(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot s=(TakesScreenshot)driver;
		File source=s.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		
		FileHandler.copy(source, destination);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
		
	}

}
