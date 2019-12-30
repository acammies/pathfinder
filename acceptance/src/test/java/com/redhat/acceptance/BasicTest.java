package com.redhat.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class BasicTest{
//  public static final String FIREFOX_DRIVER="/home/mallen/Work/pathfinder-ng/acceptance/geckodriver-linux-0.20.1";
//  public static final String CHROME_DRIVER="/home/mallen/Work/pathfinder-ng/acceptance/chromedriver-linux-2.41";
  
  @Test
  public void site_header_is_on_home_page(){
    WebDriver browser;
    
//    boolean useFirefox=false;
//    if (useFirefox){
//      FirefoxOptions o=new FirefoxOptions();//.setBinary(FIREFOX_DRIVER);
//      o.setBinary("/usr/bin/firefox");
//      o.setCapability("platformName", Platform.LINUX);
////    o.setCapability("browserName", "firefox");
//      o.setAcceptInsecureCerts(true);
//      
////    System.out.println(o.toJson());
//      
//      System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER);
//      browser=new FirefoxDriver(o);
//      
//    }else{
    // System.setProperty("webdriver.chrome.driver", "chromedriver-linux-2.41");
    System.setProperty("webdriver.chrome.driver", "chromedriver-79.0.3945.36-osx");
    
//      System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
      ChromeOptions o=new ChromeOptions();
//      o.setBinary("/usr/bin/google-chrome-stable");
      o.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
//      o.addArguments("--headless");
      o.addArguments("--disable-extensions"); // disabling extensions
      o.addArguments("--disable-gpu"); // applicable to windows os only
      o.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
      o.addArguments("--no-sandbox");
      browser=new ChromeDriver(o);
      
//    }
    

    

    //Firefox's proxy driver executable is in a folder already
    //  on the host system's PATH environment variable.
    browser.get("http://saucelabs.com");
    WebElement header=browser.findElement(By.id("cookieconsent:desc"));
    assertTrue((header.isDisplayed()));

    browser.close();
  }
}
