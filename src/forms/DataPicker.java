package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataPicker {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		try {
			
			driver.get("https://pageresources.000webhostapp.com/test_pages/page_one.html");
			
			driver.manage().window().maximize();
			
			WebElement calendario = driver.findElement(By.xpath("//input[@type='datetime-local']"));
			
			calendario.sendKeys("10/09/2022");
			calendario.sendKeys(Keys.TAB);
			calendario.sendKeys("10:44");
			
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	
	
	}

}
