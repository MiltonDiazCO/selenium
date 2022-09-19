package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ImplicitWaitTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		try {
			
			driver.get("https://pageresources.000webhostapp.com/test_pages/page_one.html");
			
			/*
			 * Implicit Wait aplica un tiempo maximo de espera para validar si un
			 * elemento esta presente, una vez el elemento este presente se
			 * continua con la ejecucion
			 * 
			 * Implict Wait se aplica a todos los elementos, es decir que hara una
			 * validacion elemento por elemento
			*/
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			
			Actions key = new Actions(driver);
			key.sendKeys(Keys.PAGE_DOWN).perform();
			
			WebElement implicitWaitButton = driver.findElement(By.id("implicitWaitButton"));
			implicitWaitButton.click();
			
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
