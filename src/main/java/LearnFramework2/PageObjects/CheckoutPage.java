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

import LearnFramework2.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']")
	WebElement countrysection;
	
	@FindBy(xpath="//button[@class='ta-item list-group-item ng-star-inserted']//span")
	List<WebElement> countrychoice;
	
	@FindBy(xpath="//a[contains(text(),'Place Order ')]")
	WebElement orderconfirm;
	
	public void selectcountry(String cou)
	{
		country.sendKeys(cou);
		waitForElementToAppear(countrysection);
		
		for(int i=0;i<countrychoice.size();i++)
		{
			if(countrychoice.get(i).getText().equalsIgnoreCase(cou))
			{
				countrychoice.get(i).click();
			}
		}
		
	}
	
	public ConfirmationPage clickorderconfirm()
	{
		orderconfirm.click();
		ConfirmationPage conp=new ConfirmationPage(driver);
		return conp;
	}
	
		
	
	
	
}
