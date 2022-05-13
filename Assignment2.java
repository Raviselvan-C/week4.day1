package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Launch the URL https://www.chittorgarh.com/
		driver.get("https://html.com/tags/table/");
		WebElement table = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		List<WebElement> row = table.findElements(By.tagName("tr"));
		List<WebElement> cols = row.get(1).findElements(By.tagName("td"));
		System.out.println("Number of rows : " + row.size());
		System.out.println("Number of columns : " + cols.size());

	}

}
