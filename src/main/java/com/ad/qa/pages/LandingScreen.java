package com.ad.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LandingScreen {

    private WebDriver driver;

    public LandingScreen(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[text()='We Make Your Shopping Simple']")
    private WebElement landingText;

    @FindBy(xpath = "//a[@routerlink='/auth/register']")
    private WebElement registerButton;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userPassword")
    private WebElement userPass;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement login;

    public ProductDetailsScreen login(){
        userEmail.sendKeys("bhai@gmail.com");
        userPass.sendKeys("Amit@123456");
        login.click();
        return new ProductDetailsScreen(driver);
    }


    public LandingScreen verifyLandingScreen(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElements(landingText));
        Assert.assertTrue(landingText.isDisplayed());
        return new LandingScreen(driver);
    }

    public RegisterScreen goToRegister(){
        registerButton.click();
        return new RegisterScreen(driver);
    }

}
