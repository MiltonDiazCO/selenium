package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TestCaseOne {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void testForms() {
		driver.get("https://pageresources.000webhostapp.com/test_pages/page_one.html");

		driver.manage().window().maximize();

		String expectedText = "El usuario es: Usuario 10 y el password: 1234";
		String fetchedText = "";

		WebElement txtUserName = driver.findElement(By.id("username"));
		WebElement txtPassword = driver.findElement(By.id("password"));
		WebElement btnShowAlert = driver.findElement(By.id("mostrarAlert"));
		WebElement btnLogin = driver.findElement(By.id("botonLogin"));
		WebElement result = driver.findElement(By.id("resultado"));

		txtUserName.sendKeys("Usuario 10");
		txtPassword.sendKeys("1234");

		btnShowAlert.click();
		btnLogin.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Alert alertUser = wait.until(ExpectedConditions.alertIsPresent());
		alertUser.accept();

		fetchedText = result.getText();

		assertEquals(expectedText, fetchedText);
	}

	@After
	public void shutdown() {
		driver.quit();
	}

}
