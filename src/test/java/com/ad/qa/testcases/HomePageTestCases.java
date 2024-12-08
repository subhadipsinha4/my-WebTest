package com.ad.qa.testcases;

import com.ad.qa.baseTest.StartingSteps;
import com.ad.qa.pages.DrapAndDropPage;
import com.ad.qa.pages.HomePageAd;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class HomePageTestCases extends StartingSteps {

    public HomePageTestCases(){
    }

    @Description("test Revenue Estimation And Submit")
    public void testRevenueEstimationAndSubmit() throws InterruptedException {

        HomePageAd homePageAd=new HomePageAd(driver);
        homePageAd.dismissCookies()
                .verifyHomeIcon()
                .hoverOverOnSolutionAndClickLoyality()
                .verifyArcadeButtonIsShown()
                .clickOnCommonActionButton()
                .moveToNewTap()
                .scrollUpTo()
                .fillForm();

        Thread.sleep(4000);

    }

    public void testDragAndDropTest() throws InterruptedException {
        DrapAndDropPage drapAndDropPage=new DrapAndDropPage(driver);
        drapAndDropPage.moveElements();

    }

    public void testAlert(){
        DrapAndDropPage drapAndDropPage=new DrapAndDropPage(driver);
        drapAndDropPage.verifyAlert();
    }

    @Test
    public void formFillUp() throws InterruptedException {
        DrapAndDropPage drapAndDropPage=new DrapAndDropPage(driver);
        drapAndDropPage.fillForm();
    }
}

