package com.rest.api.test.headlessBrowser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/rest-api-project/src/main/resources/drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver chrome = new ChromeDriver(options);
        chrome.get("https://www.google.com");

        System.out.println("Title: " + chrome.getTitle());

        /*chrome.get("https://www.khaledhasan.com");

        System.out.println("Title: " + chrome.getTitle());*/


    }
}
