package Templates.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Templates.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		String countryName = "ind";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		//LandingPage landingPage= new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("yes.mido22@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("123456Mm@");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//landingPage.loginApplication("yes.mido22@gmail.com", "123456Mm@");
		List<WebElement> products = driver.findElements(By.className("mb-3")); // select all products
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null); // filter by name
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); // click add to cart
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		System.out.println(match);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(countryName);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("ta-results")));
		List<WebElement> countries = driver.findElements(By.className("ta-item"));
		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("india")) {
				country.click();
				break;
			}
		}
		driver.findElement(By.className("action__submit")).click();
		Assert.assertTrue(driver.findElement(By.className("hero-primary")).getText().equalsIgnoreCase("Thankyou for the order.") );
		driver.close();

	}

}
