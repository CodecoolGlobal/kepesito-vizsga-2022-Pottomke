import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameCardPage {
    WebDriver driver;

    private final String url = "https://demo.seleniumeasy.com/data-list-filter-demo.html";

    private final By nameCards = By.xpath("//*[@class=\"searchable-container\"]/div");
    private final By name = By.xpath(".//h4");

    public NameCardPage(WebDriver drv) {
        this.driver = drv;
    }

    public void navigate(){
        driver.get(url);
    }

    public List<String> getData(){
        List<String> listItem = new ArrayList<String>();
        List <WebElement> nameList = driver.findElements(nameCards);
        for(int i=0; i< nameList.size(); i++){

            String memberName = nameList.get(i).findElement(name).getText();
            memberName = memberName.replace("Name: ","");
            listItem.add(memberName);

        }
        return listItem;
    }
}
