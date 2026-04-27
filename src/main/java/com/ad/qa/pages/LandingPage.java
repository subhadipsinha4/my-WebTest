package com.ad.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.ad.qa.baseTest.StartingSteps.driver;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//img[@alt='FOX Careers Logo']")
    WebElement foxLogo;

    public LandingPage verifyLandingScreen(){
        Assert.assertTrue(foxLogo.isDisplayed());
        return this;
    }



}
