package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ypan on 8/22/2016.
 */
public class ForgotEmailAddress {

    WebDriver driver;

    By login_link = By.linkText("Log In");
    By forgot_email_link = By.linkText("email address");
    By year = By.id("year");
    By month = By.id("month");
    By day = By.id("day");
    By phone_number = By.name("phone");
    By continue_button = By.cssSelector(".form-actions > [class='btn btn-primary btn-lg']");
    By return_email = By.cssSelector(".col-xs-12 > [class='ng-binding']");
    By error_message = By.cssSelector(".error > [class= 'ng-scope']");

    public ForgotEmailAddress(WebDriver driver){

        this.driver = driver;
    }

    public void setLogin_link(){

        driver.findElement(login_link).click();
    }

    public void setForgot_email_link(){

        driver.findElement(forgot_email_link).click();
    }

    public void setCard_number_field()throws InterruptedException{

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".col-xs-12 > [class='input-group claim-card']")));
        actions.click();
        Thread.sleep(2000);
        actions.sendKeys("000083769858");
        actions.build().perform();
    }

    public void setYear (String strYear){

        driver.findElement(year).sendKeys(strYear);
    }

    public void setMonth (String strMonth){

        driver.findElement(month).sendKeys(strMonth);
    }

    public void setDay (String strDay){

        driver.findElement(day).sendKeys(strDay);
    }

    public void setPhone_number(String strPhone_number){

        driver.findElement(phone_number).sendKeys(strPhone_number);
    }

    public void setContinue_button(){

        driver.findElement(continue_button).click();
    }

    public String getReturnemail(){

        return driver.findElement(return_email).getText();
    }

    public Boolean checkReturnemail(){

        return driver.findElements(return_email).size() > 0;
    }

    public String getErrormessage(){

        return driver.findElement(error_message).getText();
    }

    // wait until the visibility of the element

    public void waitLogin_link(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("email address")));
    }

    public void waitForgot_email_link(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year")));
    }
}
