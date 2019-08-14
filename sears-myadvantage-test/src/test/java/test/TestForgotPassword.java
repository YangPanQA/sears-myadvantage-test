package test;

import org.junit.Test;
import pages.ForgotPassword;
import pages.WebdriverSetup;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ypan on 8/29/2016.
 */
public class TestForgotPassword extends WebdriverSetup {

    ForgotPassword objTestforgotpassword;

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
    String fullemail = timeStamp + "@mailinator.com";
    String test_email = "ypan@exchangesolutions.com";

    @Test

    public void testforgotpassword() throws InterruptedException {

        setup();
        driver.manage().window().maximize();
        objTestforgotpassword = new ForgotPassword(driver);
        objTestforgotpassword.setLogin_link();
        objTestforgotpassword.waitLogin_link();
        objTestforgotpassword.setForgot_password_link();
        objTestforgotpassword.waitEmail_input();
        objTestforgotpassword.setEmail_input(test_email);
        objTestforgotpassword.setSubmit_button();

        if (objTestforgotpassword.checkSuccessful_message()){

            String successful_message = objTestforgotpassword.getSuccessful_message();
            System.out.printf(successful_message);
        }

        else if(objTestforgotpassword.checkWrong_email_error_message()){

            String error_message = objTestforgotpassword.getWrong_email_error_message();
            System.out.printf(error_message);

        }
        closeDriver();
    }
}
