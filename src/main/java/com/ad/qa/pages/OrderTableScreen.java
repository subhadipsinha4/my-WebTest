package com.ad.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderTableScreen {
    private WebDriver driver;

    public OrderTableScreen(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> orderItems;

    public OrderSummary verifyOrderAndClickonView(String order){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElements(orderItems));
        for(WebElement e: orderItems){
            if(e.findElement(By.cssSelector("th")).getText().equals(order)){
                e.findElement(By.xpath("//button[text()='View']")).click();
            }
        }
        return new OrderSummary(driver);
    }
}
