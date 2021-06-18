package com.rest.api.test.verifyLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class VerifyHttpLinks_01 {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/khaledhasan/Desktop/Java_Github/Frame_Work/rest-api-project/src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //driver.manage().window().maximize();

        //driver.get("http://www.google.com/");
        //driver.get("http://www.khaledhasan.com/");
        driver.get("http://makemysushi.com/404?");
        //driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");


        // 1. Get the list of all the links and images: 500
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Size of full links and images---> " + linksList.size());

        List<WebElement> activeLinks = new ArrayList<WebElement>(); // 450

        // 2. iterate linksList : exclude all the links/images - doesn't have any href attribute
        for(int i=0; i<linksList.size(); i++){

            System.out.println(linksList.get(i).getAttribute("href"));
            if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript"))){
                activeLinks.add(linksList.get(i));
            }

        }

        System.out.println("Size of active links and images---> " + activeLinks.size());

        /*for (int j=0; j<activeLinks.size(); j++){
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();

            connection.connect();
            String response = connection.getResponseMessage(); // ok
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") + "---->" + response);
        }*/

        for (int j=0; j<activeLinks.size(); j++){

            WebElement ele = activeLinks.get(j);

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
