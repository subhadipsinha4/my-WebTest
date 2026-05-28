package com.ad.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterScreen {

    private WebDriver driver;

    public RegisterScreen(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="firstName")
    private WebElement fname;

    @FindBy(id="lastName")
    private WebElement lname;

    @FindBy(xpath = "//input[@placeholder='email@example.com']")
    private WebElement email;

    @FindBy(id="userMobile")
    private WebElement mobile;

    @FindBy(xpath = "//*[@formcontrolname='occupation']")
    private WebElement selectDropDown;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement maleOption;

    @FindBy(id="userPassword")
    private WebElement pass;

    @FindBy(id="confirmPassword")
    private WebElement cPass;

    @FindBy(xpath = "//input[@formcontrolname='required']")
    private WebElement checkBox;

    @FindBy(id="login")
    private WebElement regButton;

    public ProductDetailsScreen registerUser(){
        fname.sendKeys("Amit");
        lname.sendKeys("Bhai");
        email.sendKeys("bhai@gmail.com");
        mobile.sendKeys("8618254173");
        selectDropDown.click();
        Select select=new Select(selectDropDown);
        select.selectByVisibleText("Engineer");
        maleOption.click();
        pass.sendKeys("Amit@123456");
        cPass.sendKeys("Amit@123456");
        checkBox.click();
        regButton.click();
        return new ProductDetailsScreen(driver);
    }

}
