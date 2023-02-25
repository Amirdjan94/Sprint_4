package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateOrderPage {
    WebDriver driver;
    // Поле "Имя"
    public final By nameField = By.xpath(".//div[@id='root']//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    public final By surnameField = By.xpath(".//div[@id='root']//input[@placeholder='* Фамилия']");
    // Поле "Адрес: куда привезти заказ"
    public final By addressField = By.xpath(".//div[@id='root']//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле "Станция метро"
    public final By metroStationField = By.xpath(".//div[@id='root']//input[@placeholder='* Станция метро']");
    // Поле "Телефон: на него позвонит курьер"
    public final By phoneNumberField =  By.xpath(".//div[@id='root']//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее в форме "Для кого самокат"
    public final By btnNextFromWhoIsTheScooterForm = By.xpath(".//button[text()='Далее']");
    // Поле "Когда привезти самокат"
    public final By dateField =  By.xpath(".//div[@id='root']//input[@placeholder='* Когда привезти самокат']");
    // Поле "Срок аренды"
    public final By rentalPeriodField =  By.className("Dropdown-arrow");
    // Кнопка "Заказать" в форме "Про аренду"
    public final By btnCreateOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Кнопка "Да" в форме подтверждения заказа
    public final By btnConfirmCreateOrder = By.xpath(".//button[text()='Да']");
    // Форма уведомления о создании заказа
    public final By createdOrderConfirm = By.xpath(".//div[text()='Заказ оформлен']");
    public CreateOrderPage(WebDriver driver){
        this.driver = driver;
    }
    public void setFieldName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void setFieldSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void setFieldAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void setFieldMetroStation(String metroStation){
        // Генерирую необходимый локатор
        String metroStationLocator = ".//div[@id='root']//div[text()='" + metroStation + "']";
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(metroStationLocator)).click();
    }
    public void setFieldPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void btnNextFromWhoIsTheScooterFormClick(){
        driver.findElement(btnNextFromWhoIsTheScooterForm).click();
    }
    public void setFieldDate(String date){
        driver.findElement(dateField).sendKeys(date);
    }
    public void setRentalPeriod(String period){

        driver.findElement(rentalPeriodField).click();
        String rentalPeriodLocator = ".//div[@class=\"Dropdown-option\" and text()='" + period + "']";
        driver.findElement(By.xpath(rentalPeriodLocator)).click();
    }
    public void CreateOrder(){
        driver.findElement(btnCreateOrder).click();
        driver.findElement(btnConfirmCreateOrder).click();
    }
    public boolean checkCreatedOrder(){
        return driver.findElement(createdOrderConfirm).isDisplayed();
    }
    public CreateOrderPage fillFormOrderAndCreateOrder(String name,String surname,String address,String metroStation, String phoneNumber,String dateToSend, String rentalPeriod){
        setFieldName(name);
        setFieldSurname(surname);
        setFieldAddress(address);
        setFieldMetroStation(metroStation);
        setFieldPhoneNumber(phoneNumber);
        btnNextFromWhoIsTheScooterFormClick();
        setFieldDate(dateToSend);
        setRentalPeriod(rentalPeriod);
        CreateOrder();
        return this;
    }
}
