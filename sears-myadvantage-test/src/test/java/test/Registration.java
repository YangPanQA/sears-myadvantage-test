package test;

import org.junit.Assert;
import org.junit.Test;
import pages.NewRegistration;
import pages.WebdriverSetup;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by ypan on 8/12/2016.
 */

public class Registration extends WebdriverSetup {


    NewRegistration objRegistration;

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
    String fullemail = timeStamp + "@mailinator.com";
    String accountpassword = "Password1";
    String salutation = "Mr.";
    String accountfirstname = "Test";
    String accountlastname = "Automation";
    String accountyear = "1988";
    String accountmonth = "December";
    String accountday = "16";
    String accountlanguage = "English";
    String accountaddress = "36 Toronto St.";
    String accountcity = "Toronto";
    String accountprovince = "Ontario";
    String accountcountry = "Canada";
    String accountpostalcode = "M5C 2C5";
    String accountphone = "416-666-6666";

    @Test
    public void testregistration() throws InterruptedException {

        setup();
        driver.manage().window().maximize();
        objRegistration = new NewRegistration(driver);
        objRegistration.clickGetcardbutton();
        objRegistration.waitGetcardbutton();
        objRegistration.setEmail(fullemail);
        objRegistration.setVerifyemail(fullemail);
        objRegistration.setCreatepassword(accountpassword);
        objRegistration.setConfirmpassword(accountpassword);
        objRegistration.setSalutation(salutation);
        objRegistration.setFirstname(accountfirstname);
        objRegistration.setLastname(accountlastname);
        objRegistration.setYear(accountyear);
        objRegistration.setMonth(accountmonth);
        objRegistration.setDay(accountday);
        objRegistration.setLanguage(accountlanguage);
        objRegistration.setAddress(accountaddress);
        objRegistration.setCity(accountcity);
        objRegistration.setProvince(accountprovince);
        objRegistration.setCountry(accountcountry);
        objRegistration.setPostalcode(accountpostalcode);
        objRegistration.setPhone(accountphone);
        objRegistration.setCheckbox();
        objRegistration.clickregisterbutton();
        objRegistration.waitNewcardnumber();

        String regiNewcardnumber = objRegistration.setNewcardnumber();
        String regiNewcvvnumber = objRegistration.setNewcvvnumber();
        System.out.print("\n" + "The new registered Sears card number is" + " " + regiNewcardnumber);
        Assert.assertTrue(regiNewcardnumber.toLowerCase().contains("605"));
        System.out.print("\n" + "The CVV number is" + " " + regiNewcvvnumber);
        closeDriver();
    }
}