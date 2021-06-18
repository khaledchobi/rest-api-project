package com.rest.api.test.dropDownList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropDownList {

    // ArrayList > Collection
    // How to dropdown
    // Collections

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/rest-api-project/src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?id_category=3&controller=category");

        //driver.get("http://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");


        // selectProductSort
        Select tools = new Select(driver.findElement(By.id("selectProductSort")));

        List actualList = new ArrayList();

        List<WebElement> myTools=tools.getOptions();

        for(WebElement ele:myTools) {

            String data = ele.getText();
            actualList.add(data);
        }

        List temp = new ArrayList();

        temp.addAll(actualList);

        // Ascending Order
        Collections.sort(temp);
        Collections.sort(actualList);

        System.out.println(temp);
        System.out.println(actualList);

        Assert.assertTrue(actualList.equals(temp));

        driver.close();
    }
}
