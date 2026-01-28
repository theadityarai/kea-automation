package com.keanest.tests.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.keanest.framework.driver.DriverManager;

public class MembersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By membersIcon =
            By.xpath("(//div[@class='flex items-center grow gap-2'])[2]");

    public MembersPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openMembers() {
        wait.until(ExpectedConditions.elementToBeClickable(membersIcon)).click();
    }

    public void openMemberProfile(String memberName) {
        By memberButton =
                By.xpath("//button[normalize-space()='" + memberName + "']");
        wait.until(ExpectedConditions.elementToBeClickable(memberButton)).click();
    }
}
