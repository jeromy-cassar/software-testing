package labA2seleniumtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;

//integrate SpiraTeam
@SpiraTestConfiguration(
	// following are REQUIRED
	url = "https://rmit-university.spiraservice.net",
	login = "s3717004", 
	rssToken = "{08278C16-D382-460D-A10D-0DAEE5BB4392}", 
	projectId = 466,
	// following are OPTIONAL
	releaseId =  399//, testSetId = 1)	
	)
	
@TestMethodOrder(OrderAnnotation.class)
class removeCartContactUsTest {
	//declare variables used for testing
	private static ChromeDriver driver;
	private String expected;
	private String actual;
	private WebElement element;
	private static WebDriverWait wait;
	private static Actions action;
		
	@BeforeAll
	public static void setUp() {
		//set up chrome driver object
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		action = new Actions(driver);
	}
	
	@Order(1)
	@Test
	public void getURL_Test() {
		//1. go to website
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		actual = "My Store";
		expected = driver.getTitle();
		assertEquals(expected, actual);
	}
	@Order(2)
	@Test
	public void signIn_Test() {
		//2. click on login
		driver.findElementByClassName("login").click();
		actual = driver.getTitle();
		expected = "Login - My Store";
		assertEquals(expected, actual);
	}
	@Order(3)
	@Test
	public void enterAccount_Test() {
		//3. enter account details 
		driver.findElement(By.id("email")).sendKeys("jeromycassar123@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("password123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		expected = "My account - My Store";
		actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	@Order(4)
	@Test
	@SpiraTestCase(testCaseId = 9351)
	public void home_Test() {
		//4. Go to home page
		driver.findElement(By.xpath("//*[@id=\'header_logo\']/a")).click();
		
		expected = "http://automationpractice.com/index.php";
		actual = driver.getCurrentUrl();
		assertEquals(expected, actual);	
	}
	@Order(5)
	@Test
	@SpiraTestCase(testCaseId = 10331)
	public void clickShirts_Test() {
		driver.findElement(By.xpath("//*[@id=\'block_top_menu\']/ul/li[3]/a")).click();
		
		expected = "T-shirts - My Store";
		actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	@Order(6)
	@Test
	@SpiraTestCase(testCaseId = 10332)
	public void invalidOrder_Test() throws Exception {
		//6. Click on quick view and add quantity (0) 
		action.moveToElement(driver.findElement(By.className("quick-view"))).perform();
		driver.findElement(By.className("quick-view")).click();
		driver.findElement(By.id("color_14")).click();
		//double click input
		for(int i = 0; i < 1; i++) {
			driver.findElement(By.id("quantity_wanted")).click();
		}
		driver.findElement(By.id("quantity_wanted")).sendKeys("0");
		driver.findElement(By.xpath("//*[@id=\'add_to_cart\']/button")).click();
		
		expected = "Null quantity.";
		actual = driver.findElement(By.xpath("//*[@id=\'category\']/div[2]/div/div/div/p")).getText();
		assertEquals(expected, actual);
	}
	@Order(7)
	@Test
	@SpiraTestCase(testCaseId = 10334)
	public void retryAddToCart_Test() {
		//7. add item to cart
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li/div/div[2]/div[2]/a[2]"))).perform();
		driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li/div/div[2]/div[2]/a[2]")).click();
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByValue("2");
		driver.findElement(By.xpath("//*[@id=\'add_to_cart\']/button")).click();
		
		boolean cartNum = driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/h2/span[2]")).getText().contains("1");
		assertTrue(cartNum);
	}
	@Order(8)
	@Test
	@SpiraTestCase(testCaseId = 10337)
	public void removeCart_Test() {
		driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/span")).click();
		//9. hover to cart and click 'x'
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\'header\']/div[3]/div/div/div[3]/div/a"))).perform();
		driver.findElement(By.xpath("//*[@id=\'header\']/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span/a")).click();
		
		expected = "(empty)";
		actual = driver.findElement(By.xpath("//*[@id=\'header\']/div[3]/div/div/div[3]/div/a/span[5]")).getText();
		assertEquals(expected, actual);
	}
	@Order(9)
	@Test
	@SpiraTestCase(testCaseId = 10338)
	public void clickContactUs_Test() {
		driver.findElement(By.xpath("//*[@id=\'contact-link\']/a")).click();
		
		expected = "Contact us - My Store";
		actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	@Order(10)
	@Test
	@SpiraTestCase(testCaseId = 10339)
	public void submitForm_Test() throws Exception {
		//10. submit contact form
		Select select = new Select(driver.findElement(By.id("id_contact")));
		Thread.sleep(2000L);
		select.selectByValue("2");
		
		driver.findElement(By.id("message")).sendKeys("This is a test.");
		driver.findElement(By.xpath("//*[@id=\'submitMessage\']")).click();
		
		expected = "http://automationpractice.com/index.php?controller=contact";
		actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	
	@AfterAll
	public static void tearDown() {
		//close the browser
		driver.close();
	}
}
