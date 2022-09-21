package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://pageresources.000webhostapp.com/test_pages/page_one.html");

			driver.manage().window().maximize();

			WebElement txtUserName = driver.findElement(By.id("username"));
			WebElement txtPassword = driver.findElement(By.cssSelector("#password"));
			WebElement btnLogin = driver.findElement(By.id("botonLogin"));

			Thread.sleep(2000);

			txtUserName.sendKeys("Usuario");
			txtPassword.sendKeys("password");
			btnLogin.click();

			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
