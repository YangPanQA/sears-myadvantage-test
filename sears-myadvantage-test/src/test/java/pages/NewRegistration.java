package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ypan on 8/11/2016.
 */
public class NewRegistration {

    WebDriver driver;
    By getcardbutton = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/ng-include/div[1]/div[1]/user-claim-card/div[2]/div[2]/div/button");
    By email = By.id("email");
    By verifyemail = By.id("confirmEmail");
    By createpassword = By.id ("password");
    By confirmpassword = By.id("confirmPassword");
    By salutation = By.id("salutation");
    By firstname = By.id("firstName");
    By lastname = By.id("lastName");
    By year = By.id("year");
    By month = By.id("month");
    By day = By. id("day");
    By language = By.id("language");
    By address = By.id("address1");
    By city = By.id("city");
    By province = By.id("province");
    By country = By.id("country");
    By postalcode = By.id("postalCode");
    By phone = By.id("primaryPhoneNumber");
    By checkbox = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/div/div[1]/form/div[8]/div/div/label/span/span");
    By registerbutton = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/div/div[1]/form/div[9]/div/button");
    By newcardnumber = By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/div/div[3]/div[1]");
    By newcvvnumber = By.xpath("//*[@id=\"ng-app\"]/div/div/div[2]/div[2]/div/div[3]/div/div/div[2]");


    public NewRegistration(WebDriver driver){

        this.driver = driver;
    }

    public void clickGetcardbutton (){

        driver.findElement(getcardbutton).click();
    }

    public void setEmail (String strEmail){

        driver.findElement(email).sendKeys(strEmail);
    }

    public void setVerifyemail (String strVerifyemail){

        driver.findElement(verifyemail).sendKeys(strVerifyemail);
    }

    public void setCreatepassword (String strPassword){

        driver.findElement(createpassword).sendKeys(strPassword);
    }

    public void setConfirmpassword (String strConfirmpassword){

        driver.findElement(confirmpassword).sendKeys(strConfirmpassword);
    }

    public void setSalutation (String strSalutation){

        Select select = new Select(driver.findElement(salutation));
        select.selectByVisibleText(strSalutation);
    }

    public void setFirstname (String strFirstname){

        driver.findElement(firstname).sendKeys(strFirstname);
    }

    public void setLastname (String strLastname) {

        driver.findElement(lastname).sendKeys(strLastname);
    }

    public void setYear (String strYear) {

        Select select = new Select(driver.findElement(year));
        select.selectByVisibleText(strYear);
    }

    public void setMonth (String strMonth) {

        Select select = new Select(driver.findElement(month));
        select.selectByVisibleText(strMonth);
    }

    public void setDay (String strDay) {

        Select select = new Select(driver.findElement(day));
        select.selectByVisibleText(strDay);
    }

    public void setLanguage (String strLanguage) {

        Select select = new Select(driver.findElement(language));
        select.selectByVisibleText(strLanguage);
    }

    public void setAddress (String strAddress) {

        driver.findElement(address).sendKeys(strAddress);
    }

    public void setCity (String strCity) {

        driver.findElement(city).sendKeys(strCity);
    }

    public void setProvince (String strProvince) {

        Select select = new Select(driver.findElement(province));
        select.selectByVisibleText(strProvince);
    }

    public void setCountry (String strCountry) {

        Select select = new Select(driver.findElement(country));
        select.selectByVisibleText(strCountry);
    }

    public void setPostalcode (String strPostalcode) {

        driver.findElement(postalcode).sendKeys(strPostalcode);
    }

    public void setPhone (String strPhone) {

        driver.findElement(phone).sendKeys(strPhone);
    }

    public void setCheckbox () {

        driver.findElement(checkbox).click();
    }

    public void clickregisterbutton () {

        driver.findElement(registerbutton).click();
    }

    public String setNewcardnumber () {

        return driver.findElement(newcardnumber).getText();
    }

    public String setNewcvvnumber () {

        return driver.findElement(newcvvnumber).getText();
    }

    // wait until the visibility of the element

    public void waitGetcardbutton (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    public void waitNewcardnumber (){

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ng-app']/div/div/div[2]/div[2]/div/div[3]/div[1]")));
    }
}