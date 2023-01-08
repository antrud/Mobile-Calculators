import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class WebMainPage {

    AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "terms_accept")
    private MobileElement btnChromeTermsAccept;

    @AndroidFindBy(id = "negative_button")
    private MobileElement btnDeclineSync;

    @AndroidFindBy(id = "search_box_text")
    private MobileElement etChromeSearch;

    @AndroidFindBy(id = "line_2")
    private MobileElement btnGotoUrl;

    @FindBy(xpath = "//span[contains(@class, 'scinm') and text() = '2']")
    private WebElement btnTwo;

    @FindBy(xpath = "//span[contains(@class, 'sciop') and text() = '+']")
    private MobileElement btnPlus;

    @FindBy(xpath = "//*[@id='sciOutPut']")
    private MobileElement result;


    public void acceptChromeTerms() {
        if (btnChromeTermsAccept.isDisplayed()) {
            btnChromeTermsAccept.click();
        }
    }

    public void declineChromeSync() {
        if (btnDeclineSync.isDisplayed()) {
            btnDeclineSync.click();
        }
    }

    public void getUrl(String url) {
        etChromeSearch.sendKeys(url);
        btnGotoUrl.click();
    }

    public void clickTwo() {
        btnTwo.click();
    }

    public void clickPlus() {
        btnPlus.click();
    }

    public String getResult() {
        String firstResult = result.getText();
        return firstResult.replaceAll("\\D", "");
    }



    public WebMainPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

}
