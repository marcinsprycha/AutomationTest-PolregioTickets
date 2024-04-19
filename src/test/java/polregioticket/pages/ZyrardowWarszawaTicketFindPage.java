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

    private WebDriver driver;

    SoftAssert softAssert = new SoftAssert();



    public ZyrardowWarszawaTicketFindPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void waitForCookieButton(){

//        wait.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
        softAssert.assertTrue(acceptCookiesButton.isDisplayed());
    }

    public void waitForNotificationDiv(){

        driver.switchTo().frame("bhr-iframe-consent-form");

        wait.until(ExpectedConditions.visibilityOf(refuseNotificationButton));
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
        wait.until(ExpectedConditions.visibilityOf(zyrardowAutocompleteStartStationResult));
        softAssert.assertTrue(zyrardowAutocompleteStartStationResult.isDisplayed());
//        Actions actions = new Actions(driver);
//        actions.moveToElement(zyrardowAutocompleteStartStationResult).perform();
        zyrardowAutocompleteStartStationResult.click();
    }
    public void setEndStation(){
        endStationInput.sendKeys("Warszawa");
        endStationInput.click();
        wait.until(ExpectedConditions.visibilityOf(warszawaGlownaAutocompleteEndStationResult));
        softAssert.assertTrue(warszawaGlownaAutocompleteEndStationResult.isDisplayed());
//        Actions actions = new Actions(driver);
//        actions.moveToElement(warszawaGlownaAutocompleteEndStationResult).perform();
        warszawaGlownaAutocompleteEndStationResult.click();
    }

}
