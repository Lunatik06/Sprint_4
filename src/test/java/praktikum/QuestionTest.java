package praktikum;

import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;

public class QuestionTest {

    @Rule
    public DriverRule driverRule = new DriverRule();


    // Проверка вопроса в блоке "Вопросы о важном"
    @Test
    public void checkQuestionBlock() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open()
                .scrollToBlockQuestion()
                .clickOnBlockQuestion()
                .checkHeaderBlockQuestion()
                .checkBodyBlockQuestion();
    }

}
