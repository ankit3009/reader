package Google.com;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumUtils.FieldValue;
import org.junit.*;;

public class GoogleHome {

	static WebDriver driver;
	FieldValue fieldValue;
	WebElement inputTextBox;
	WebElement inputBtnGoogleSrch;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Study\\Documents\\Selenium\\JAR\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		System.out.println("Driver initialized");
	}
	
	@Before
	public void InitializeDriver() throws IOException {
		
		fieldValue= new FieldValue();
		fieldValue.initializeFields();
		if (driver == null){
			System.out.println("Driver is reinitalizing ");
			setUp();
		}
		driver.manage().window().maximize();
		System.out.println("TestCase precondition sets ");
	}
	
	
	@Test
	public void getBrowser() {
		
		
		System.out.println(fieldValue.linkAUT);
		driver.get(fieldValue.linkAUT);
		
		Assert.assertEquals(fieldValue.expectedTitle, driver.getTitle());

		SearchAnkit();
	}
	
	public void SearchAnkit() {
		entryTextBox("Ankit");
		clickOnSearchBtn();
		listOfLinks("kit");
	}
	void listOfLinks(String partialLinktxt) {
		List<WebElement> collection= driver.findElements(By.partialLinkText(partialLinktxt));
		for (WebElement link : collection) {
			System.out.println(link.getText());
		}
		
	}
	
	@Test
	public void testMethod() {
		System.out.println("Second test pass");
	}
	
	@Test
	public 	void testMethod1() {
		System.out.println("Third test pass");
	}
	void entryTextBox(String value) {
		inputTextBox = driver.findElement(By.name(fieldValue.inputTextBoxName));
		inputTextBox.sendKeys(Keys.chord(Keys.SHIFT,value));
		
	}
	
	void clickOnSearchBtn() {
		inputBtnGoogleSrch= driver.findElement(By.name(fieldValue.inputBtnName));
		WebDriverWait wait= new WebDriverWait(driver, 20);
		System.out.println(inputBtnGoogleSrch.getLocation());
		wait.until(ExpectedConditions.elementToBeClickable(inputBtnGoogleSrch));
		Actions act= new Actions(driver);
		act.click(inputBtnGoogleSrch).perform();
		
		
	} 
	
	@After
	public void cleanUpTest() {
		fieldValue=null;
	}
	@AfterClass
	public static void tearDown() {
		
		driver.quit();
	}

}
