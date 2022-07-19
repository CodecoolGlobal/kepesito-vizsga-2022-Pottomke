import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicFormPage {
    WebDriver driver;

    private final String url = "http://demo.seleniumeasy.com/basic-first-form-demo.html";

    private final By x = By.xpath("//*[@id=\"at-cv-lightbox-close\"]");

    private final By number1 = By.xpath("//*[@id=\"sum1\"]");
    private final By number2 = By.xpath("//*[@id=\"sum2\"]");
    private final By button = By.xpath("//*[@id=\"gettotal\"]/button");
    private final By result = By.xpath("//*[@id=\"displayvalue\"]");


    public BasicFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(){
        driver.get(url);
        driver.findElement(x).click();
    }

    public String addNumbers(String num1, String num2){
        driver.findElement(number1).sendKeys(num1);
        driver.findElement(number2).sendKeys(num2);
        driver.findElement(button).click();
        return driver.findElement(result).getText();
    }


}
