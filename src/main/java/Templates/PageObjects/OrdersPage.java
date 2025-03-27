package Templates.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Templares.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//td:nth-child(3)
	@FindBy(css = "td:nth-child(3)")
	List<WebElement> ordersNames;
	
	public Boolean verifyOrderDisplay(String orderName) {
		
	Boolean match=	ordersNames.stream().anyMatch(order ->order.getText().equalsIgnoreCase(orderName));
		return match;
	}

	

}
