package test;

import org.junit.Test;
import pages.ExistRegistration;
import pages.WebdriverSetup;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ypan on 8/25/2016.
 */
public class RegistrationExisting extends WebdriverSetup {

    ExistRegistration objregisexisting;

    String cardnumber = "000083766953";
    String year = "1901";
    String month = "February";
    String day = "7";
    String phone = "4167898989";
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
    String fullemail = timeStamp + "@mailinator.com";
    String password = "Password1";

    @Test
    public void testregistrationexisting() throws InterruptedException {

        setup();
        driver.manage().window().maximize();
        objregisexisting = new ExistRegistration(driver);
        objregisexisting.setCard_number_input(cardnumber);
        objregisexisting.setOk_button();
        Thread.sleep(4000);
        //Test case 1: User has registered, but not been verified.

        if (objregisexisting.detectCardnumber()) {

            objregisexisting.setYear_input(year);
            objregisexisting.setMonth_input(month);
            objregisexisting.setDay_input(day);
            objregisexisting.setPhone_input(phone);
            objregisexisting.setContinue_button();
            objregisexisting.waitContinue_button();

            String invalid_para = objregisexisting.getErrormessage();
            if (invalid_para.length() > 0) {
                System.out.printf(invalid_para);
            }

            else {

                objregisexisting.setEmail_input(fullemail);
                objregisexisting.setConfirm_email(fullemail);
                objregisexisting.setPassword_input(password);
                objregisexisting.setConfirm_password(password);
                objregisexisting.setContinue_button_registration();
                Thread.sleep(3000);
                if (objregisexisting.checkSuccessmessage()) {

                    String successmessage = objregisexisting.getSuccessmessage();
                    System.out.printf("Registration success!" + "\n" + successmessage);
                }

                else {

                    String errormessage = objregisexisting.getErrormessage();
                    System.out.printf("Registration failed!" + "\n" + "The error message is" + " " + errormessage);
                }
            }
        }

        else {
            //Test case 2: User has never registered, going through new Registration process

            if (objregisexisting.check_Criticalmsg_newregistration()) {

                System.out.printf("The card has not been registered already! Need to go through new Registration process");
            }

            //Test case 3: User has registered but not confirmed email yet

            else if (objregisexisting.check_Resend_email_link()) {

                System.out.printf("The card has been registered but not confirmed email yet");
            }

            //Test case 4: User has fully registered already, just needs to log in

            else if (objregisexisting.check_Login_Email_input()) {

                System.out.printf("The card has been fully registered, please log in");
            }
        }
        closeDriver();
    }
}
