package Templates.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Templares.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.xpath("//input[@placeholder='Select
	// Country']")).sendKeys(countryName);
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryName;
//List<WebElement> countries = driver.findElements(By.className("ta-item"));
	@FindBy(className = "ta-item")
	List<WebElement> countries;
	// driver.findElement(By.className("action__submit")).click();
	@FindBy(className = "action__submit")
	WebElement placeOrderB;
	public void selectCountry(String countryShortcut, String selectedCountry) {
		countryName.sendKeys(countryShortcut);
		waitForElementToAppear(By.className("ta-results"));

		for (WebElement countrys : countries) {
			if (countrys.getText().equalsIgnoreCase(selectedCountry)) {
				countrys.click();
				break;
			}
		}

	}

	public OrderPage placeOrder() {
		placeOrderB.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;

	}

}
