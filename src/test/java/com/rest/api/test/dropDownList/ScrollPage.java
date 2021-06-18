package com.rest.api.test.dropDownList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/rest-api-project/src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");

        String email = "khaledhasanb@gmail.com";
        String password = "khaled1234567890";

        // Create object of WebDriverWait class and it will wait max of 20 seconds.
        // By default it will accepts in Seconds
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Here we will wait until element is not visible, if element is visible then it will return web element
        // or else it will throw exception
        WebElement element = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("header_logo")));

        // if element found then we will use- In this example I just called isDisplayed method
        boolean status = element.isDisplayed();

        // if else condition
        if (status) {
            System.out.println("===== WebDriver is visible======");
        } else {
            System.out.println("===== WebDriver is not visible======");
        }

        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement signIn = driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']"));
        //signIn.click();
        js.executeScript("arguments[0].click();", signIn);

        // Wait for 5 second
        Thread.sleep(5000);

        // This  will scroll page 400 pixel vertical
        js.executeScript("scroll(0,400)");

        Thread.sleep(5000);

        // This  will scroll page 400 pixel vertical
        js.executeScript("scroll(0,0)");

        Thread.sleep(5000);

        WebElement txtBxEmail = driver.findElement(By.xpath("//input[@id='email']"));
        //txtBxEmail.sendKeys(email);
        js.executeScript("arguments[0].value=arguments[1]", txtBxEmail, email);

        WebElement txtBxPassword =driver.findElement(By.xpath("//input[@id='passwd']"));
        //txtBxPassword.sendKeys(password);
        js.executeScript("arguments[0].value=arguments[1]", txtBxPassword, password);


        // This will execute JavaScript in your script
        ((JavascriptExecutor)driver).executeScript("document.getElementById('SubmitLogin').click();");



        driver.close();
    }
}
