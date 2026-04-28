package com.ad.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HealthDrinks {
    private WebDriver driver;

    public HealthDrinks(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Best Health Drinks Online')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@id='product-list-wrap']//h2")
    private List<WebElement> productNames;

    @FindBy(xpath = "//span[@class='sort-name']")
    private WebElement sortOption;

    @FindBy(xpath = "//label[@for='radio_price: low to high_undefined']")
    private WebElement sortLowToHigh;

    @FindBy(xpath = "//div[@id='product-list-wrap']//span[@class='css-111z9ua']")
    private List<WebElement> productPrice;

    public HealthDrinks getPageNameAndDetails(){
        String getTotalCount=pageTitle.getText();
        System.out.println("Total priduct on screen: "+getTotalCount.replaceAll(".*\\((\\d+)\\).*", "$1"));
        Assert.assertTrue(pageTitle.isDisplayed(),"Name is incorrect or not displayed");
        return this;
    }

    public HealthDrinks getAllProductNameOnCurrentPage(){
        System.out.println("Total product name: "+productNames.size());
        for(WebElement e: productNames){
            System.out.println(e.getText());
        }
        return this;
    }

    public HealthDrinks selectSortOption(){
        sortOption.click();
        sortLowToHigh.click();
        return this;
    }

    public HealthDrinks checkProductShownAsPerSortedOrderOrNot() {
        List<Integer> productPriceList=new ArrayList<>();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfAllElements(productPrice));
        for(WebElement e: productPrice){
            productPriceList.add(Integer.valueOf(e.getText().replace("₹","")));
        }
        List<Integer> expectedPriceList=new ArrayList<>(productPriceList);
        Collections.sort(expectedPriceList);
        System.out.println("Price stored: "+productPriceList);
        Assert.assertEquals(productPriceList,expectedPriceList,"Sort is not working");
        return this;
    }
}
