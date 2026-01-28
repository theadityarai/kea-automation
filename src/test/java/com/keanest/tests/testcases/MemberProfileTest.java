package com.keanest.tests.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.keanest.framework.config.EnvironmentConfig;
import com.keanest.tests.base.BaseTest;
import com.keanest.tests.pages.LoginPage;
import com.keanest.tests.pages.MembersPage;
import com.keanest.tests.pages.MemberProfilePage;

public class MemberProfileTest extends BaseTest {

    private void loginAndOpenMemberProfile() {

        String baseUrl = EnvironmentConfig.getEnvProperty("base.url");
        String email = EnvironmentConfig.getEnvProperty("login.email");
        String password = EnvironmentConfig.getEnvProperty("login.password");
        String memberName = EnvironmentConfig.getEnvProperty("member.name");

        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(baseUrl + "/auth/signin");
        loginPage.enterEmail(email);
        loginPage.clickContinueExpectingPasswordPage();
        loginPage.enterPassword(password);
        loginPage.clickSignIn();

        assertTrue(loginPage.isDashboardDisplayed());

        MembersPage membersPage = new MembersPage();
        membersPage.openMembers();
        membersPage.openMemberProfile(memberName);
    }

    /* ================= TEST 1 ================= */
    @Test(groups = {"sanity", "login"})
    public void verifySuccessfulLogin() {
        loginAndOpenMemberProfile();
    }

    /* ================= TEST 2 ================= */
    @Test(groups = {"sanity", "memberProfilePositive"})
    public void verifyAddAddressForMember() {

        loginAndOpenMemberProfile();

        MemberProfilePage profilePage = new MemberProfilePage();
        String address = profilePage.addAddress();

        assertTrue(
                profilePage.isAddressVisible(address),
                "Address should be visible after add"
        );
    }

    /* ================= TEST 3 ================= */
    @Test(groups = {"sanity", "memberProfilePositive"})
    public void verifyUpdateEmergencyContact() {

        loginAndOpenMemberProfile();

        MemberProfilePage profilePage = new MemberProfilePage();
        String updatedText = profilePage.updateEmergencyContact();

        assertTrue(
                profilePage.isEmergencyContactUpdated(updatedText),
                "Emergency contact should be updated"
        );
    }

}
