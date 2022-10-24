import model.home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class _ConfigureGlobalSecurityTest extends BaseTest {
    @Test
    public void test9ChaptersDisplayedOnGlobalSecurityPage() {
        int actualSizeOfChapters = new HomePage(getDriver())
                .getSideMenu()
                .clickMenuManageJenkins()
                .clickConfigureGlobalSecurity()
                .getSizeOfHeadersList();

        Assert.assertEquals(actualSizeOfChapters, 9);
    }

    @Test
    public void testCheckChaptersNames() {
        List<String> expectedChaptersNames = List.of(
                "Authentication",
                "Security Realm",
                "Authorization",
                "Markup Formatter",
                "Agents",
                "CSRF Protection",
                "Hidden security warnings",
                "API Token",
                "SSH Server");

        List<String> actualSecurityChaptersNames = new HomePage(getDriver())
                .getSideMenu()
                .clickMenuManageJenkins()
                .clickConfigureGlobalSecurity()
                .getActualHeaderNamesList();

        Assert.assertEquals(actualSecurityChaptersNames, expectedChaptersNames);
    }

    @Test
    public void testCheckHelpButtonSSHServerPOM() {
        String tooltipHelpButtonSSHServer = new HomePage(getDriver())
                .getSideMenu()
                .clickMenuManageJenkins()
                .clickConfigureGlobalSecurity()
                .getTooltipButtonHelpSSHServerText();

        Assert.assertEquals(tooltipHelpButtonSSHServer, "Help for feature: SSHD Port");
    }

    @Test
    public void testCheckTooltipText() {
        List<String> tooltipTextList = new HomePage(getDriver())
                .getSideMenu()
                .clickMenuManageJenkins()
                .clickConfigureGlobalSecurity()
                .getTooltipTextList();

        Assert.assertTrue(tooltipTextList.contains("Help"));
    }

    @Test
    public void testAmountTooltip() {
        int actualAmountTooltip = new HomePage(getDriver())
                .getSideMenu()
                .clickMenuManageJenkins()
                .clickConfigureGlobalSecurity()
                .countHelpIcons();

        Assert.assertEquals(actualAmountTooltip, 17);
    }
}
