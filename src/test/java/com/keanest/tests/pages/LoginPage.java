package com.keanest.tests.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.keanest.framework.driver.DriverManager;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Step 1
    private By emailInput = By.id("_r_0_-form-item");
    private By continueButton = By.xpath("//button[normalize-space()='Continue']");

    // Step 2
    private By passwordInput = By.xpath("//input[@placeholder='Your password']");
    private By eyeIcon = By.xpath("(//button[contains(@class,'cursor-pointer')])[1]");
    private By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    private By dashboardHeader = By.xpath("//h1[normalize-space()='Dashboard']");

    // Errors
    private By emailInlineError = By.id("_r_0_-form-item-message");
    private By passwordInlineError = By.id("_r_1_-form-item-message");
    private By toastMessage = By.xpath("//div[@class='grow tracking-tight text-black']");

    public LoginPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ---------- STEP 1 ----------
    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    // SUCCESS FLOW
    public void clickContinueExpectingPasswordPage() {
        driver.findElement(continueButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput));
    }

    // NEGATIVE FLOW
    public void clickContinueExpectingError() {
        driver.findElement(continueButton).click();
    }

    // ---------- STEP 2 ----------
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickEyeIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(eyeIcon));
        driver.findElement(eyeIcon).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();
    }

    public boolean isDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    // ---------- BRANDING (STEP-2 ONLY) ----------
    public boolean isSignInButtonUsingPrimaryTheme() {
        return driver.findElement(signInButton)
                     .getAttribute("class")
                     .contains("bg-primary");
    }

    // ---------- ERROR GETTERS ----------
    public String getEmailInlineError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInlineError));
        return driver.findElement(emailInlineError).getText();
    }

    public String getPasswordInlineError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInlineError));
        return driver.findElement(passwordInlineError).getText();
    }

    public String getToastMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
        return driver.findElement(toastMessage).getText();
    }

    public String getEmailValue() {
        return driver.findElement(emailInput).getAttribute("value");
    }

    public String getPasswordValue() {
        return driver.findElement(passwordInput).getAttribute("value");
    }
}
