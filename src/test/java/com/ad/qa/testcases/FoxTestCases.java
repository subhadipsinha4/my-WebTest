package com.ad.qa.testcases;

import com.ad.qa.baseTest.StartingSteps;
import com.ad.qa.pages.AmazonHomePage;
import com.ad.qa.pages.LandingPage;
import com.ad.qa.pages.LoginPage;
import com.ad.qa.pages.NayakaHomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class FoxTestCases extends StartingSteps {
    @Test
    @Description("Test")
    public void verifyJobSearch(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.verifyLandingScreen();
    }

    @Test
    public void verifyHomeScreen(){
        AmazonHomePage homePage=new AmazonHomePage(driver);
        homePage.getProductsName();
    }

    @Test
    public void nayakaHomePageTest(){
        NayakaHomePage homePage=new NayakaHomePage(driver);
        homePage.clickOnProduct().getPageNameAndDetails().getAllProductNameOnCurrentPage();

    }
}
