package test;

import org.junit.Test;
import pages.HomepageLogin;
import pages.PointsDonation;
import pages.WebdriverSetup;


/**
 * Created by ypan on 9/6/2016.
 */
public class TestPointsDonation extends WebdriverSetup {

    HomepageLogin objLogin;
    PointsDonation objPointsDonation;

    String donation_amount = "1000 Points";


    @Test
    public void testpointsdonation () throws InterruptedException {

        setup();
        driver.manage().window().maximize();
        objLogin = new HomepageLogin(driver);
        objLogin.logintomyadvantage("ypan@exchangesolutions.com", "Password1");
        objPointsDonation = new PointsDonation(driver);
        objPointsDonation.waitHomepagelogin();
        String previous_balance = objPointsDonation.getPrevious_balance();
        objPointsDonation.setSears_club_program_link();
        objPointsDonation.waitSears_club_program_link();

        if (objPointsDonation.detectDonate_button()){

            objPointsDonation.selectDonation_amount(donation_amount);
            objPointsDonation.clickDonate_button();
            objPointsDonation.clickHomepagelogo();
            objPointsDonation.waitHomepagelogin();
            driver.navigate().refresh();
            int donation_value = 1000;

            int previous_value = Integer.parseInt(previous_balance);
            System.out.print("\n"+"The previous value is" + " " + previous_value);

            String current_balance = objPointsDonation.getCurrent_balance();
            int current_value = Integer.parseInt(current_balance);
            System.out.print("\n"+"The current value is" + " " + current_value);

            int donation_target = previous_value - current_value;
            System.out.print("\n"+ "The donation value is" + " " + donation_target);

            if (donation_target == donation_value){

                System.out.printf("\n" + "Donation success!");
            }
            else {

                System.out.printf("\n" + "Donation failed!");
            }
        }
        else {
                System.out.printf(objPointsDonation.getNo_points_donate_msg());
        }
        closeDriver();
    }
}
