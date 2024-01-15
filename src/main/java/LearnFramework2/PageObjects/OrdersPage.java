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

public class OrdersPage extends AbstractComponents {
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> itemname;
			
	public boolean checkItemExistsInCart(String product)
	{
		boolean itemexists=false;
		for(int i=0;i<itemname.size();i++)
		{
			if (itemname.get(i).getText().equalsIgnoreCase(product))
			{
				System.out.println("Item exists in orderpage");
				itemexists=true;
			}
			
		}
		return itemexists;
		
	}
	
	
}
