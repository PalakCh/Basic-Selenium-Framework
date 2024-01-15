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

public class CatalogPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CatalogPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//section[@id='products']")
	WebElement productssection;
	
	@FindBy(xpath="//div[@class='card'] //b")
	List<WebElement> products;
	
	@FindBy(xpath="//div[@class='card'] //button[@class='btn w-10 rounded']")
	List<WebElement> productsaddtocart;
	
	@FindBy(css=".ng-animating")
	WebElement loading;
	
		
	public List<WebElement> getproductslist()
	{
		waitForElementToAppear(productssection);
		return products;
	}
	
	public void searchAndAddProductToCart(String product)
	{

		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getText().equalsIgnoreCase(product))
			{
				productsaddtocart.get(i).click();
			}
		}
		waitForElementToDisappear(loading);
	}
	
	
	
	
	
	
	
}
