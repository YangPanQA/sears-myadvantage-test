package test;

import org.junit.Test;
import pages.EmailClient;
import pages.WebdriverSetup;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ypan on 8/17/2016.
 */
public class ClosedloopEmail extends WebdriverSetup {

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
    String fullemail = timeStamp + "@mailinator.com";

    EmailClient objEmailClient;

    @Test
    public void closdloopemail() throws InterruptedException {

        launchemailclient();
        driver.manage().window().maximize();

        objEmailClient = new EmailClient(driver);
        objEmailClient.setEmailinput(fullemail);
        Thread.sleep(4000);
        objEmailClient.setGobutton();
        objEmailClient.waitGobutton();
        objEmailClient.setKeyword();
        driver.navigate().refresh();
        objEmailClient.waitKeyboard();
        objEmailClient.setEmailurl();

        closeDriver();
    }
}
