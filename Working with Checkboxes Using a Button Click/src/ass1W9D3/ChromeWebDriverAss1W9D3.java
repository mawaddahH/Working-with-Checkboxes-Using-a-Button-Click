package ass1W9D3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeWebDriverAss1W9D3 {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 * 
	 * @throws InterruptedException
	 */

	@BeforeTest
	public void setUp() throws InterruptedException {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://formstone.it/components/checkbox/");
		System.out.println(driver.getTitle());
	}

	/**
	 * Test checkbox
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void LearnEnglishWebSite() throws InterruptedException {

		// check box 1
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
		boolean isCheck1 = checkbox1.isSelected();
		System.out.println("is check box 1 selected  " + isCheck1);
		if (isCheck1) {
			System.out.println("check box 1 is selected by default");
		}
		Thread.sleep(2000);

		// check box 2
		WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='checkbox-2']"));
		boolean isCheck2 = checkbox2.isSelected();
		System.out.println("is check box 2 selected  " + isCheck2);
		if (isCheck2) {
			System.out.println("check box 2 is selected by default");
		} else {
			Actions action = new Actions(driver);
			// Right click
			action.click(checkbox2).build().perform();
			System.out.println("check box 2 is selected manally");

		}
		Thread.sleep(2000);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterTest
	public void terminateBrowser() {
		// Close the browser
		driver.close();

		// Quite the selenium
		driver.quit();
	}
}
