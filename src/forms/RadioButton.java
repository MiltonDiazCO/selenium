package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://pageresources.000webhostapp.com/test_pages/page_one.html");

			driver.manage().window().maximize();

			WebElement aguaButton = driver.findElement(By.xpath("//input[@name='bebida' and @value='agua']"));
			aguaButton.click();

			Thread.sleep(2000);
			
			WebElement pastaButton = driver.findElement(By.xpath("//input[@value='pasta']"));
			pastaButton.click();
			
			WebElement btnRadioButton = driver.findElement(By.id("enviaRadiobutton"));
			btnRadioButton.click();
			
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
