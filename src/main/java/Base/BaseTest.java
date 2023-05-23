package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLib{

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String tarayici = System.getProperty("browser");
        String osName = System.getProperty("os.name");

        if (tarayici== null) {tarayici="Chrome";}

        System.out.println(tarayici);
        if (tarayici.equals("Chrome")) {
            if (osName.equals("Mac OS X")) {
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            }
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(co);
        }
        else {
            if (osName.equals("Mac OS X")) {
                System.setProperty("webdriver.chrome.driver", "driver/geckodriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }

        driver.get("https://parabank.parasoft.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterDown() {
        driver.quit();
    }
}
