package co.uk.zoopla.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserClass extends DriverClass {

    private WebDriver initChrome()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver initHeadless()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--headless");

        return new ChromeDriver(options);
    }

    private WebDriver initFirefox()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver initInternetExplorer()
    {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private WebDriver initOpera()
    {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    public void launchBrowser(String browser)
    {
        switch (browser)
        {
            case "Chrome" :
                driver = initChrome();
                break;
            case "Headless":
                driver = initHeadless();
                break;
            case "IE":
            case "InternetExplorer":
            case "ie":
            case "Internet Explorer":
                driver = initInternetExplorer();
                break;
            case "Firefox":
                driver = initFirefox();
                break;
            case "Opera":
                driver = initOpera();
                break;
            default:
                driver = initChrome();

        }

        driver.manage().window().maximize();
    }

    public void closeBrowser()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
