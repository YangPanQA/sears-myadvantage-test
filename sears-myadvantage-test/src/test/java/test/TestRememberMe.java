package test;

import com.google.common.base.Strings;
import org.junit.Test;
import pages.HomepageLogin;
import pages.RememberMe;
import pages.WebdriverSetup;

/**
 * Created by ypan on 9/9/2016.
 */
public class TestRememberMe extends WebdriverSetup {

    HomepageLogin objLogin;
    RememberMe objRememberMe;

    @Test
    public void testrememberme() throws InterruptedException {

        setup();
        driver.manage().window().maximize();
        objLogin = new HomepageLogin(driver);
        objRememberMe = new RememberMe(driver);
        objRememberMe.setLoginbutton();
        objRememberMe.setRemember_me_checkbox();
        objRememberMe.setLoginbutton();
        objLogin.logintomyadvantage("ypan@exchangesolutions.com", "Password1");
        objRememberMe.waitHomepagelogin();
        objRememberMe.setMy_account_button();
        objRememberMe.setLog_oout_button();
        objRememberMe.waitHomepagelogout();

        String remembered_email = objRememberMe.getEmail_input_field();

        if (!Strings.isNullOrEmpty(remembered_email)){

            System.out.printf("The remembered email address is" + " " + remembered_email);
        }
        else {

            System.out.printf("\n" + "The remember me function is not working!");
        }
        closeDriver();
    }
}