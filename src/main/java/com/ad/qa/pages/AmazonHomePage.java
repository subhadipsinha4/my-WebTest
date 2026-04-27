package com.ad.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonHomePage {

    private WebDriver driver;

    public AmazonHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='gw-card-layout']//h2")
    private List<WebElement> itemsHeadersName;

    @FindBy(xpath = "//div[@id='gw-card-layout']//div[@class='_Zmx1a_fluidQuadImageLabelBody_3tld0']//span[@class]")
    private List<WebElement> productsName;

    public AmazonHomePage getProductsName(){
        System.out.println("Total Items are: "+itemsHeadersName.size());
        for(WebElement e: itemsHeadersName){
            System.out.println(e.getText());
        }
        System.out.println("Total products name: "+productsName.size());
        for(WebElement e: productsName){
            System.out.println(e.getText());
        }

        return this;
    }


}
