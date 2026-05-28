package com.ad.qa.testcases;

import com.ad.qa.baseTest.StartingSteps;
import com.ad.qa.pages.LandingPage;
import com.ad.qa.pages.LandingScreen;
import com.ad.qa.pages.OrderHistoryScreen;
import com.ad.qa.pages.OrderTableScreen;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class OnlineShopping extends StartingSteps {
    @Test()
    @Description("Login and E2E online order")
    public void verifyE2EOnlineShopping(){
        LandingScreen landingScreen=new LandingScreen(driver);
        String order=landingScreen.login().selectProduct().clickOnCart()
                .clickOnCartAndPaymentDetails().clickOrderHistory();
        OrderTableScreen orderTableScreen=new OrderTableScreen(driver);
        orderTableScreen.verifyOrderAndClickonView(order).verifyOrder(order);
    }

    @Test()
    @Description("User registration")
    public void verifyUserRegistration(){
        // change password every time
        LandingScreen landingScreen=new LandingScreen(driver);
        landingScreen.verifyLandingScreen().goToRegister().registerUser();
    }

    // Switch new window
    // alert & popup
    // table
    // movseHovwer
    //drag and drop
    // frame
    // following
    // dynamic xpath
    // Selenium Grid or cross browser testing or parallel execution
    // type of exception (5)
    // Why? PageFactory.initElements
}
