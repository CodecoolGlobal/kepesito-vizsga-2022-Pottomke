import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage {
    WebDriver driver;

    private final String url = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html#";

    private final By button = By.xpath("//a[@href='#myModal0']");
    private final By text = By.xpath("//*[@id=\"myModal0\"]//div[3]");
    private final By close = By.xpath("//*[@id=\"myModal0\"]//a[1]");
    private final By modal = By.xpath("//*[@class='modal fade in']");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(){
        driver.get(url);
    }

    public void clickOn(){
        driver.findElement(button).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(modal));
    }

    public String getText(){
        return driver.findElement(text).getText();
    }

    public void close(){
        driver.findElement(close).click();
    }
}
