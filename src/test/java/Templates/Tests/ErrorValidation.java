package Templates.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Templates.PageObjects.CartPage;
import Templates.PageObjects.CheckOutPage;
import Templates.PageObjects.OrderPage;
import Templates.PageObjects.ProductPage;
import Templates.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	@Test
	public void loginErrorValidation() throws InterruptedException, IOException{
		landingPage.loginApplication("yes.mido22@gmail.com", "12345556Mm@");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
	}
	@Test
	public void productErrorValidation() throws InterruptedException, IOException{
		
		
		String productName = "ZARA COAT 3";
		ProductPage productPage = landingPage.loginApplication("yes.mido22@gmail.com", "123456Mm@");
		productPage.addProductToCart(productName);
		CartPage cartPage = productPage.goToCartPage();
		Boolean match = cartPage.verifyCartProducts("ZARA COAT 33");
		Assert.assertFalse(match);
		
		

	}

}
