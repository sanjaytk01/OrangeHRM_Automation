package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ConfigReader.loadProperties();
        WebDriverManager.chromedriver().setup();
        // Chrome configuration
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");        // ✅ stable headless mode for Chrome 109+
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        // Optional: detect CI environment dynamically
        if (System.getenv("CI") != null) {
            System.out.println("Running on CI — Enabling headless mode");
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseURL"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

