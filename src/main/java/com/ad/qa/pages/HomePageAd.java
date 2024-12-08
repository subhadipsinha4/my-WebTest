package com.ad.qa.pages;

import com.ad.qa.baseTest.StartingSteps;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageAd {

    WebDriver driver;

    @FindBy(xpath = "//a[@title='adjoe Home']")
    public WebElement homeIcon;

    @FindBy(xpath = "//div[@class='header__inner']//a[contains(text(),'Solutions')]")
    public WebElement solutionFromNav;

    @FindBy(xpath = "//div[@class='header__inner']//a[contains(text(),'Loyalty')]")
    public WebElement loyalityFromNavMenu;

    @FindBy(xpath = "//p[@class='_brlbs-refuse-btn']")
    public WebElement dismissCokkies;





 public HomePageAd(WebDriver driver){
     this.driver=driver;
     PageFactory.initElements(driver,this);
 }


 public HomePageAd verifyHomeIcon(){
     Assert.assertEquals(homeIcon.isDisplayed(),true,"Icon is not showing up");
     return this;
 }

 public LoyalityPage hoverOverOnSolutionAndClickLoyality() throws InterruptedException {
    Actions actions=new Actions(driver);
    actions.moveToElement(solutionFromNav).perform();
    Thread.sleep(3000); // waitUntile element is not visible
    actions.moveToElement(loyalityFromNavMenu).click().perform();
     return new LoyalityPage(driver);
 }

 public HomePageAd dismissCookies(){
     dismissCokkies.click();
     return this;
 }






}
