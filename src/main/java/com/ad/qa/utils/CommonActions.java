package com.ad.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActions {

    public WebDriverWait wait;
    public WebDriver driver;

    public CommonActions(){
        this.driver=driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void waitForElementToBeClickable(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForSometime(long millisecond){
        try {
            Thread.sleep(millisecond);
        }catch (Exception e){

        }
    }


}
