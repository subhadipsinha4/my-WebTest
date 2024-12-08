package com.ad.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.plaf.TableHeaderUI;

public class DrapAndDropPage {

    WebDriver driver;

    public DrapAndDropPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement source;

    @FindBy(id = "dragBox")
    public WebElement source1;

    @FindBy(id = "notGreedyInnerDropBox")
    public WebElement destination1;

    @FindBy(xpath="//div[@id='droppable']")
    public WebElement destination;

    @FindBy(xpath="//*[contains(text(),'Dropped')]")
    public WebElement dropped;

    @FindBy(xpath="//a[@id='droppableExample-tab-preventPropogation']")
    public WebElement preventTap;

    @FindBy(xpath="//button[@id='promtButton']")
    public WebElement promtButton;

    @FindBy(xpath="//label[text()='Male']")
    public WebElement genderMale;

    @FindBy(id="dateOfBirthInput")
    public WebElement datePicker;

    @FindBy(xpath="//select[@class='react-datepicker__month-select']")
    public WebElement months;

    @FindBy(xpath="//select[@class='react-datepicker__year-select']")
    public WebElement years;

    @FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--025']")
    public WebElement date;

    @FindBy(xpath="//input[@id='uploadPicture']")
    public WebElement uploadPicture;

    @FindBy(xpath="//div[@id='state']")
    public WebElement state;

    @FindBy(xpath="//div[text()='Select State']")
    public WebElement textBoxState;

    @FindBy(xpath = "//div[text()='Uttar Pradesh']")
    public WebElement placeName;



    public DrapAndDropPage moveElements() throws InterruptedException {
        Actions actions=new Actions(driver);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250);");
        actions.dragAndDrop(source,destination).perform();
        Assert.assertEquals(dropped.isDisplayed(),true,"not dropped");
        Thread.sleep(2000);

        preventTap.click();
        actions.clickAndHold(source1).moveToElement(destination1).release().build().perform();
        return this;
    }

    public void verifyAlert() {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        promtButton.click();
        Alert alert=driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.sendKeys("Happy");
        alert.accept();
    }

    public void fillForm() throws InterruptedException {
        JavascriptExecutor je=(JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,350);");
        Thread.sleep(2000);
        genderMale.click();
        datePicker.click();

        months.click();
        Select select=new Select(months);
        select.selectByVisibleText("August");

        years.click();
        Select select1=new Select(years);
        select1.selectByVisibleText("1994");
        date.click();

        je.executeScript("window.scrollBy(0,250);");

    }
}
