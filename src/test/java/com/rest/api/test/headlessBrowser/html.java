package com.rest.api.test.headlessBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class html {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://www.google.com");

        System.out.println("Title: " + driver.getTitle());


        /*HtmlUnitDriver driver = new HtmlUnitDriver(true);
        driver.setJavascriptEnabled(false);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.co.in/");
        System.out.println(driver.getTitle());*/



    }


}

// When I have to use HtmlUnitDriver I have to remove selenium java dependency in POM.xml