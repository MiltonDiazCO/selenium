package waits;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.NoSuchElementException;

public class FluentWaitTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("http://localhost/TestSites/Test Page.html");

			driver.manage().window().maximize();

			Actions key = new Actions(driver);
			key.sendKeys(Keys.PAGE_DOWN).perform();

			/*
			 * Fluent Wait aplica un tiempo maximo de espera para validar si un elemento
			 * esta presente, una vez el elemento este presente se continua con la ejecucion
			 * 
			 * Fluent Wait aplica unicamente para los elementos seleccionados
			 * 
			 * FluentWait permite establecer varias configuraciones
			 * 
			 * el metodo withTimeout() establece el tiempo maximo de espera
			 * 
			 * el metodo pollingEvery() pregunta cada cierto tiempo si el elemento ya esta
			 * presente
			 * 
			 * el metodo ignoring() permite ignorer ciertos errores mientras el elemento aun
			 * no esta presente
			 */
			FluentWait<WebDriver> fluentConfig = new FluentWait<WebDriver>(driver);

			fluentConfig.withTimeout(Duration.ofSeconds(10));
			fluentConfig.pollingEvery(Duration.ofSeconds(3));
			fluentConfig.ignoring(NoSuchElementException.class);

			Wait<WebDriver> wait = fluentConfig;

			// cuando se encuentre al elemento, retornara el WebElement
			WebElement boton = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.id("implicitWaitButton"));
				}
			});

			boton.click();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
