package com.ad.qa.pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoyalityPage {
    WebDriver driver;

    public LoyalityPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Try adjoe Arcade')]")
    public WebElement arcadeButton;

    @FindBy(xpath = "//div[@class='b-floating-circles__wrapper']//a[contains(text(),'Get a revenue estimation')]")
    public WebElement revenueEstimation;


    public LoyalityPage verifyArcadeButtonIsShown(){
        Assert.assertEquals(arcadeButton.isDisplayed(),true,"NOt showing up");
        return this;
    }

    public ContactLoyality clickOnCommonActionButton() throws InterruptedException {

        // Scroll Option 1
//        Actions actions=new Actions(driver);
//        actions.scrollToElement(revenueEstimation).perform();
//        revenueEstimation.click();

        // Scroll option 2

        JavascriptExecutor js=(JavascriptExecutor) driver;
        int i=0;
        while (i<10){
            js.executeScript("window.scrollBy(0, 250);");
            try {
                if(revenueEstimation.isDisplayed()) {
                    break;
                }
            }catch (Exception e){}
            Thread.sleep(1000);
            i++;
        }

        if(revenueEstimation.isDisplayed()){
            revenueEstimation.click();
        }
        return new ContactLoyality(driver);

    }

}
