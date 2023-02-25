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
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class testForQuestionBlock {
    private WebDriver driver;
    private String expectAnswer;
    private int numberRow;

    public testForQuestionBlock(String expectAnswer, int numberRow) {
        this.expectAnswer = expectAnswer;
        this.numberRow = numberRow;
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                { "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                { "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                { "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                { "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                { "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                { "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                { "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7}
        };
    }
   @Before
   public void setup() {
       driver = WebDriverFactory.get();
   }
    @Test
    public void checkDisplayingAnswersToQuestionsInquestionBlock() {
        MainPage mainPage = new MainPage(driver);
        // Просмотр ответа на вопрос
        mainPage.openAnswerForTheQuestion(numberRow);
        // Проверка
        assertEquals("Не корректный ответ на вопрос №" + numberRow,expectAnswer, mainPage.getAnswerForQuestion(numberRow) );

    }
    @After
    public void teardown(){
        driver.close();
    }
}
