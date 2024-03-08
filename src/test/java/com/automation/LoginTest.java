package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		
		
		
	}

}
