package StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import LearnFramework2.PageObjects.CartPage;
import LearnFramework2.PageObjects.CatalogPage;
import LearnFramework2.PageObjects.CheckoutPage;
import LearnFramework2.PageObjects.ConfirmationPage;
import LearnFramework2.PageObjects.LandingPage;
import LearnFramework2.testcomponents.baseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends baseTest{
	
	public LandingPage landingpg;
	public CatalogPage catalogpg;
	public CartPage cartpg;
	public CheckoutPage checkoutpg;
	public ConfirmationPage confirmpg;
	
	@Given("I landed on Ecommerce website")
	public void I_landed_on_Ecommerce_website() throws IOException
	{
		landingpg=launchApplication();
		
	}
	
	//Given Logged in with username <name> and password <password>
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password)
	{
		catalogpg=lp.loginApp(username, password);
	}
	
	//When  I add product <productname> to the cart
	@When("^I add product (.+) to the cart$")
	public void when_i_add_product_to_the_cart(String productname)
	{
		List<WebElement> products=catalogpg.getproductslist();
		catalogpg.searchAndAddProductToCart(productname);
		cartpg=catalogpg.goToCart();
		boolean checkitem=cartpg.checkItemExistsInCart(productname);
		Assert.assertTrue(checkitem);
		
	
	}
	
	//And Checkout <productname> and submit the order
	@When("^Checkout (.+) and submit the order$")
	public void when_checkout_product_and_submit_the_order(String productname)
	{
		CartPage cop=cartpg.goToCart();
		boolean checkitem=cop.checkItemExistsInCart(productname);
		Assert.assertTrue(checkitem);
		checkoutpg=cop.clickCheckOut();
		
		//select country
		String country="India";
		checkoutpg.selectcountry(country);
		 confirmpg=checkoutpg.clickorderconfirm();
	}
	
	
    //Then "THANKYOU FOR THE ORDER" message is displayed
	@Then ("{string} message is displayed on confirmation page")
	public void then_message_is_displayed_confirmation_page(String string)
	{
		//verify the confirmation message
		String ConfirmationMessage=confirmpg.getConfirmMessage();
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase(string));
				
		//get the order number
		System.out.println(confirmpg.getordernumber());
		driver.close();
	}
	
	// Then "Incorrect email or password." message is displayed
	@Then ("{string} message is displayed")	
	public void then_message_is_displayed(String str1)
	{
		Assert.assertEquals(str1, lp.getErrorMessage());
		driver.close();
	}
	
	
	

}
