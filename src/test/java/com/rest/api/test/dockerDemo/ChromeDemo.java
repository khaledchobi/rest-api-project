package com.rest.api.test.dockerDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDemo {

    @Test
    public void testApp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(BrowserType.CHROME);

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);

        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Learn Automation");

        Thread.sleep(5000);

        driver.quit();

    }
}
