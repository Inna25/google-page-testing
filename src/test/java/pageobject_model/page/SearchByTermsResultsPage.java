package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchByTermsResultsPage extends BasePage{
    @FindBy(xpath = "//div[@id='rso']/div")
    private List<WebElement> generalSearchResults;

    public SearchByTermsResultsPage(WebDriver driver) {         //public SearchByTermsResultsPage(WebDriver driver)
        super(driver);
    }

    public int countSearchResults(){
    //    logger.info("Search results number for requested term: " + generalSearchResults.size());
        return generalSearchResults.size();
    }
}
