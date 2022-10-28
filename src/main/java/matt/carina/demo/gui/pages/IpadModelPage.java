package matt.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import matt.carina.demo.gui.components.ModelItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IpadModelPage extends AbstractPage {
    @FindBy(xpath = "//nav[@id='iPad family of products']//li")
    private List<ModelItem> models;

    @FindBy(className = "section-content")
    private ExtendedWebElement content;

    @FindBy(className = "has-dynamic-content")
    private ExtendedWebElement price;

    public IpadModelPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(content);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()) + "/ipad");
    }

    public ModelInfoPage selectModel(String modelName) {
        for (ModelItem model : models) {
            if (model.readModel().equalsIgnoreCase(modelName)) {
                return model.openModelPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);
    }


    public String getPrice(){
        return price.getText();
    }
}
