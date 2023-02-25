package pages;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public class MainPage {
    WebDriver driver;
    // Блок вопросов
    private final By questionBlock = By.xpath(".//div[@class=\"accordion\"]");
    // Строки с вопросами
    private final By question1 = By.id("accordion__heading-0");
    private final By question2 = By.id("accordion__heading-1");
    private final By question3 = By.id("accordion__heading-2");
    private final By question4 = By.id("accordion__heading-3");
    private final By question5 = By.id("accordion__heading-4");
    private final By question6 = By.id("accordion__heading-5");
    private final By question7 = By.id("accordion__heading-6");
    private final By question8 = By.id("accordion__heading-7");
    // Строки с ответами
    private final By Answer1 = By.id("accordion__panel-0");
    private final By Answer2 = By.id("accordion__panel-1");
    private final By Answer3 = By.id("accordion__panel-2");
    private final By Answer4 = By.id("accordion__panel-3");
    private final By Answer5 = By.id("accordion__panel-4");
    private final By Answer6 = By.id("accordion__panel-5");
    private final By Answer7 = By.id("accordion__panel-6");
    private final By Answer8 = By.id("accordion__panel-7");
    // Кнопка создания задачи из заголовки сайта
    private final By btnOpenCreateOrderFormSiteHeader = By.xpath(".//div[@class='Home_HomePage__ZXKIX']//button[text()='Заказать']");
    // Кнопка создания задачи bp блока флоу работы сайта
    private final By btnOpenCreateOrderFormRoadMap = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']//button[text()='Заказать']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibleQuestionBlock(){
        new WebDriverWait(driver, WebDriverConfig.WAIT_TIMEOUT_SECOND)
                .until(visibilityOfAllElementsLocatedBy(questionBlock));
    }

    public void scrollIntoQuestionBlock(){
        WebElement elementQuestionBlock = driver.findElement(questionBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementQuestionBlock);
    }
    // Клик на вопросы
    public void btnClickQuestionRow(int numberRow){
        switch (numberRow) {
            case 0:
                driver.findElement(question1).click();
                break;
            case 1:
                driver.findElement(question2).click();
                break;
            case 2:
                driver.findElement(question3).click();
                break;
            case 3:
                driver.findElement(question4).click();
                break;
            case 4:
                driver.findElement(question5).click();
                break;
            case 5:
                driver.findElement(question6).click();
                break;
            case 6:
                driver.findElement(question7).click();
                break;
            case 7:
                driver.findElement(question8).click();
                break;
            default: throw new RuntimeException("Quetion " + numberRow + " does not exist");
        }
    }
    public String getAnswerForQuestion(int numberRow){ //Ожидание прогрузки ответов и передача текста ответа
        switch (numberRow) {
            case 0:
                this.waitForVisibleAnswer(Answer1);
                return driver.findElement(Answer1).getText();
            case 1:
                this.waitForVisibleAnswer(Answer2);
                return driver.findElement(Answer2).getText();
            case 2:
                this.waitForVisibleAnswer(Answer3);
                return driver.findElement(Answer3).getText();
            case 3:
                this.waitForVisibleAnswer(Answer4);
                return driver.findElement(Answer4).getText();
            case 4:
                this.waitForVisibleAnswer(Answer5);
                return driver.findElement(Answer5).getText();
            case 5:
                this.waitForVisibleAnswer(Answer6);
                return driver.findElement(Answer6).getText();
            case 6:
                this.waitForVisibleAnswer(Answer7);
                return driver.findElement(Answer7).getText();
            case 7:
                this.waitForVisibleAnswer(Answer8);
                return driver.findElement(Answer8).getText();
            default: throw new RuntimeException("Answer " + numberRow + "does not exist");
        }
    }
    public void waitForVisibleAnswer(By answerRow){
        new WebDriverWait(driver, WebDriverConfig.WAIT_TIMEOUT_SECOND)
                .until(visibilityOfAllElementsLocatedBy(answerRow));
    }
    public void openAnswerForTheQuestion(int numberRow) {
        // Таймаут ожидание появления блока вопросов
        this.waitForVisibleQuestionBlock();
        // Скролл до блока вопросов
        this.scrollIntoQuestionBlock();
        // Клик на первый вопрос
        this.btnClickQuestionRow(numberRow);
    }
    public CreateOrderPage openCreateOrderPageFormSiteHeader(){ // Открытие формы создания заказа из шапки сайта
        // Ожидание загрузки кнопки создания заказа
        new WebDriverWait(driver, WebDriverConfig.WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(btnOpenCreateOrderFormSiteHeader));
        driver.findElement(btnOpenCreateOrderFormSiteHeader).click();
        return new CreateOrderPage(driver);
    }
    public CreateOrderPage openCreateOrderPageFromRoadMap(){ // Открытие формы создания заказа из блока флоу работы сайта
        // Ожидание загрузки кнопки создания заказа
        new WebDriverWait(driver, WebDriverConfig.WAIT_TIMEOUT_SECOND)
                .until(ExpectedConditions.elementToBeClickable(btnOpenCreateOrderFormRoadMap));
        // Скролл до кнопки
        WebElement elementBtnOpenCreateOrder = driver.findElement(btnOpenCreateOrderFormRoadMap);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementBtnOpenCreateOrder);
        // Клик на кнопку
        driver.findElement(btnOpenCreateOrderFormRoadMap).click();
        return new CreateOrderPage(driver);
    }




}
