package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		WebElement table = driver.findElement(By.xpath("//div[@class='render']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for (int i = 0; i < rows.size(); i++) {
			if (i == 0) {
				List<WebElement> cols1 = rows.get(i).findElements(By.tagName("th"));
				for (int j = 0; j < cols1.size(); j++) {
					System.out.println(cols1.get(j).getText());

				}
			} else {
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < cols.size(); j++) {
					System.out.println(cols.get(j).getText());

				}
			}

		}

	}

}
