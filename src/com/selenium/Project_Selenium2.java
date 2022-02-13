package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project_Selenium2 {

	public static void main(String[] args) throws IOException   {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\eclipse-workspace\\Mini_Project2\\Driver2\\chromedriver.exe");

		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		WebElement sign = driver.findElement(By.xpath("//a[@class= 'login']"));
		sign.click();
		
		
		WebElement mail = driver.findElement(By.id("email"));
		mail.sendKeys("Tamizh@gmail.com");
		
		WebElement pass = driver.findElement(By.id("passwd"));
		pass.sendKeys("987654321");
		
		
		WebElement submit = driver.findElement(By.id("SubmitLogin"));
		submit.click();
		
		Actions ac = new Actions(driver);
		WebElement Shirt = driver.findElement(By.xpath("(//a[text() = 'T-shirts'])[2]"));
		ac.click(Shirt).build().perform();
		
		
		WebElement newcart = driver.findElement(By.xpath("//a[@title = 'Add to cart']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", newcart);
		js.executeScript("arguments[0].click();", newcart);
		
		WebElement proceed = driver.findElement(By.xpath("//a[@title = 'Proceed to checkout']"));
		proceed.click();
		
		WebElement checkout = driver.findElement(By.xpath("(//a[@title = 'Proceed to checkout'])[2]"));
		checkout.click();
		
		WebElement checkout2 = driver.findElement(By.name("processAddress"));
		checkout2.click();
		
		WebElement agree = driver.findElement(By.name("cgv"));
		agree.click();
		
		WebElement checkout3 = driver.findElement(By.name("processCarrier"));
		checkout3.click();
		
		js.executeScript("window.scrollBy(0, 300);");
		
		WebElement pay = driver.findElement(By.xpath("//a[@class = 'bankwire']"));
		pay.click();
		
		WebElement confirm = driver.findElement(By.xpath("(//button[@type= 'submit'])[2]"));
		confirm.click();
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Mini_Project2\\Screenshot//project.png");
	    FileUtils.copyFile(src, des);
		
		
		
		
		
		
		
	}

}
