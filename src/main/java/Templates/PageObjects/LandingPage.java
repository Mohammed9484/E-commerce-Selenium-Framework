package Templates.PageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Templares.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;
//div[aria-label='Incorrect email or password.']
	@FindBy(css = "div[aria-label='Incorrect email or password.']" )
	WebElement errorMessage;
	
	public ProductPage loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submitButton.click();
		ProductPage productPage = new ProductPage(driver);
		return productPage;

		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		String error=errorMessage.getText();
		return error;
		
	}
}
