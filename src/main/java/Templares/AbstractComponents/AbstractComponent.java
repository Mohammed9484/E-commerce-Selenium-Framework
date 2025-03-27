package Templares.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Templates.PageObjects.CartPage;
import Templates.PageObjects.OrdersPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement ordersHeader;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(ele));

	}


	public void waitForElementToDisappear(WebElement element) throws InterruptedException {
		Thread.sleep(1000);
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//		w.until(ExpectedConditions.invisibilityOf(element));

	}

	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	

	public OrdersPage goToOrdersPage() {
		ordersHeader.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}
	
}
