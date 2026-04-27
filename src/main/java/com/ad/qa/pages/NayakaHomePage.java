package com.ad.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NayakaHomePage {
    private WebDriver driver;

    public NayakaHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Health & Wellness']")
    private WebElement healthWellness;

    @FindBy(xpath = "//div[@class='MegaDropdown-ContentInner bgWhite']//a[text()='Health Drinks']")
    private WebElement healthDrinks;

    public HealthDrinks clickOnProduct(){
        Actions actions=new Actions(driver);
        String currentWindow=driver.getWindowHandle();
        actions.moveToElement(healthWellness).perform();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(healthDrinks));
        healthDrinks.click();
        for(String window: driver.getWindowHandles()){
            if(!currentWindow.equals(window)){
                driver.switchTo().window(window);
                break;
            }
        }
        return new HealthDrinks(driver);
    }
}
