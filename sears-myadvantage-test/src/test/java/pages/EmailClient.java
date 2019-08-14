package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ypan on 8/15/2016.
 */
public class EmailClient {

    WebDriver driver;

    By emailinput = By.xpath("//*[@id='inboxfield']");
    By gobutton = By.cssSelector(".input-group-btn>[class ='btn btn-dark']");
    By keyword = By.cssSelector(".innermail");
    By emailurl = By.xpath("//*[@id=\"views\"]/tbody/tr[4]/td/a");

    public EmailClient(WebDriver driver) {

        this.driver = driver;
    }

    public void setEmailinput(String stremailinput) {

        driver.findElement(emailinput).sendKeys(stremailinput);
    }

    public void setGobutton() {

        driver.findElement(gobutton).click();
    }

    public void setKeyword() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".innermail")));
        driver.findElement(keyword).click();
    }

    public void setEmailurl() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"views\"]/tbody/tr[4]/td/a")));
        driver.findElement(emailurl).click();
     }

    // wait until the visibility of the element

    public void waitGobutton () {

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("public_delete_button")));
    }

    public void waitKeyboard () {

        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"views\"]/tbody/tr[4]/td/a")));
    }

}


