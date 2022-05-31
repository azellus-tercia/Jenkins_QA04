package qa_java_beginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Song99BottlesOlgaIlyukhinaTest extends BaseTest {

    private static final String baseUrl = "https://www.99-bottles-of-beer.net/";

    @Test
    public void testSongLyricText() {
        String expectedResult = "https://www.99-bottles-of-beer.net/toplist.html";

        getDriver().get(baseUrl);

        String menuTopLists = getDriver().findElement
                (By.xpath
                ("//body/div/div/ul/li/a[@href='/toplist.html']"))
                .getAttribute("href");

        Assert.assertEquals(menuTopLists, expectedResult);
    }

    @Test
    public void testSubmitNewLanguageForm() {
        getDriver().get(baseUrl);

        getDriver().findElement(By.xpath
                ("//body/div/div/ul/li/a[@href='/submitnewlanguage.html']"))
                .click();
        List<WebElement> submitNewLanguageForm = getDriver().findElements(
                By.xpath
                ("//body/div/div[@id='main']/form/p/strong"));

        List<String> actualResult = new ArrayList<>();
        for (WebElement webElement : submitNewLanguageForm) {
            actualResult.add(webElement.getText());
        }

        List<String> expectedResult = new ArrayList<>(Arrays.asList(
                "Language Name:",
                "Description:",
                "Where can we find information about this language?",
                "Author:",
                "E-Mail:",
                "Homepage",
                "Security Code:",
                "Category:",
                "Code:",
                "Message to the team"));

        Assert.assertEquals(actualResult, expectedResult);
    }
}

