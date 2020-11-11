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
class createAccountTest {
	//declare variables used for testing
	private static ChromeDriver driver;
	private String expected;
	private String actual;
	private WebElement element;
	private static WebDriverWait wait;
	
		@BeforeAll
		public static void setUp() {
			//set up chrome driver object
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 20);
		}
		
		@Test
		@Order(1)
		@SpiraTestCase(testCaseId = 9153)
		public void getURL_Test() {
			//1. go to website
			driver.get("http://automationpractice.com/index.php");
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			actual = "My Store";
			expected = driver.getTitle();
			assertEquals(expected, actual);
		}
		
		@Test
		@Order(2)
		@SpiraTestCase(testCaseId = 9154)
		public void clickSignIn_Test() {
			//2. click on sign in button
			driver.findElementByClassName("login").click();
			
			expected = "Login - My Store";
			actual = driver.getTitle();
			assertEquals(expected, actual);
		}
		
		@Test
		@Order(3)
		@SpiraTestCase(testCaseId = 9155) 
		public void enterEmail_Test(){
			//3. find input box and enter email address
			driver.findElementById("email_create").sendKeys("jeromycassar123@gmail.com");
			driver.findElementById("SubmitCreate").click();
			
			expected = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
			actual = driver.getCurrentUrl();
			assertEquals(expected, actual);
		}
		@Test
		@Order(4)
		@SpiraTestCase(testCaseId = 9158)
		public void enterDetails_Test() {
			//4. enter personal details
			//4.1 click on gender
			driver.findElementById("id_gender1").click();
			//4.2 enter firstname and lastname
			driver.findElementById("customer_firstname").sendKeys("Jeromy");
			driver.findElementById("customer_lastname").sendKeys("Cassar");	
			//4.3 enter password
			driver.findElementById("passwd").sendKeys("password123");
			//4.4.1 select day
			Select day = new Select(driver.findElement(By.id("days")));
			try{Thread.sleep(2000L);}catch(Exception e){}
			day.selectByValue("26");
			try{Thread.sleep(2000L);}catch(Exception e){}
			//4.4.2 select month
			Select month = new Select(driver.findElement(By.id("months")));
			try{Thread.sleep(2000L);}catch(Exception e){}
			month.selectByValue("11");
			try{Thread.sleep(2000L);}catch(Exception e){}
			//4.4.3 select year
			Select year = new Select(driver.findElement(By.id("years")));
			try{Thread.sleep(2000L);}catch(Exception e){}
			year.selectByValue("1998");
			try{Thread.sleep(2000L);}catch(Exception e){}
			//4.4.4 Enter Address
			driver.findElementById("address1").sendKeys("123 La Trobe St");
			//4.4.5 Enter city
			driver.findElementById("city").sendKeys("Melbourne");
			//4.4.6 Select state
			Select state = new Select(driver.findElementById("id_state"));
			try {Thread.sleep(2000L);}catch(Exception e){}
			state.selectByValue("46"); //Virginia
			//4.4.7 Enter postcode
			driver.findElementById("postcode").sendKeys("30000");
			//4.4.8 Enter phone/mobile number
			driver.findElementById("phone_mobile").sendKeys("0423 123 123");
			//4.4.9 Click button
			driver.findElementById("submitAccount").click();
		}
		@Test
		@Order(5)
		@SpiraTestCase(testCaseId = 9156)
		public void checkAccount_Test() {
			wait.until(ExpectedConditions.titleIs("My account - My Store"));
			
			actual = driver.getTitle();
			expected = "My account - My Store";
			assertEquals(expected, actual);
		}
		
		@Test
		@Order(6)
		@SpiraTestCase(testCaseId = 9159)
		public void signOut_Test() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout")));
			driver.findElement(By.className("logout")).click();
			wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account"));
			
			expected = "Login - My Store";
			actual = driver.getTitle();
			assertEquals(expected, actual);
		}
		
		@Test
		@Order(7)
		@SpiraTestCase(testCaseId = 9157)
		public void retryLogin_Test() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
			driver.findElement(By.id("email_create")).sendKeys("jeromycassar123@gmail.com");
			driver.findElementById("SubmitCreate").click();
			
			actual = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
			expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
			assertEquals(expected, actual);
		}
		@AfterAll
		public static void tearDown() {
			//close the browser
			driver.close();
		}
		
		
	}

