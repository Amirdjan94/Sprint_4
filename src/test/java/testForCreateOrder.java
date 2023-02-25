import config.AppConfig;
import config.WebDriverConfig;
import extentions.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class testForCreateOrder {
    public WebDriver driver;
    public String name,surname,address,metroStation, phoneNumber,dateToSend, rentalPeriod;
    public testForCreateOrder(String name,String surname,String address,String metroStation, String phoneNumber,String dateToSend, String rentalPeriod) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dateToSend = dateToSend;
        this.rentalPeriod =rentalPeriod;
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Иван", "Иванов", "Зорге", "Черкизовская", "88888888888", "01.03.2023", "сутки"},
                {"Сергей", "Сергеев", "Проспект", "Сокольники", "77777777777", "01.03.2023", "двое суток"},
        };
    }

    @Before
    public void setup(){
        driver = WebDriverFactory.get();
    }
    @Test
    public void fillCreateOrderFormAndConfirmOrderFromHeaderSite() {
        boolean isCreateOrder = new MainPage(driver)
                .openCreateOrderPageFormSiteHeader()
                .fillFormOrderAndCreateOrder(name,surname,address,metroStation, phoneNumber,dateToSend, rentalPeriod)
                .checkCreatedOrder();
        assertTrue("Не отобразилось окно-уведомление о создании заказа", isCreateOrder);
    }

    @Test
    public void fillCreateOrderFormAndConfirmOrderFromRoadMap() {
        boolean isCreateOrder = new MainPage(driver)
        .openCreateOrderPageFromRoadMap()
        .fillFormOrderAndCreateOrder(name,surname,address,metroStation, phoneNumber,dateToSend, rentalPeriod)
                .checkCreatedOrder();
        assertTrue("Не отобразилось окно-уведомление о создании заказа", isCreateOrder);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}