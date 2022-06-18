package alexheal.eshop.drivers;

import alexheal.eshop.config.Android;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.merge(capabilities);

        caps.setCapability("browserstack.user", Android.config.bsUsername());
        caps.setCapability("browserstack.key", Android.config.bsAccessKey());

        caps.setCapability("app", "bs://6812b6acb6107c49131dea6bed63264b1f3c4857");

        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        caps.setCapability("deviceName", "Google Pixel 3");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("platformName", "android");
        caps.setCapability("connectHardwareKeyboard", false);
        caps.setCapability("appWaitDuration", 40000);
        caps.setCapability("deviceReadyTimeout", 10);
        caps.setCapability("androidDeviceReadyTimeout", 60);
        caps.setCapability("androidInstallTimeout", 120000);


        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), caps);
    }

    public static URL getBrowserstackUrl() {
        try {
            String url = "http://" + Android.config.bsUsername() + ":" + Android.config.bsAccessKey() + "@" + "hub.browserstack.com" + "/wd/hub";
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}