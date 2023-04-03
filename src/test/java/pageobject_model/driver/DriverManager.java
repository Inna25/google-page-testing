package pageobject_model.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
