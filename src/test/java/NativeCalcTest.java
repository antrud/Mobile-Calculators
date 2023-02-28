import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NativeCalcTest {

    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "android");
//        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
//        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//        desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
//        desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
//        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//
//        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//
//        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("device", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("os_version", "12.0");
        capabilities.setCapability("project", "First TestNG Android Project");
        capabilities.setCapability("build", "rowserstack-build-1");
        capabilities.setCapability("name", "first_test");
        capabilities.setCapability("browserstack.debug", true);
        capabilities.setCapability("app", "bs://aa0598c925cfe1a50b098f05ef43092f425ec987");

        driver = new AndroidDriver (
                new URL("http://antonr_RdnaX2:6HxNtVmkBJPSUS8ng2UJ@hub-cloud.browserstack.com/wd/hub"), capabilities
        );
    }

    @Test
    public void firstTest() {
        NativeMainPage page = new NativeMainPage(driver);
        page.clickTwo();
        page.plus();
        page.clickTwo();
        page.equal();

        String expResult = "4";

        Assert.assertEquals(page.resultField(), expResult);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        }
}
