package login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	@Test
	public void loginTest() {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
	option.addArguments("--headless=new");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("pradippatil1543@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@1234");
		driver.findElement(By.id("login")).click();
		System.out.println("test run successfully");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = driver.getCurrentUrl();
		String expectedUrl = "https://rahulshettyacademy.com/client/dashboard/dash";
		Assert.assertEquals(url, expectedUrl);
		System.out.println("test run successfully !!!");

	}

}
