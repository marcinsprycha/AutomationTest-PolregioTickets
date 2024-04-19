package polregioticket.tests;

import org.testng.annotations.Test;
import polregioticket.pages.ZyrardowWarszawaTicketFindPage;

public class ZyrardowWarszawaTicketFindTest extends BaseTest{
    @Test
    public void findTicket(){
        ZyrardowWarszawaTicketFindPage zyrardowWarszawaTicketFindPage = new ZyrardowWarszawaTicketFindPage(driver);
        driver.get(homePageUrl);
        zyrardowWarszawaTicketFindPage.waitForCookieButton();
        zyrardowWarszawaTicketFindPage.waitForNotificationDiv();
        zyrardowWarszawaTicketFindPage.dismissNotification();
        zyrardowWarszawaTicketFindPage.setAcceptCookieButton();
        zyrardowWarszawaTicketFindPage.setStartStation();
        zyrardowWarszawaTicketFindPage.setEndStation();
        zyrardowWarszawaTicketFindPage.setTravelDate();
        zyrardowWarszawaTicketFindPage.setTravelHour();
        zyrardowWarszawaTicketFindPage.submit();
        zyrardowWarszawaTicketFindPage.checkUrl();
    }
}
