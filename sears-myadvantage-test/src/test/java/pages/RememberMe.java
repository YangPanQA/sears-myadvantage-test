package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ypan on 9/9/2016.
 */
public class RememberMe {

    WebDriver driver;

    By remember_me_checkbox = By.id("rememberMe");
    By loginbutton = By.id("single-button");
    By my_account_button = By.id("single-button");
    By log_oout_button = By.xpath("//*[@id=\"ng-app\"]/div/div/div[1]/div/header/div[1]/div[2]/div/div/ul/li[5]/a/span");
    By email_input_field = By.id("usernameField");


    public RememberMe(WebDriver driver) {

        this.driver = driver;
    }

    public void setLoginbutton(){

        driver.findElement(loginbutton).click();
    }

    public void setRemember_me_checkbox (){

        driver.findElement(remember_me_checkbox).click();
    }

    public void setMy_account_button(){

        driver.findElement(my_account_button).click();
    }

    public void setLog_oout_button (){

        driver.findElement(log_oout_button).click();
    }

    public String getEmail_input_field (){

       return driver.findElement(email_input_field).getAttribute("value");

    }

    // wait until the visibility of the element

    public void waitHomepagelogin (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/ng-include/div/div[1]/div[2]/div/div[2]/div[2]/dl/dd/a")));
    }

    public void waitHomepagelogout (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumberField")));
    }
}