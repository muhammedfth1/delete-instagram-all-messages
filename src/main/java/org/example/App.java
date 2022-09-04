package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {
    WebDriver driver;
    String base_url = "https://www.instagram.com/";
    By usernameLocator = new By.ByCssSelector("input[name='username']");
    By passwordLocator = new By.ByCssSelector("input[name='password']");
    By loginButtonLocator = new By.ByCssSelector("button[type='submit']");
    By goMessages = By.className("xWeGp");
    By nextControl = By.className("_a9_1");
    By messagesBox = By.className("_aad7");
    By attentionLocator = new By.ByCssSelector("circle[cx='11.819']");
    By firstDeleteButton = By.xpath("//*[text()='Delete Chat']");
    By secondDeleteButton = By.xpath("//*[text()='Delete']");
    By waitNextMessage = By.xpath("//*[text()='Your Messages']");

    public App(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(base_url);
        driver.manage().window().maximize();
    }

    public void locatorWait(By Locator){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }

    public void forClick(By Locator){
        driver.findElement(Locator).click();
    }

    public void login(String username , String password){
        locatorWait(usernameLocator);
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        forClick(loginButtonLocator);
    }

    public void goToMessagesBox(){
        locatorWait(goMessages);
        forClick(goMessages);
        locatorWait(nextControl);
        forClick(nextControl);
    }

    public void deleteMessages(){
        for (int i = 0; i < 20; i++) {
            locatorWait(messagesBox);
            forClick(messagesBox);
            locatorWait(attentionLocator);
            forClick(attentionLocator);
            locatorWait(firstDeleteButton);
            forClick(firstDeleteButton);
            locatorWait(secondDeleteButton);
            forClick(secondDeleteButton);
        }
    }
}
