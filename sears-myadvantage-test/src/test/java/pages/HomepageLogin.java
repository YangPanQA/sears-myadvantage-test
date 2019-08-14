package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by ypan on 8/10/2016.
 */
public class HomepageLogin {

    WebDriver driver;

    By loginbutton = By.id("single-button");
    By sears_username = By.id("usernameField");
    By sears_password = By.id("passwordField");
    By longinbutton_2 = By.xpath ("//*[@id='ng-app']/div/div/div[1]/div/header/div[1]/div[2]/div/div/user-Login/form/div[4]/div[2]/button");
    By titletext = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/ng-include/div/div[1]/div[2]/div/div[1]/h2/div/div[1]");

    public HomepageLogin(WebDriver driver){

        this.driver = driver;
    }

    public void setSears_username (java.lang.String strUserName){


        driver.findElement(sears_username).sendKeys(strUserName);
    }

    public  void setSears_password (java.lang.String strPassword){

        driver.findElement(sears_password).sendKeys(strPassword);
    }

    public void clickloginbutton1 () {

        driver.findElement(loginbutton).click();
    }

    public void clickloginbutton_2 () {

        driver.findElement(longinbutton_2).click();
    }

    public String getlogintitle (){

        return driver.findElement(titletext).getText();
    }

    public void logintomyadvantage (String strUserName,String strPassword) {

        this.clickloginbutton1();
        this.setSears_username(strUserName);
        this.setSears_password(strPassword);
        this.clickloginbutton_2();
    }
}
