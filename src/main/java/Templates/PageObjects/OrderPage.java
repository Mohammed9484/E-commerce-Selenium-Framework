package Templates.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Templares.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public Boolean verifyPlaceOrder() {
		Boolean match= driver.findElement(By.className("hero-primary")).getText().equalsIgnoreCase("Thankyou for the order.");
		return match;

	}

}
