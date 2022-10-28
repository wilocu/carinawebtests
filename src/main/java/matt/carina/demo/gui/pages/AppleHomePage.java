package matt.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import matt.carina.demo.gui.components.FooterMenu;
import matt.carina.demo.gui.components.WeValuePrivacyAd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class AppleHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(xpath = "//div[contains(@class, 'ac-gn-content')]//a")
    private List<ExtendedWebElement> tabLinks;

    @FindBy(className = "cta-links")
    private ExtendedWebElement newsColumn;

    public AppleHomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public MacbookModelPage selectTabM(String tab) {
        LOGGER.info("selecting '" + tab + "' tab...");
        for (ExtendedWebElement tabLink : tabLinks) {
            String currentBrand = tabLink.getText();
            LOGGER.info("currentTab: " + currentBrand);
            if (tab.equalsIgnoreCase(currentBrand)) {
                tabLink.click();
                return new MacbookModelPage(driver);
            }
        }
        throw new RuntimeException("Unable to open tab: " + tab);
    }

    public IpadModelPage selectTabI(String tab) {
        LOGGER.info("selecting '" + tab + "' tab...");
        for (ExtendedWebElement tabLink : tabLinks) {
            String currentBrand = tabLink.getText();
            LOGGER.info("currentTab: " + currentBrand);
            if (tab.equalsIgnoreCase(currentBrand)) {
                tabLink.click();
                return new IpadModelPage(driver);
            }
        }
        throw new RuntimeException("Unable to open tab: " + tab);
    }

    public WeValuePrivacyAd getWeValuePrivacyAd() {
    	return new WeValuePrivacyAd(driver);
    }
}
