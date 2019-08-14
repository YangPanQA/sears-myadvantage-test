package test;

import org.junit.Assert;
import org.junit.Test;
import pages.HomepageLogin;
import pages.HomepageVerification;
import pages.WebdriverSetup;

/**
 * Created by ypan on 8/10/2016.
 */
public class Login extends WebdriverSetup {

    HomepageLogin objLogin;
    HomepageVerification objHomepage;

    @Test

    public void testHomePageLogin() {

        setup();
        driver.manage().window().maximize();
        objLogin = new HomepageLogin(driver);
        objLogin.logintomyadvantage("ypan@exchangesolutions.com", "Password1");
        objHomepage = new HomepageVerification(driver);

        String loginPageTitle = objLogin.getlogintitle();
        System.out.print("The user is currently logged in as" + " " + loginPageTitle);
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("hello"));

        System.out.printf("\n" + "The Sears Club Card number is" + " " + objHomepage.gethomePageLoyaltyID());
        System.out.printf("\n" + "The current reward balance is" + " " + objHomepage.getRewardBalance());

        closeDriver();
    }
}

