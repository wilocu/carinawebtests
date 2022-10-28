package matt.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.zebrunner.agent.core.annotation.TestLabel;
import matt.carina.demo.gui.components.NewsItem;
import matt.carina.demo.gui.pages.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebMattTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testOpenApple() {
        AppleHomePage homePage = new AppleHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testOpenMacTabOnApple() {
        AppleHomePage homePage = new AppleHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage = new AppleHomePage(getDriver());
        MacbookModelPage productsPage = homePage.selectTabM("Mac");
        Assert.assertTrue(productsPage.isPageOpened(), "Mac page is not opened");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testOpenIpadTabOnApple() {
        AppleHomePage homePage = new AppleHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage = new AppleHomePage(getDriver());
        IpadModelPage productsPage = homePage.selectTabI("Ipad");
        Assert.assertTrue(productsPage.isPageOpened(), "Mac page is not opened");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testReadMacPriceApple() {
        AppleHomePage homePage = new AppleHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage = new AppleHomePage(getDriver());
        MacbookModelPage productsPage = homePage.selectTabM("Mac");
        Assert.assertTrue(productsPage.isPageOpened(), "Mac page is not opened");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productsPage.getPrice(), "From $1199", "Invalid price");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testReadIpadPriceApple() {
        AppleHomePage homePage = new AppleHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage = new AppleHomePage(getDriver());
        IpadModelPage productsPage = homePage.selectTabI("Ipad");
        Assert.assertTrue(productsPage.isPageOpened(), "Mac page is not opened");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productsPage.getPrice(), "From $449", "Invalid price");
        softAssert.assertAll();
    }

}
