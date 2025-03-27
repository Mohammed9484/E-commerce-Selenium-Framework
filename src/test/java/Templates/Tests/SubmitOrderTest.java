package Templates.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Templates.PageObjects.CartPage;
import Templates.PageObjects.CheckOutPage;
import Templates.PageObjects.OrderPage;
import Templates.PageObjects.OrdersPage;
import Templates.PageObjects.ProductPage;
import Templates.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	public String productName = "ZARA COAT 3";

	@Test(enabled = true, dataProvider = "getData")
	public void submitOrderTest(HashMap<String, String> input) throws InterruptedException, IOException {

		String countryName = "eg";

		ProductPage productPage = landingPage.loginApplication(input.get("email"), input.get("password"));
		// ProductPage productPage = new ProductPage(driver);
		List<WebElement> products = productPage.getProductList();
		productPage.addProductToCart(input.get("product"));
		CartPage cartPage = productPage.goToCartPage();
		// CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.verifyCartProducts(input.get("product"));
		Assert.assertTrue(match);
		System.out.println(match);
		CheckOutPage checkOutPage = cartPage.goToCheckout();
		checkOutPage.selectCountry(countryName, "egypt");
		OrderPage orderPage = checkOutPage.placeOrder();
		Boolean match2 = orderPage.verifyPlaceOrder();
		Assert.assertTrue(match2);

	}

	@Test(enabled = true, dependsOnMethods = { "submitOrderTest" })
	public void orderHistoryTest() {
		landingPage.loginApplication("yes.mido22@gmail.com", "123456Mm@");
		OrdersPage orderPage = landingPage.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "/src/test/java/Templates/Data/PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
