package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
//https://automationexercise.com/login
public class LoginTest {
	WebDriver driver;
	String url = "https://automationexercise.com/";
	String signUpEmail = "tester202403071801@email.com";
	
	@Test
	public void loginTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//===> Home page
		driver.get(url);	
		//Click login/signup button
		driver.findElement(By.xpath("//a[@href='/login']")).click();
//this works too	driver.findElement(By.cssSelector("div.col-sm-8 >div > ul > li:nth-child(4) > a")).click();
		
		//===> Login/Signup page
		//New User Signup!
		driver.findElement(By.name("name")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(signUpEmail);
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		
		//Enter Account Information page
		driver.findElement(By.id("id_gender1")).click();
		//Enter paswwore
		driver.findElement(By.xpath("//*[@data-qa='password']")).sendKeys("test123");
		
		WebElement dayDD = driver.findElement(By.xpath("//*[@data-qa='days']"));
		Select daySelect = new Select(dayDD);
		daySelect.selectByVisibleText("10");
		
		WebElement monthDD = driver.findElement(By.xpath("//select[@data-qa='months']"));
		Select monthSelect = new Select(monthDD);
		monthSelect.selectByVisibleText("April");
		
		WebElement yearsDD = driver.findElement(By.xpath("//select[@data-qa='years']"));
		Select yearsSelect = new Select(yearsDD);
		yearsSelect.selectByVisibleText("2000");
		
	}

}
