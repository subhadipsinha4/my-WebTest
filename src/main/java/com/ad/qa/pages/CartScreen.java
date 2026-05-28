package com.ad.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartScreen {
    private WebDriver driver;

    public CartScreen(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//select[@class='input ddl'][1]")
    private WebElement selectMonth;

    @FindBy(xpath = "//select[@class='input ddl'][2]")
    private WebElement selectYear;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    private WebElement country;

    @FindBy(xpath = "//span[text()=' India']")
    private WebElement conu;

    @FindBy(xpath = "//*[text()='Place Order ']")
    private WebElement placeOrder;

    public OrderHistoryScreen clickOnCartAndPaymentDetails(){
        checkoutButton.click();
        Select selectmon=new Select(selectMonth);
        selectmon.selectByVisibleText("08");
        Select selectyr=new Select(selectYear);
        selectyr.selectByVisibleText("31");
        country.sendKeys("India");
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfAllElements(conu));
        conu.click();
        placeOrder.click();
        return new OrderHistoryScreen(driver);
    }
}
