import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HybridMainPage {

    AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "button2")
    private MobileElement btnDecline;

    @AndroidFindBy
    private MobileElement btnTwo;


    public void declineTwitter() {
        btnDecline.click();
    }



    public HybridMainPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }
}
