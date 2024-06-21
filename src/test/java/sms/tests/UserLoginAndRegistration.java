package sms.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sms.constants.Contract;
import sms.constants.Gender;
import sms.dtos.UserDetails;
import sms.pages.BasicUserRegistrationPage;
import sms.pages.LoginPage;
import sms.pages.MenuPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class UserLoginAndRegistration extends BaseTest {
    private UserDetails userDetails;

    @BeforeEach
    public void create() {
        userDetails = UserDetails.builder()
                .firstName("Sajitha")
                .lastName("Pathirana")
                .country("Sri Lanka")
                .gender(Gender.MALE)
                .interests("Cycling,Writing,Travelling")
                .phoneNumber("123456789")
                .email("sajitha@mail.com")
                .address("Somewhere in Somewhere")
                .designation("SDET")
                .contract(Contract.FULL_TIME)
                .joinedDate("2022-07-01").build();
    }

    @Test
    public void addNewUser() {
        //Navigate to the login page
        LoginPage loginPage = new LoginPage(page);
        loginPage.goToPage();

        //Login to the application
        MenuPage menuPage = loginPage.login("admin", "123");

        //Creating a new user
        BasicUserRegistrationPage basicUserRegistrationPage = menuPage.goToBasicRegistration();
        basicUserRegistrationPage.createNewUser(userDetails);

        //assertion from playwright
        assertThat(basicUserRegistrationPage.getElement("First Name")).isVisible();

        //assertion from junit
        Assertions.assertEquals(basicUserRegistrationPage.getElement("First Name").textContent(), userDetails.getFirstName());
        Assertions.assertEquals(basicUserRegistrationPage.getElement("Last Name").textContent(), userDetails.getLastName());
        Assertions.assertEquals(basicUserRegistrationPage.getElement("Interests").textContent(), userDetails.getInterests());
        Assertions.assertEquals(basicUserRegistrationPage.getElement("Country").textContent(), userDetails.getCountry());
    }
}

