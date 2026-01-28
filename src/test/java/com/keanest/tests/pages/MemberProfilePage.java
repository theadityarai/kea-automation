package com.keanest.tests.pages;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.keanest.framework.driver.DriverManager;

public class MemberProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MemberProfilePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /* ===================== ADDRESS ===================== */

    private By addAddressIcon = By.xpath("(//div[@role='button'])[13]");
    private By addressLine1 = By.xpath("//input[@name='address1']");
    private By addressLine2 = By.xpath("//input[@name='address2']");
    private By crossStreet = By.xpath("//input[@name='crossStreet']");
    private By direction = By.xpath("//input[@name='direction']");
    private By city = By.xpath("//input[@name='city']");
    private By state = By.xpath("//input[@name='state']");
    private By country = By.xpath("//input[@name='country']");
    private By zipCode = By.xpath("//input[@name='zipCode']");
    private By notes = By.xpath("//input[@name='note']");
    private By addressTypeDropdown = By.xpath("(//button[@type='button'])[18]");
    private By submitButton = By.xpath("//button[@type='submit']");

    public String addAddress() {

        wait.until(ExpectedConditions.elementToBeClickable(addAddressIcon)).click();

        String uniqueAddress = "Auto Address " + new Random().nextInt(10000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLine1))
                .sendKeys(uniqueAddress);

        driver.findElement(addressLine2).sendKeys("Apt 5A");
        driver.findElement(crossStreet).sendKeys("Main St");
        driver.findElement(direction).sendKeys("NE");
        driver.findElement(city).sendKeys("Chicago");
        driver.findElement(state).sendKeys("IL");
        driver.findElement(country).sendKeys("USA");
        driver.findElement(zipCode).sendKeys("60601");
        driver.findElement(notes).sendKeys("Automation added address");

        // Address Type = Billing Address
        driver.findElement(addressTypeDropdown).click();

        By billingAddress =
                By.xpath("//div[@role='listbox']//div[normalize-space()='Billing Address']");

        wait.until(ExpectedConditions.presenceOfElementLocated(billingAddress));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(billingAddress));

        js.executeScript("arguments[0].click();", driver.findElement(submitButton));

        return uniqueAddress;
    }

    public boolean isAddressVisible(String address) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(normalize-space(),'" + address + "')]")
                )
        ).isDisplayed();
    }

    /* ===================== EMERGENCY CONTACT ===================== */

    // 🔥 TEMPORARY POSITIONAL CSS SELECTOR (YOUR PROVIDED ONE)
    private By emergencyEditIcon = By.cssSelector(
        "body > div:nth-child(1) > div:nth-child(5) > main:nth-child(3) > " +
        "div:nth-child(1) > div:nth-child(1) > main:nth-child(3) > " +
        "div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > " +
        "div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > " +
        "div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > " +
        "div:nth-child(1)"
    );

    private By otherField = By.xpath("//input[@name='other']");

    public String updateEmergencyContact() {

    	WebElement wrapper =
    		    wait.until(ExpectedConditions.presenceOfElementLocated(emergencyEditIcon));

    		// 🔥 Find the ACTUAL clickable element
    		WebElement editButton =
    		    wrapper.findElement(By.cssSelector("div[role='button']"));

    		JavascriptExecutor js = (JavascriptExecutor) driver;

    		// Scroll the real button
    		js.executeScript("arguments[0].scrollIntoView({block:'center'});", editButton);

    		// Click the real button
    		js.executeScript("arguments[0].click();", editButton);


        WebElement other =
                wait.until(ExpectedConditions.visibilityOfElementLocated(otherField));

        String timestamp =
                LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        String updatedText = "Edited on " + timestamp;

        other.clear();
        other.sendKeys(updatedText);

        js.executeScript("arguments[0].click();", driver.findElement(submitButton));

        return updatedText;
    }

    public boolean isEmergencyContactUpdated(String text) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(normalize-space(),'" + text + "')]")
                )
        ).isDisplayed();
    }
}
