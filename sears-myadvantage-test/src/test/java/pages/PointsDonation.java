package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ypan on 9/6/2016.
 */
public class PointsDonation {

    WebDriver driver;

    By sears_club_program_link = By.cssSelector(".nav_content >[class='main-nav ng-binding']");
    By donate_button = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div/div[3]/donate/div[2]/div/div[4]/div/div/div[2]/a");
    By donation_selectbox = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div/div[3]/donate/div[2]/div/div[4]/div/div/div[1]/select");
    By previous_balance = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/ng-include/div/div[1]/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]");
    By current_balance = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/ng-include/div/div[1]/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]");
    By no_points_donate_msg = By.cssSelector(".row > [class ='col-xs-12 col-md-6']");
    By homepage_logo = By.className("link-home");

    public PointsDonation(WebDriver driver) {

        this.driver = driver;
    }

    public void setSears_club_program_link() {

        driver.findElement(sears_club_program_link).click();
    }

    public void selectDonation_amount(String strAmount) {

        Select select = new Select(driver.findElement(donation_selectbox));
        select.selectByVisibleText(strAmount);
    }

    public void clickDonate_button() {

        driver.findElement(donate_button).click();
    }

    public void clickHomepagelogo() {

        driver.findElement(homepage_logo).click();
    }

    public String getPrevious_balance() {

        return driver.findElement(previous_balance).getText();
    }

    public String getCurrent_balance (){

        return driver.findElement(current_balance).getText();
    }

    public String getNo_points_donate_msg() {

        return driver.findElement(no_points_donate_msg).getText();
    }

    public Boolean detectDonate_button() {

        return driver.findElements(donate_button).size()>0;
    }

    // wait until the visibility of the element

    public void waitHomepagelogin (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/ng-include/div/div[1]/div[2]/div/div[2]/div[2]/dl/dd/a")));
    }

    public void waitSears_club_program_link(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flexbox > [class='col']")));
    }
}