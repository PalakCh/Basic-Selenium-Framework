package LearnFramework2.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import LearnFramework2.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1")
	WebElement confirmMessage;
	
	@FindBy(xpath="//label[@class='ng-star-inserted']")
	WebElement ordernumber;
	
	//verify the confirmation message
	
	public String getConfirmMessage()
	{
		return(confirmMessage.getText());
	}
			
	//get the order number
	public String getordernumber()
	{
		return(ordernumber.getText());
	}
			
	
}
