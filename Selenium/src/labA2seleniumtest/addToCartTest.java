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
class addToCartTest {
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
	@SpiraTestCase(testCaseId = 9210)
	public void clickSignIn_Test() {
		//3. click sign in with blank/empty fields
		driver.findElement(By.id("SubmitLogin")).click();
		
		actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		expected = "An email address required.";
		assertEquals(expected, actual);
	}
	@Order(4)
	@Test
	@SpiraTestCase(testCaseId = 9211)
	public void retryLogin_Test() {
		//4. Enter email and password; redirect to My Account page
		driver.findElement(By.id("email")).sendKeys("jeromycassar123@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("password123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		expected = "My account - My Store";
		actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	@Order(5)
	@Test
	@SpiraTestCase(testCaseId = 9351)
	public void clickLogo_Test() {
		//5. Click on Logo (Home)
		driver.findElement(By.xpath("//*[@id=\'header_logo\']/a")).click();
		
		expected = "http://automationpractice.com/index.php";
		actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	@Order(6)
	@Test
	@SpiraTestCase(testCaseId = 9404)
	public void searchProduct_Test() {
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		driver.findElement(By.name("submit_search")).click();
		
		actual = driver.getTitle();
		expected = "Search - My Store";
		assertEquals(expected, actual);
	}
	@Order(7)
	@Test
	@SpiraTestCase(testCaseId = 9405)
	public void clickMore_Test() {
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div[2]/div[2]/a[2]"))).perform();
		driver.findElement(By.xpath("//*[@id=\'center_column\']/ul/li[1]/div/div[2]/div[2]/a[2]")).click();
		
		expected = "Printed Summer Dress - My Store";
		actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	@Order(8)
	@Test
	@SpiraTestCase(testCaseId = 9406)
	public void chooseOptions_Test() throws Exception {
		//select quantity (7)
		for(int i = 0; i < 6; i++) {
			driver.findElement(By.xpath("//*[@id=\'quantity_wanted_p\']/a[2]")).click(); //click 6 times
		}
		//select size (M)
		Select size = new Select(driver.findElement(By.id("group_1")));
		Thread.sleep(2000L);
		size.selectByValue("2");
		//select color (black)
		driver.findElement(By.id("color_11")).click();
		
		expected = "http://automationpractice.com/index.php?id_product=5&controller=product&search_query=dress&results=7#/color-black/size-m";
		actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	@Order(9)
	@Test
	@SpiraTestCase(testCaseId = 9407)
	public void addToCart_Test() {
		driver.findElement(By.xpath("//*[@id=\'add_to_cart\']/button")).click();
		driver.findElement(By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/a")).click();
		
		expected = "Order - My Store";
		actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	@Order(10)
	@Test
	@SpiraTestCase(testCaseId = 9408)
	public void proceedToCheckout_Test() {
		driver.findElement(By.xpath("//*[@id=\'center_column\']/p[2]/a[1]")).click();
		
		expected = "http://automationpractice.com/index.php?controller=order&step=1";
		actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	@Order(11)
	@Test
	@SpiraTestCase(testCaseId = 9409)
	public void proceedToCheckout2_Test() {
		driver.findElement(By.xpath("//*[@id=\'center_column\']/form/p/button")).click();
		
		expected = "http://automationpractice.com/index.php?controller=order";
		actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	@Order(12)
	@Test
	@SpiraTestCase(testCaseId = 9410)
	public void proceedToCheckout3_Test() {
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
		
		expected = "http://automationpractice.com/index.php?controller=order&multi-shipping=";
		actual = driver.getCurrentUrl();
		assertEquals(expected, actual);
	}
	@Order(13)
	@Test
	@SpiraTestCase(testCaseId = 9411)
	public void choosePayment_Test() {
		driver.findElement(By.xpath("//*[@id=\'HOOK_PAYMENT\']/div[1]/div/p/a")).click(); //pay by bank-wire
		
		expected = "My Store";
		actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	@Order(14)
	@Test
	@SpiraTestCase(testCaseId = 9412)
	public void confirmOrder_Test() {
		driver.findElement(By.xpath("//*[@id=\'cart_navigation\']/button")).click();
		
		expected = "Order confirmation - My Store";
		actual = driver.getTitle();
	}
	@AfterAll
	public static void tearDown() {
		//close the browser
		driver.close();
	}
}
