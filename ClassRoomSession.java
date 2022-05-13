package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomSession {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// Open a chrome browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL: http://leaftaps.com/opentaps/control/main
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Enter Username as Demosalesmanager
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		WebElement market = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		WebElement currency = driver.findElement(By.id("createLeadForm_currencyUomId"));
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		WebElement stateProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		WebElement country = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select sourceSelect = new Select(source);
		Select marketSelect = new Select(market);
		Select currencySelect = new Select(currency);
		Select industrySelect = new Select(industry);
		Select ownershipSelect = new Select(ownership);
		Select stateProvinceSelect = new Select(stateProvince);
		Select countrySelect = new Select(country);
		sourceSelect.selectByIndex(1);
		marketSelect.selectByVisibleText("Car and Driver");
		currencySelect.selectByValue("INR");

		countrySelect.selectByValue("IND");
		stateProvinceSelect.selectByValue("IN-TN");
		List<WebElement> listOfIndustry = industrySelect.getOptions();
		List<WebElement> listOfOwnership = ownershipSelect.getOptions();
		ownershipSelect.selectByIndex(listOfOwnership.size() - 1);
		System.out.println("The List of Industries");
		for (WebElement eachValue : listOfIndustry) {
			System.out.println(eachValue.getText());

		}

	}

}
