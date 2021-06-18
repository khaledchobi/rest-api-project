package com.rest.api.test.verifyLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class VerifyHttpLinks {
    public static void main(String[] args) {
        /*System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/rest-api-project/src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();*/

        System.setProperty("webdriver.gecko.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/rest-api-project/src/main/resources/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();

        //driver.manage().window().maximize();

        //driver.get("http://www.google.com/");
        //driver.get("http://www.khaledhasan.com/");
        driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
        //driver.get("http://makemysushi.com/404?");


        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links are "+links.size());

        for(int i=0; i<links.size(); i++){

            WebElement ele = links.get(i);

            String url = ele.getAttribute("href");

            verifyLinkActive(url);

        }

        driver.close();

    }

    public static void verifyLinkActive(String linkUrl){
        try{
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            if(httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {

        }
    }

}
