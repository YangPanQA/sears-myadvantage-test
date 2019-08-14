package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ypan on 8/29/2016.
 */
public class ForgotPassword {

    WebDriver driver;

    By login_link = By.linkText("Log In");
    By forgot_password_link = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div/user-Login/form/div[5]/div[1]/div/a[2]");
    By email_input = By.id("email");
    By submit_button = By.cssSelector(".form-actions >[class='btn btn-primary']");
    By wrong_email_error_message = By.cssSelector(".error >[class='ng-scope']");
    By successful_message = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div[1]/div/div");

    public ForgotPassword(WebDriver driver){

        this.driver = driver;
    }

    public void setLogin_link (){

        driver.findElement(login_link).click();
    }

    public void setForgot_password_link(){

        driver.findElement(forgot_password_link).click();
    }

    public void setEmail_input(String strEmail_input){

        driver.findElement(email_input).sendKeys(strEmail_input);
    }

    public void setSubmit_button(){

        driver.findElement(submit_button).click();
    }

    public Boolean checkWrong_email_error_message(){

        return driver.findElements(wrong_email_error_message).size()>0;
    }

    public String getWrong_email_error_message(){

        return driver.findElement(wrong_email_error_message).getText();
    }

    public Boolean checkSuccessful_message(){

        return driver.findElements(successful_message).size()>0;
    }

    public String getSuccessful_message(){

        return driver.findElement(successful_message).getText();
    }

    // wait until the visibility of the element

    public void waitLogin_link (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div/user-Login/form/div[5]/div[1]/div/a[2]")));
    }
    public void waitEmail_input(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }




}
