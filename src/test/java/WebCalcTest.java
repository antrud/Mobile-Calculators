import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class WebCalcTest {

    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:appPackage", "com.android.chrome");
        desiredCapabilities.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void firstTest() throws InterruptedException {

//        driver.get("https://calculator-online.net/");
//        Thread.sleep(3_000);

        WebMainPage page = new WebMainPage(driver);
        page.acceptChromeTerms();
        page.declineChromeSync();
        page.getUrl("https://www.calculator.net/");
        Thread.sleep(3_000);

        driver.context("WEBVIEW_chrome");

        page.clickTwo();
        page.clickPlus();
        page.clickTwo();

        String actualResult = page.getResult();

        Assert.assertEquals(actualResult, "4");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
