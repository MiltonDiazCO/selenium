package formularios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://pageresources.000webhostapp.com/test_pages/page_one.html");

			driver.manage().window().maximize();

			List<WebElement> listCheckbox = driver.findElements(By.name("listaCompra"));

			for (WebElement element : listCheckbox) {
				element.click();
				Thread.sleep(2000);
			}

			System.out.println("-----------------");

			listCheckbox.get(0).click();
			listCheckbox.get(3).click();

			for (WebElement element : listCheckbox) {
				// el metodo isSelected(), indica si un check esta seleccionado
				System.out.println(element.isSelected());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
