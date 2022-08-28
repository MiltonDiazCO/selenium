package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("http://localhost/TestSites/Test%20Page.html");

			driver.manage().window().maximize();

			Actions key = new Actions(driver);
			key.sendKeys(Keys.PAGE_DOWN).perform();

			/*
			 * Explicit Wait aplica un tiempo maximo de espera para validar si un elemento
			 * cumple con cierta condicion
			 * 
			 * Explicit Wait aplica unicamente para los elementos seleccionados
			 */
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// en este caso validara hasta que el elemento este disponible para hacer clic
			WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.id("explicitWaitButton")));

			boton.click();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
