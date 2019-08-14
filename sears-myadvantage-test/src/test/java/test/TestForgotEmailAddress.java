package test;

import org.junit.Test;
import pages.ForgotEmailAddress;
import pages.WebdriverSetup;


/**
 * Created by ypan on 8/23/2016.
 */
public class TestForgotEmailAddress extends WebdriverSetup {

    ForgotEmailAddress objTestforgotemailaddress;

    String year = "1901";
    String month = "January";
    String day = "1";
    String phonenumber = "4165551212";

    @Test

    public void testforgotemailaddress ()throws InterruptedException{

        setup();
        driver.manage().window().maximize();
        objTestforgotemailaddress = new ForgotEmailAddress(driver);
        objTestforgotemailaddress.setLogin_link();
        objTestforgotemailaddress.waitLogin_link();
        objTestforgotemailaddress.setForgot_email_link();
        objTestforgotemailaddress.waitForgot_email_link();
        objTestforgotemailaddress.setCard_number_field();
        objTestforgotemailaddress.setYear(year);
        objTestforgotemailaddress.setMonth(month);
        objTestforgotemailaddress.setDay(day);
        objTestforgotemailaddress.setPhone_number(phonenumber);
        objTestforgotemailaddress.setContinue_button();

        if (objTestforgotemailaddress.checkReturnemail()){

            String return_email = objTestforgotemailaddress.getReturnemail();
            System.out.printf("The email address is" + " " + return_email);
            }

        else {

            String error_message = objTestforgotemailaddress.getErrormessage();
            System.out.printf("The error message is" + " " + error_message);

        }
        closeDriver();
    }
}
