package LearnFramework2.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearnFramework2.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	


	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath="//div[contains(text(),' Incorrect email or password. ')]")
	WebElement errormessage;
	
	public CatalogPage loginApp(String email,String password)
	{
		useremail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		
		CatalogPage cp=new CatalogPage(driver);
		return cp;
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errormessage);
		return errormessage.getText();
	}
	
	
}
