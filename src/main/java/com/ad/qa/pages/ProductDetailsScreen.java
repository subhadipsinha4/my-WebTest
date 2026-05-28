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

public class ProductDetailsScreen {
    private WebDriver driver;

    public ProductDetailsScreen(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".card-body")
    private List<WebElement> productName;

    @FindBy(id="res")
    private WebElement noOfProduct;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    private WebElement cart;

    public ProductDetailsScreen selectProduct(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(productName));
        String value=noOfProduct.getText().split(" ")[1];
        System.out.println(value);
        for(WebElement e: productName){
            if(e.findElement(By.cssSelector("h5 b")).getText().equals("IPHONE 13 PRO")){
                    e.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
                    System.out.println("Inside");
                    break;
            }
        }
        return this;
    }

    public CartScreen clickOnCart(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
        return new CartScreen(driver);
    }

}
