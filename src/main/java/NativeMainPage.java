import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class NativeMainPage {

    AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "digit_2")
    private MobileElement btnTwo;

    @AndroidFindBy(id = "op_add")
    private MobileElement btnPlus;

    @AndroidFindBy(id = "eq")
    private MobileElement btnEqual;

    @AndroidFindBy(id = "result_final")
    private MobileElement result;

    public void clickTwo() {
        btnTwo.click();
    }

    public void plus() {
        btnPlus.click();
    }

    public void equal() {
        btnEqual.click();
    }

    public String resultField() {
        return result.getText();
    }



    public NativeMainPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }
}
