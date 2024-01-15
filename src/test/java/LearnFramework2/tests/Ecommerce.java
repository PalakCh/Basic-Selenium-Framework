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
import LearnFramework2.PageObjects.OrdersPage;
import LearnFramework2.testcomponents.baseTest;

public class Ecommerce extends baseTest{
	
	
	@Test
	public void submitOrder() throws IOException
	{
		String product="zara coat 3";
		CatalogPage cp=lp.loginApp("palak@abc.com", "Password@123");
		List<WebElement> products=cp.getproductslist();
		cp.searchAndAddProductToCart(product);
		CartPage cop=cp.goToCart();
		boolean checkitem=cop.checkItemExistsInCart(product);
		Assert.assertTrue(checkitem);
		CheckoutPage ck=cop.clickCheckOut();
		
		//select country
		String country="India";
		ck.selectcountry(country);
		ConfirmationPage conp=ck.clickorderconfirm();
			
		//verify the confirmation message
		String ConfirmationMessage=conp.getConfirmMessage();
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		//get the order number
		System.out.println(conp.getordernumber());
				

	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void validateOrdersPage()
	{
		String product="zara coat 3";
		CatalogPage cp=lp.loginApp("palak@abc.com", "Password@123");
		OrdersPage op=cp.goToOrders();
		Assert.assertTrue(op.checkItemExistsInCart(product));
		
	}

}
