package formularios;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://pageresources.000webhostapp.com/test_pages/page_one.html");

			driver.manage().window().maximize();

			Actions key = new Actions(driver);
			key.sendKeys(Keys.PAGE_DOWN).perform();

			WebElement btnAlertSimple = driver.findElement(By.id("buttonAlertSimple"));
			WebElement btnAlertDismiss = driver.findElement(By.id("buttonAlertConfirm"));
			WebElement btnAlertPrompt = driver.findElement(By.id("buttonAlertPrompt"));

			btnAlertSimple.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Interaccion con alertas simples
			Alert alertSimple = wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(1000);
			alertSimple.accept();

			Thread.sleep(3000);
			btnAlertDismiss.click();

			// Interaccion con alertas de aceptar/rechazar
			Alert alertDismiss = wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(1000);
			alertDismiss.dismiss();

			Thread.sleep(3000);
			key.sendKeys(Keys.PAGE_DOWN).perform();
			btnAlertPrompt.click();

			// Interaccion con alertas que solicitan informacion - Opción 1
			Alert alertPrompt = wait.until(ExpectedConditions.alertIsPresent());
			alertPrompt.sendKeys("Hola, alert prompt");
			Thread.sleep(1000);
			alertPrompt.accept();

			Thread.sleep(3000);
			key.sendKeys(Keys.PAGE_DOWN).perform();
			btnAlertPrompt.click();

			// Interaccion con alertas que solicitan informacion - Opción 2
			Alert alertPromptTwo = driver.switchTo().alert();
			alertPromptTwo.sendKeys("Hola, soy el alert prompt No. 2");
			Thread.sleep(1000);
			alertPromptTwo.accept();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
