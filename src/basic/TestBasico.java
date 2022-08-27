package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBasico {

	public static void main(String[] args) {

		// Establecer la siguiente línea solo si no está establecida la ruta del driver en el PATH
		// System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://wikipedia.es");
			
			WebElement inputDeBusqueda = driver.findElement(By.id("searchInput"));
			
			inputDeBusqueda.click();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}