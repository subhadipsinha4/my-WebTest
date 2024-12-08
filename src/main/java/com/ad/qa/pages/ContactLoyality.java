package com.ad.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactLoyality {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='header__inner']//a[contains(text(),\"Contact adjoe\")]")
    public WebElement contactAdjoe;

    @FindBy(xpath = "//button[contains(text(),\"Contact Us\")]")
    public WebElement contactUs;

    @FindBy(xpath = "//div[@id='nf-form-4-cont']//input[@id='nf-field-110']")
    public WebElement companyName;

    @FindBy(xpath = "//h1[contains(text(),'A Little More Conversation')]")
    public WebElement littleText;

    @FindBy(xpath = "//button[contains(text(),'Advertise')]")
    public WebElement advertise;


    public ContactLoyality(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public ContactLoyality moveToNewTap() {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowHandlesList.get(1));
        return new ContactLoyality(driver);
    }

    public ContactLoyality scrollUpTo() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        int i=0;
        while (i<10){
            js.executeScript("window.scrollBy(0, -500);");
            try {
                if(littleText.isDisplayed()) {
                    break;
                }
            }catch (Exception e){}
            i++;
        }

        return this;
    }


    public ContactLoyality fillForm() throws InterruptedException {

        Thread.sleep(2000);
        advertise.click();
        Thread.sleep(2000);

        return this;
    }


}
