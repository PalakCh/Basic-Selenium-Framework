package LearnFramework2.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LearnFramework2.PageObjects.CartPage;
import LearnFramework2.PageObjects.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement Cart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement myorders;
	
	
	public CartPage goToCart()
	{
		Cart.click();
		CartPage cop=new CartPage(driver);
		return cop;
	}
	
	public OrdersPage goToOrders()
	{
		myorders.click();
		OrdersPage op=new OrdersPage(driver);
		return op;
	}
	
	public void waitForElementToAppear(WebElement we1)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(we1));
	}
	public void waitForElementToDisappear(WebElement we2)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(we2));
	}
	

}
