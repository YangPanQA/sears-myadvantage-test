package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ypan on 8/10/2016.
 */
public class HomepageVerification {

    WebDriver driver;

    By homePageLoyaltyID = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/ng-include/div/div[1]/div[2]/div/div[2]/div[2]/dl/dd/a");
    By homepageRewardBalance = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/ng-include/div/div[1]/div[2]/div/div[3]/div[2]/p");

    public HomepageVerification(WebDriver driver){

        this.driver = driver;
    }

    public java.lang.String gethomePageLoyaltyID(){

        return driver.findElement(homePageLoyaltyID).getText();
    }

    public java.lang.String getRewardBalance (){

        return driver.findElement(homepageRewardBalance).getText();
    }
}
