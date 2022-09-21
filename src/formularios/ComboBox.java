package formularios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ComboBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://pageresources.000webhostapp.com/test_pages/page_one.html");

			driver.manage().window().maximize();

			Select selectSimple = new Select(driver.findElement(By.id("combobox1")));

			selectSimple.selectByIndex(2);

			Thread.sleep(2000);

			Select selectMultiple = new Select(driver.findElement(By.id("combobox2")));

			selectMultiple.selectByIndex(0);
			selectMultiple.selectByValue("pera");
			selectMultiple.deselectByVisibleText("Plátano");

			Thread.sleep(3000);

			selectMultiple.deselectByIndex(0);

			WebElement btnCombobox = driver.findElement(By.id("enviaComboboxes"));

			btnCombobox.click();

			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
