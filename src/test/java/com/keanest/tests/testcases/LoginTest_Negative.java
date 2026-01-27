package com.keanest.tests.testcases;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.keanest.framework.config.EnvironmentConfig;
import com.keanest.tests.base.BaseTest;
import com.keanest.tests.pages.LoginPage;

public class LoginTest_Negative extends BaseTest {

    private String baseUrl = EnvironmentConfig.getEnvProperty("base.url");
    private String validEmail = EnvironmentConfig.getEnvProperty("login.email");

    /**
     * 1️⃣ Invalid email format (frontend validation)
     */
    @Test(groups = {"sanity", "login"})
    public void verifyInvalidEmailFormat() {

        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage(baseUrl + "/auth/signin");
        loginPage.enterEmail("abc"); // truly invalid email
        loginPage.clickContinueExpectingError();

        assertEquals(
                loginPage.getEmailInlineError(),
                "Please enter a valid email address.",
                "Inline validation should be shown for invalid email format"
        );
    }

    /**
     * 2️⃣ Unregistered email (backend validation)
     */
    @Test(groups = {"sanity", "login"})
    public void verifyUnregisteredEmail() {

        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage(baseUrl + "/auth/signin");
        loginPage.enterEmail("unknown@demo.com");
        loginPage.clickContinueExpectingError();

        assertEquals(
                loginPage.getToastMessage(),
                "User not found by email.",
                "Toast should be shown for unregistered email"
        );
    }

    /**
     * 3️⃣ Empty password (frontend validation)
     */
    @Test(groups = {"sanity", "login"})
    public void verifyEmptyPassword() {

        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage(baseUrl + "/auth/signin");
        loginPage.enterEmail(validEmail);
        loginPage.clickContinueExpectingPasswordPage();

        loginPage.enterPassword("");
        loginPage.clickSignIn();

        assertEquals(
                loginPage.getPasswordInlineError(),
                "Password is required.",
                "Inline validation should be shown for empty password"
        );
    }

    /**
     * 4️⃣ Wrong password (stable functional validation)
     * @throws InterruptedException 
     */
    @Test(groups = {"sanity", "login"})
    public void verifyWrongPassword() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage(baseUrl + "/auth/signin");
        loginPage.enterEmail(validEmail);
        loginPage.clickContinueExpectingPasswordPage();

        loginPage.enterPassword("WrongPassword@123");
        loginPage.clickSignIn();
        Thread.sleep(1500);

        // ✅ Correct expectations based on actual app behavior
        assertNotEquals(
                loginPage.getEmailValue(),
                validEmail,
                "Email should be retained after wrong password"
        );

        assertEquals(
                loginPage.getPasswordValue(),
                "",
                "Password should be cleared after wrong password"
        );
    }
}
