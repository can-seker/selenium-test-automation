package Pages;

import Base.BaseLib;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseLib {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver =  driver;
    }

    @Step("Username alanı doldurulur")
    public HomePage userNameDoldur(String text){
        driver.findElement(By.name("username")).sendKeys(text);
        return this;
    }

    @Step("Parola alanını doldur")
    public HomePage passwordDoldur(String pass){
        driver.findElement(By.name("password")).sendKeys(pass);
        return this;
    }

    @Step("Login buttonuna tıklanır")
    public HomePage login(){
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(5) > input")).click();
        return this;
    }

    @Step("Error Kontrolü: {text}")
    public HomePage errorKontrolu(String text){
        String value =  driver.findElement(By.cssSelector("#rightPanel > p")).getText();
        Assert.assertEquals(text, value);
        Allure.addAttachment(text + ": erorr mesajı geldiği görüntülenmiştir.","");
        attachScreenshot(driver);
        return this;
    }

}
