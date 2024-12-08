package com.ad.qa.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class StartingSteps {

   public static WebDriver driver;
   public static Properties prop;

   public StartingSteps(){
       prop=new Properties();

   }

   public void readData(){
       try{
           InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
           prop.load(inputStream);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @BeforeMethod
    public void setUpBase() throws InterruptedException {
        readData();
        String browser=prop.getProperty("browser");
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("urlForm"));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }


//    @AfterMethod
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
