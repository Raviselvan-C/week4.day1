package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement table = driver.findElement(By.xpath("//section[@class='innerblock']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			if (i == 0) {
				List<WebElement> cols = rows.get(i).findElements(By.tagName("th"));
				System.out.println("Table Heading");
				for (int j = 0; j < cols.size(); j++) {
					System.out.println(cols.get(j).getText());
				}
			} else {
				System.out.println("Table row no : " + i);
				List<WebElement> cols2 = rows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < cols2.size(); j++) {
					if (j == 2) {
						cols2.get(j).click();
					} else {
						System.out.println(cols2.get(j).getText());
					}
				}
			}
		}
	}

}
