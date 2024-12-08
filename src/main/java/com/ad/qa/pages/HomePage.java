package com.ad.qa.pages;

import com.ad.qa.baseTest.StartingSteps;
import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends StartingSteps {

    @FindBy(xpath = "//img[@role='presentation']")
    private WebElement pageIcon;

    @FindBy(xpath="//form[@action='search']//input")
    private WebElement searchBox;

    @FindBy(xpath="//span[text()='Style']")
    private WebElement styleButton;

    @FindBy(xpath="//span[text()='Create a design']")
    private WebElement crateDesignButton;

    public void HomePage(){
        PageFactory.initElements(driver,this);
    }

    @Description("Check page icon is display or not")
    public boolean isPageIconDisplay(){
        return pageIcon.isDisplayed();
    }

    public void enterSearchQueryAndSearch(){
        searchBox.click();
        searchBox.sendKeys("Resume"+Keys.ENTER);
        //searchBox.sendKeys(Keys.ENTER);

    }

    public void clickOnStyle(){
        styleButton.click();
    }

    public void clickOnCreateDesign(){
        crateDesignButton.click();
    }




}
