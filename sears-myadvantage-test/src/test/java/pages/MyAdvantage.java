package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ypan on 8/18/2016.
 */
public class MyAdvantage {

    WebDriver driver;
    // User has purchased MA package
    By myaccountbutton = By.xpath("//*[@id=\"single-button\"]/span[1]/span");
    By myprofilebutton = By.xpath("//*[@id='ng-app']/div/div/div[1]/div/header/div[1]/div[2]/div/div/ul/li[3]/a/span");
    By myadvantagetab_under_myaccount = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/div[1]/ul/li[3]/a");
    By ma_purchasedate = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]/strong");
    By ma_expirydate = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/div[2]/div/div/div[1]/table/tbody/tr[2]/td[2]/strong");

    // User has not purchased MA package yet
    By myadvantagetabhome_button = By.xpath("//*[@id='ng-app']/div/div/div[1]/div/header/nav/div/a[3]/span");
    By buynow_button = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/ng-include/div/div[1]/div/div[2]/div[2]/div/a");
    By addressline1 = By.id("billingStreet1");
    By addressline2 = By.id("billingStreet2");
    By city = By.id("billingCity");
    By province = By.id("billingProvince");
    By postalcode = By.id("billingPostalCode");
    By processtopayment_button = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/ui-view/div/div/div[2]/button/span");
    By nameoncard = By.id("field1");
    By cardnumber = By.id("field2");
    By expirydate = By.id("field3");
    By cvv = By.id("field4");
    By placeorder_button = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/ui-view/div/div/div/div[2]/div/form/div[4]/button/span");
    //error message as financial gateway is down
    By purchase_error_message = By.id("errorMsg");


    public MyAdvantage(WebDriver driver){

        this.driver = driver;
    }

    public void setMyaccountbutton(){

        driver.findElement(myaccountbutton).click();
    }

    public void setMyprofilebutton(){

        driver.findElement(myprofilebutton).click();
    }

    public void setMyadvantagetab_under_myaccount(){

        driver.findElement(myadvantagetab_under_myaccount).click();
    }

    public String setMa_purchasedate(){

        return driver.findElement(ma_purchasedate).getText();
    }

    public String setMa_expirydate(){

        return driver.findElement(ma_expirydate).getText();
    }

    public void setMyadvantagetabhome_button(){

        driver.findElement(myadvantagetabhome_button).click();
    }

    public void setBuynow_button(){

        driver.findElement(buynow_button).click();
    }

    public Boolean checkBuynowbutton(){

        return driver.findElements(buynow_button).size() > 0;
    }

    public void setAddressline1(String strAddressline1){

        driver.findElement(addressline1).sendKeys(strAddressline1);
    }

    public void setAddressline2(String strAddressline2){

        driver.findElement(addressline2).sendKeys(strAddressline2);
    }

    public void setCity(String strCity){

        driver.findElement(city).sendKeys(strCity);
    }

    public void setProvince(String strProvince){

        Select select = new Select(driver.findElement(province));
        select.selectByVisibleText(strProvince);
    }

    public void setPostalcode(String strPostalcode){

        driver.findElement(postalcode).sendKeys(strPostalcode);
    }

    public void setProcesstopayment_button(){

        driver.findElement(processtopayment_button).click();
    }

    public void setNameoncard(String strNameoncard){

        driver.findElement(nameoncard).sendKeys(strNameoncard);
    }

    public void setCardnumber(String strCardnumber){

        driver.findElement(cardnumber).sendKeys(strCardnumber);
    }

    public void setExpirydate(String strExpirydate){

        driver.findElement(expirydate).sendKeys(strExpirydate);
    }

    public void setCvv(String strCvv){

        driver.findElement(cvv).sendKeys(strCvv);
    }

    public void setPlaceorder_button(){

        driver.findElement(placeorder_button).click();
    }

    public String setPurchase_error_message(){

        return driver.findElement(purchase_error_message).getText();
    }

    // wait until the visibility of the element

    public void waitHomepagelogin (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/ng-include/div/div[1]/div[2]/div/div[2]/div[2]/dl/dd/a")));
    }

    public void waitBuynow_button(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billingStreet1")));
    }

    public void waitProcesstopayment_button (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field1")));
    }

    public void waitMyaccountbutton (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ng-app']/div/div/div[1]/div/header/div[1]/div[2]/div/div/ul/li[3]/a/span")));
    }

    public void waitMyprofilebutton(){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salutation")));
    }

    public void waittMyadvantagetab_under_myaccount() {

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/div[2]/div/div/div[1]/table/tbody/tr[1]/td[2]/strong")));
    }

}
