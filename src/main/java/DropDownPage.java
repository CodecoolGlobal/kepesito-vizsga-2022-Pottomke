import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DropDownPage {
    WebDriver driver;

    private final String url = "http://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

//SELECT LIST DEMO
    private final By selectListDemo= By.xpath("//*[@id=\"select-demo\"]");
    private final By last= By.xpath("//*[@id=\"select-demo\"]/option[8]");

    private final By dropDownMessage= By.xpath("//*[@class=\"selected-value\"]");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(){
                driver.get(url);
    }

    public void clickOn(){
        driver.findElement(selectListDemo).click();
    }

    public void select(){
        driver.findElement(last).click();
    }

    public String getString(){
        return driver.findElement(dropDownMessage).getText();
    }


}
