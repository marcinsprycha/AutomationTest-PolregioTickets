package polregioticket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class ZyrardowWarszawaTicketFindPage {
    @FindBy(xpath = "//button[@class='btn btn-primary hpm-popup-button center-block']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//button[@class='wpc_w_f_c_b wpc_w_f_c_b-n']")
    private WebElement refuseNotificationButton;

    @FindBy(xpath = "//input[@name='start_station' and @class='start_station']")
    private WebElement startStationInput;

    @FindBy(xpath = "//input[@class='start_station']/following-sibling::ul[@class='autocomplete']/li/p[text()='Żyrardów']")
    private WebElement zyrardowAutocompleteStartStationResult;

    @FindBy(xpath = "//input[@name='end_station' and @class='end_station']")
    private WebElement endStationInput;

//    @FindBy(xpath = "//ul[@class='autocomplete']/preceding-sibling::input[@class='end_station']")
//    private WebElement autocompleteEndStation;

    @FindBy(xpath = "//input[@class='end_station']/following-sibling::ul[@class='autocomplete']/li/p[text()='Warszawa Główna']")
    private WebElement warszawaGlownaAutocompleteEndStationResult;

    @FindBy (xpath = "//input[@class='date']")
    private WebElement dateInput;

    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='next']")
    private WebElement forwardArrowDate;

    @FindBy(xpath = "//div[@class='datepicker-days']//thead//th[contains(text(),'Maj')]/parent::tr/parent::thead/following-sibling::tbody/tr/td[contains(text(),'15')]")
    private WebElement maj15_2024;

    @FindBy(xpath = "//div[@class='datepicker-days']//thead//th[contains(text(),'Lipiec 2024')]/parent::tr/parent::thead/following-sibling::tbody/tr/td[@class='day   old' and contains(text(),'29')]")
    private WebElement lipiec29_2024;

    @FindBy(xpath = "//span[@class='hour' and (text()='8:00')]")
    private WebElement leavingHour8_00;

    @FindBy(xpath = "//input[@class='submit']")
    private WebElement submitButton;

    private WebDriver driver;

    SoftAssert softAssert = new SoftAssert();



    public ZyrardowWarszawaTicketFindPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void waitForCookieButton(){

//        wait.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
        softAssert.assertTrue(acceptCookiesButton.isDisplayed());
    }

    public void waitForNotificationDiv(){

        driver.switchTo().frame("bhr-iframe-consent-form");

//        wait.until(ExpectedConditions.visibilityOf(refuseNotificationButton));
    }

    public void dismissNotification(){
        refuseNotificationButton.click();
    }

    public void setAcceptCookieButton(){
        acceptCookiesButton.click();

    }

    public void setStartStation(){
        startStationInput.sendKeys("Żyrardów");
        startStationInput.click();
//        wait.until(ExpectedConditions.visibilityOf(zyrardowAutocompleteStartStationResult));
        softAssert.assertTrue(zyrardowAutocompleteStartStationResult.isDisplayed());
//        Actions actions = new Actions(driver);
//        actions.moveToElement(zyrardowAutocompleteStartStationResult).perform();
        zyrardowAutocompleteStartStationResult.click();
    }
    public void setEndStation(){
        endStationInput.sendKeys("Warszawa");
        endStationInput.click();
//        wait.until(ExpectedConditions.visibilityOf(warszawaGlownaAutocompleteEndStationResult));
        softAssert.assertTrue(warszawaGlownaAutocompleteEndStationResult.isDisplayed());
//        Actions actions = new Actions(driver);
//        actions.moveToElement(warszawaGlownaAutocompleteEndStationResult).perform();
        warszawaGlownaAutocompleteEndStationResult.click();
    }

    public void setTravelDate(){

//        wait.until(ExpectedConditions.visibilityOf(dateInput));
        Assert.assertTrue(dateInput.isDisplayed());
        dateInput.click();
//        lipiec29_2024.click();
//        dateInput.sendKeys("29-06-2024 8:15");
//        dateInput.sendKeys(Keys.ENTER);
        forwardArrowDate.click();
        maj15_2024.click();
    }

    public void setTravelHour(){
//        wait.until(ExpectedConditions.visibilityOf(leavingHour8_00));
        Assert.assertTrue(leavingHour8_00.isDisplayed());
        leavingHour8_00.click();


    }

    public void submit(){
        submitButton.click();

    }
    public void checkUrl(){
        String stringUrl = driver.getCurrentUrl();
        Assert.assertTrue(stringUrl.contains("https://bilety.polregio.pl/wyniki"));
    }


}
