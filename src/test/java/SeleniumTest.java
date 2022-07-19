import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SeleniumTest extends BaseTest{

    /*
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd
   a tesztlépések alapján írj automatizált tesztet. Az oldalon, a Two Input Fields” szekcióban
   két beviteli mezőjét töltsd ki tetszőleges számokkal, majd végezd el a számok összeadásának ellenőrzését
    kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @Test
    public void TestInput()
    {
        BasicFormPage bfp = new BasicFormPage(driver);
        bfp.navigate();
        String actual = bfp.addNumbers("5","6");
        String exp = "11";

        Assertions.assertEquals(exp,actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: zhttps://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a
    következők szerint: a Select List Demo szekció lenyíló mezőjében válaszd ki a hét utolsó napját
    és ellenőrizd, hogy az oldalon helyesen jelenik meg a kiválasztott érték
    Tesztadatként használd az hét utolsó napját
     */
    @Test
    public void SelectDayTest()
    {
        DropDownPage ddp = new DropDownPage(driver);
        ddp.navigate();
        ddp.clickOn();
        ddp.select();
        String actual = ddp.getString();
        String exp = "Day selected :- Saturday";

        Assertions.assertEquals(exp,actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva egy általad definiált
     elvárt eredménnyel. Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy
      változóba és zárd be az ablakot a bezárás gombbal
     */
    @Test
    public void AlertTest()
    {
        AlertPage ap = new AlertPage(driver);
        ap.navigate();
        ap.clickOn();
        String actual = ap.getText();
        ap.close();
        String exp = "This is the place where the content for the modal dialog displays";

        Assertions.assertEquals(exp,actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    @Test
    public void NamecardTest()
    {
        NameCardPage ncp=new NameCardPage(driver);
        ncp.navigate();
        List<String> actual = ncp.getData();
        List<String> exp = new ArrayList<>();
        exp.add("Tyreese Burn");
        exp.add("Brenda Tree");
        exp.add("Glenn Pho shizzle");
        exp.add("Brian Hoyies");
        exp.add("Glenn Pho shizzle");
        exp.add("Arman Cheyia");

        Assertions.assertEquals(exp,actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet.
    A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat első oszlop tartalmaz.
    Gyűjtsd össze a neveket és tárold le a names.txt fájlba majd a tesztesetben a fájl tartalmát
    hasonlítsd össze egy elvárt eredménnyel.
     */
    @Test
    public void TableTest() throws IOException {
        TablePage tp = new TablePage(driver);
        tp.navigate();
        tp.makeEmpty();
        tp.writeNamesToFile();
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
            while (reader.readLine() != null) lines++;
            reader.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Assertions.assertEquals(31, lines);
    }

}
