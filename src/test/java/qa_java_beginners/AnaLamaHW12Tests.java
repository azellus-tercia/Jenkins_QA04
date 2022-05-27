package qa_java_beginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnaLamaHW12Tests extends BaseTest {

    private final String BASE_URL = "http://www.99-bottles-of-beer.net/";
    private final String BROWSE_LANG = "//div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']";

    @Test
    public void testBrowseJLanguage() {

        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANG)).click();
        getDriver().findElement(By.xpath("//ul[@id='submenu']/li/a[@href='j.html']")).click();

        WebElement letJ = getDriver().findElement(By.xpath("//div[@id='main']/p"));
        String actualResult = letJ.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMLastLanguageMySQL() {

        String expectedResult = "MySQL";

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANG)).click();
        getDriver().findElement(By.xpath("//ul[@id='submenu']/li/a[@href='m.html']")).click();

        WebElement mLet = getDriver().findElement(By.xpath("//tr[last()]/td/a"));
        String actualResult = mLet.getText();

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testTableColumnsTitles() {

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANG)).click();

        List<WebElement> tabTitles = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/th"));
        List<String> tabTitlesActual = new ArrayList<>();
        for (int i = 0; i < tabTitles.size(); i++) {
            tabTitlesActual.add(tabTitles.get(i).getText());
        }
        List<String> expectedResult = new ArrayList<>(Arrays.asList("Language", "Author", "Date", "Comments", "Rate"));

        Assert.assertEquals(tabTitlesActual.toString(), expectedResult.toString());
    }

    @Test
    public void testMathLanguageRow() {
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANG)).click();
        getDriver().findElement(By.xpath("//ul[@id='submenu']/li/a[@href='m.html']")).click();

        WebElement mathRow = getDriver().findElement(By.xpath("//a[contains(text(),'Mathematica')]/parent::td/parent::tr"));
        String actualResult = mathRow.getText();
        String expectedResult = "Mathematica Brenton Bostick 03/16/06 1";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testNumericalLanguagesNames() {
        int expectedResult = 10;
        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANG)).click();
        getDriver().findElement(By.xpath("//ul[@id='submenu']/li/a[@href='0.html']")).click();

        List<WebElement> numNames = getDriver().findElements(By.xpath("//tbody/tr[@onmouseover]"));
        int actualResult = numNames.size();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
