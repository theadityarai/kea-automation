package com.keanest.tests.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.keanest.framework.config.EnvironmentConfig;
import com.keanest.tests.base.BaseTest;
import com.keanest.tests.pages.LoginPage;

public class LoginTest extends BaseTest {

    private String baseUrl = EnvironmentConfig.getEnvProperty("base.url");
    private String email = EnvironmentConfig.getEnvProperty("login.email");
    private String password = EnvironmentConfig.getEnvProperty("login.password");

    @Test(groups = {"smoke", "login"}, priority = 1)
    public void verifySuccessfulLogin() {

        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage(baseUrl + "/auth/signin");
        loginPage.enterEmail(email);
        loginPage.clickContinueExpectingPasswordPage();

        loginPage.enterPassword(password);
        loginPage.clickSignIn();

        assertTrue(loginPage.isDashboardDisplayed(),
                "Dashboard should be displayed after successful login");
    }

    @Test(groups = {"sanity", "branding"}, priority = 2)
    public void verifySignInButtonBrandingOnLoginPage() {

        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage(baseUrl + "/auth/signin");
        loginPage.enterEmail(email);
        loginPage.clickContinueExpectingPasswordPage();

        assertTrue(
                loginPage.isSignInButtonUsingPrimaryTheme(),
                "Sign In button should use bg-primary theme class"
        );
    }
}
