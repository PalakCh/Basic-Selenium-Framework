package LearnFramework2.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import LearnFramework2.PageObjects.CartPage;
import LearnFramework2.PageObjects.CatalogPage;
import LearnFramework2.PageObjects.CheckoutPage;
import LearnFramework2.PageObjects.ConfirmationPage;
import LearnFramework2.PageObjects.LandingPage;
import LearnFramework2.testcomponents.baseTest;

public class ErrorValidation extends baseTest{
	
	
	@Test(groups= {"errorvalidation"})
	public void errorValidate() throws IOException
	{
		String product="zara coat 3";
		CatalogPage cp=lp.loginApp("palak@abc.com", "@123");
		
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		
				

	}

}
