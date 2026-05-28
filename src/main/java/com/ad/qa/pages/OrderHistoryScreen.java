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

public class OrderHistoryScreen {
    private WebDriver driver;

    public OrderHistoryScreen(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@routerlink='/dashboard/myorders']")
    private WebElement clickOrderHistory;

    @FindBy(xpath = "//label[@class='ng-star-inserted']")
    private WebElement orderId;



    public String clickOrderHistory(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfAllElements(orderId));
        String order=orderId.getText().split(" ")[1];
        clickOrderHistory.click();
        return order;
    }

    public String getOrderId(){
        String order=orderId.getText().split(" ")[1];
        return order;
    }




}
