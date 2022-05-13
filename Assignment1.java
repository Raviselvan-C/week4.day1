package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");

		// Click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();

		// Click on NSE bulk Deals
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();

		// create webelement for table
		WebElement table = driver
				.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped'] "));
		// create a list using the table row
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// declare a variable to check for duplicates
		int Duplicate = 0;

		// Iterate the row list
		for (int i = 1; i < rows.size(); i++) {
			for (int j = i + 1; j < rows.size(); j++) {
				List<WebElement> cols1 = rows.get(i).findElements(By.tagName("td"));
				List<WebElement> cols2 = rows.get(j).findElements(By.tagName("td"));
				String a = cols1.get(2).getText();
				String b = cols2.get(2).getText();
				if (a.equals(b)) {
					Duplicate++;
				}
			}
		}

		// Ensure whether there are duplicate Security names
		if (Duplicate > 0) {
			System.out.println("Duplicates are present in the Security Names");
		}

	}

}
