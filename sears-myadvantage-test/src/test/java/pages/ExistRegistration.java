package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ypan on 8/25/2016.
 */
public class ExistRegistration {

    WebDriver driver;

    By card_number_input = By.id("cardNumberField");
    By ok_button = By.cssSelector("button[class='btn']");
    By card_number_detected = By.cssSelector(".ng-binding > [class= 'label label-primary ng-binding']");
    By year_input = By.id("year");
    By month_input = By.id("month");
    By day_input = By.id("day");
    By phone_input = By.id("phoneNumber");
    By continue_button = By.cssSelector(".form-actions >[class='btn btn-primary']");
    By error_message = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div[1]/div/span/span");
    By email_input = By.id("email");
    By confirm_email = By.id("confirmEmail");
    By password_input = By.id("password");
    By confirm_password = By.id("confirmPassword");
    By continue_button_registration = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div[2]/div/form/div[6]/button");
    By success_message = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div[3]/p");
    By registered_email_address_input = By.id("usernameField");
    By criticalmsg_newregistration = By.cssSelector(".pull-right >[class='ng-scope']");
    By resend_email_link = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div[2]/a/span");


    public ExistRegistration(WebDriver driver) {

        this.driver = driver;
    }

    public void setCard_number_input(String strCard_number_input) {

        driver.findElement(card_number_input).sendKeys(strCard_number_input);
    }

    public void setOk_button(){

        driver.findElement(ok_button).click();
    }

    public Boolean detectCardnumber() {

        return driver.findElements(card_number_detected).size() > 0;
    }

    public void setYear_input(String strYear) {

        driver.findElement(year_input).sendKeys(strYear);
    }

    public void setMonth_input(String strMonth){

        driver.findElement(month_input).sendKeys(strMonth);
    }

    public void setDay_input(String strDay){

        driver.findElement(day_input).sendKeys(strDay);
    }

    public void setPhone_input(String strPhone){

        driver.findElement(phone_input).sendKeys(strPhone);
    }

    public void setContinue_button(){

        driver.findElement(continue_button).click();
    }

    public String getErrormessage() {

        return driver.findElement(error_message).getText();
    }

    public void setEmail_input(String strEmail_input){

        driver.findElement(email_input).sendKeys(strEmail_input);
    }

    public void setConfirm_email(String strConfirm_email){

        driver.findElement(confirm_email).sendKeys(strConfirm_email);
    }

    public void setPassword_input(String strPassword_input){

        driver.findElement(password_input).sendKeys(strPassword_input);
    }

    public void setConfirm_password(String strConfirm_password){

        driver.findElement(confirm_password).sendKeys(strConfirm_password);
    }

    public void setContinue_button_registration(){

        driver.findElement(continue_button_registration).click();
    }

    public String getSuccessmessage(){

        return driver.findElement(success_message).getText();
    }

    public Boolean checkSuccessmessage(){

        return driver.findElements(success_message).size()>0;
    }

    public Boolean check_Login_Email_input(){

        return driver.findElements(registered_email_address_input).size()>0;
    }

    public Boolean check_Criticalmsg_newregistration(){

        return driver.findElements(criticalmsg_newregistration).size() >0;
    }

    public Boolean check_Resend_email_link(){

        return driver.findElements(resend_email_link).size()>0;
    }

    // wait until the visibility of the element

    public void waitContinue_button(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }
}