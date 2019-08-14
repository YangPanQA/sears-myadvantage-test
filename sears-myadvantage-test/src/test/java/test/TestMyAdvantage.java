package test;

import org.junit.Assert;
import org.junit.Test;
import pages.HomepageLogin;
import pages.MyAdvantage;
import pages.WebdriverSetup;


/**
 * Created by ypan on 8/18/2016.
 */
public class TestMyAdvantage extends WebdriverSetup {

    MyAdvantage objTestmyadvantage;
    HomepageLogin objLogin;

    String ma_addressline1 = "36 Toronto St.";
    String ma_addressline2 = "123 Test St.";
    String ma_city = "Toronto";
    String ma_province = "Ontario";
    String ma_postalcode = "M5C 2C5";
    String ma_nameoncard = "Test Automation";
    String ma_cardnumber = "5555555555554444";
    String ma_expirydate = "1219";
    String ma_cvv = "123";

    @Test

    public void testmyadvantage () throws InterruptedException {

        setup();
        driver.manage().window().maximize();
        objLogin = new HomepageLogin(driver);
        objLogin.logintomyadvantage("thompson@mailinator.com", "Password1");
        objTestmyadvantage= new MyAdvantage(driver);
        objTestmyadvantage.waitHomepagelogin();

        objTestmyadvantage.setMyadvantagetabhome_button();
        Thread.sleep(2000);
        //To check if the user has MA package purchased or not
        if (objTestmyadvantage.checkBuynowbutton()) {

            objTestmyadvantage.setBuynow_button();
            objTestmyadvantage.waitBuynow_button();
            objTestmyadvantage.setAddressline1(ma_addressline1);
            objTestmyadvantage.setAddressline2(ma_addressline2);
            objTestmyadvantage.setCity(ma_city);
            objTestmyadvantage.setProvince(ma_province);
            objTestmyadvantage.setPostalcode(ma_postalcode);
            objTestmyadvantage.setProcesstopayment_button();
            objTestmyadvantage.waitProcesstopayment_button();
            objTestmyadvantage.setNameoncard(ma_nameoncard);
            objTestmyadvantage.setCardnumber(ma_cardnumber);
            objTestmyadvantage.setExpirydate(ma_expirydate);
            objTestmyadvantage.setCvv(ma_cvv);
            objTestmyadvantage.setPlaceorder_button();
            Thread.sleep(4000);
            String ma_error_message = objTestmyadvantage.setPurchase_error_message();
            Assert.assertFalse(ma_error_message.toLowerCase().contains("unfortunately"));
            // add another case to verify the package is purchased
            System.out.printf("The MA package is successfully purchased");
        }
        else{

            System.out.printf("MA package purchased");
            objTestmyadvantage.setMyaccountbutton();
            objTestmyadvantage.waitMyaccountbutton();
            objTestmyadvantage.setMyprofilebutton();
            objTestmyadvantage.waitMyprofilebutton();
            objTestmyadvantage.setMyadvantagetab_under_myaccount();
            objTestmyadvantage.waittMyadvantagetab_under_myaccount();
            String purchase_date = objTestmyadvantage.setMa_purchasedate();
            System.out.printf("\n" + "The MA package purchase date is" + " " + purchase_date);
            String expiry_date = objTestmyadvantage.setMa_expirydate();
            System.out.printf("\n" + "The MA package expiry date is" + " " + expiry_date);
        }
        closeDriver();
    }
}
