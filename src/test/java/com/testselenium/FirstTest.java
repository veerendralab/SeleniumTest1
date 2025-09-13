package com.testselenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/login"); 
        System.out.println("Opening URL ...");
    }

    @Test
    public void testLogin() {
        WebElement usernameField = driver.findElement(By.name("email")); // Adjust locator as needed
        
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameField.sendKeys("veerenhm@gmail.com");
        System.out.println("Entered User Name");
        passwordField.sendKeys("MyPassword@30");
        System.out.println("Entered Password");
        loginButton.click();
        System.out.println("Clicked on Login Button");
        
        String title = driver.getTitle();
        assertEquals(title, "Automation Exercise");
        System.out.println("Validated Title...");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
