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

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartitems;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkout;
		
	public boolean checkItemExistsInCart(String product)
	{
		boolean itemexists=false;
		for(int i=0;i<cartitems.size();i++)
		{
			if (cartitems.get(i).getText().equalsIgnoreCase(product))
			{
				System.out.println("Item exists in cart");
				itemexists=true;
			}
			
		}
		return itemexists;
		
	}
	
	public CheckoutPage clickCheckOut()
	{
		checkout.click();
		CheckoutPage ck=new CheckoutPage(driver);
		return ck;
	}
	
	
	
	
	
	
	
	
	
}
