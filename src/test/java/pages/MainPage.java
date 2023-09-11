package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class MainPage {

    // Кнопка «GO»
    private static final By goButton = By.xpath(".//button[contains(@class, 'Header_Button') and (text()='Go!')]");
    // 2-ой пункт из блока "Сколько это стоит? И как оплатить?"
    private static final By blockQuestion = By.id("accordion__heading-1");
    // получить тело 2-го пункта из блока "Сколько это стоит? И как оплатить?"
    private static final By bodyQuestion = By.xpath(".//div[@id='accordion__panel-1']/p");
    // кнопка заказать в онбординге
    private static final By orderOnboardingButton = By.xpath(".//button[contains(@class, 'Button_Middle') and (text()='Заказать')]");
    // кнопка заказать
    private static final By orderButton = By.className("Button_Button__ra12g");
    final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }

    public MainPage clickOnBlockQuestion() {
        driver.findElement(blockQuestion).click();
        return new MainPage(driver);
    }

    public MainPage checkHeaderBlockQuestion() {
        String textHeaderQuestion = driver.findElement(blockQuestion).getText();
        assertEquals("Хочу сразу несколько самокатов! Так можно?", textHeaderQuestion);
        return new MainPage(driver);

    }

    public MainPage checkBodyBlockQuestion() {
        String textBodyQuestion = driver.findElement(bodyQuestion).getText();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", textBodyQuestion);
        return new MainPage(driver);
    }

    // прокрутка до акордиона
    public MainPage scrollToBlockQuestion() {
        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return new MainPage(driver);
    }

    public MainPage clickOrderOnboardingButton() {
        driver.findElement(orderOnboardingButton).click();
        return this;
    }

    public OrderPage clickOnOrderButton() {
        driver.findElement(orderButton).click();
        return new OrderPage(driver);
    }
}
