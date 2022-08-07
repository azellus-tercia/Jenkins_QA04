package model;

import model.base.BaseBuildPage;
import org.openqa.selenium.WebDriver;

public class BuildConsolePage extends BaseBuildPage<BuildConsolePage, BuildFreestyleMultiConfigPageSideMenuFrame>{

    public BuildConsolePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BuildFreestyleMultiConfigPageSideMenuFrame getSideMenu() {
        return new BuildFreestyleMultiConfigPageSideMenuFrame(getDriver());
    }
}