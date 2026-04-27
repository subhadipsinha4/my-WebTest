package com.ad.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
}
