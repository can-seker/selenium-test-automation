import Base.BaseTest;
import Pages.AccountPage;
import Pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Login Test Senaryoları")
public class LoginTest extends BaseTest {

    @Test(description = "TC0001 Başarılı Login Kullanıcısı")
    public void TC0001() {

        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("Test")
                .passwordDoldur("Test123456")
                .login();
        accountPage
                .accountSayfaKontrolu("Accounts Overview");
    }

    @Test(description = "TC0002 Username alanı boş gönderilme")
    public void TC0002() {
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("")
                .passwordDoldur("Test123456")
                .login()
                .errorKontrolu("Please enter a username and password.");
    }

    @Test(description = "TC0003 Password alanı boş gönderilme")
    public void TC0003() {
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("Test")
                .passwordDoldur("")
                .login()
                .errorKontrolu("Please enter a username and password.");
    }

    @Test(description = "TC0004 Username & Password alanı boş gönderilme Fail")
    public void TC0004() {

        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("")
                .passwordDoldur("")
                .login();
        accountPage
                .accountSayfaKontrolu("Accounts Overview");
    }

    @Test(description = "TC0005 Username & Password alanı boş gönderilme")
    public void TC0005() {
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("")
                .passwordDoldur("")
                .login()
                .errorKontrolu("Please enter a username and password.");

    }

    @Test(description = "TC0006 Başarılı login")
    public void TC0006() {
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("dsasaddsa")
                .passwordDoldur("dasadsdsasda")
                .login()
                .errorKontrolu("Please enter a username and password.");

    }
}
