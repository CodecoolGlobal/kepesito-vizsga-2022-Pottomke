import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TablePage {
    WebDriver driver;

    private final String url = "https://demo.seleniumeasy.com/table-data-download-demo.html";

    private final By names = By.xpath("//*[@id=\"example\"]/tbody/tr/td[1]");

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(){
        driver.get(url);
    }
    public void makeEmpty() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("names.txt");
        writer.print("");
        writer.close();
    }


    public void writeNamesToFile() throws IOException {
        FileWriter myWriter = new FileWriter("names.txt", true);

            List<WebElement> namesList = driver.findElements(names);
            for (int i = 0; i < namesList.size(); i++) {
                String name = namesList.get(i).getText();
                myWriter.write(name + "\n");
            }

        myWriter.close();
    }



}
