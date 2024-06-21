package sms.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import sms.dtos.UserDetails;

public class BasicUserRegistrationPage extends BasePage {
    public BasicUserRegistrationPage(Page page) {
        super(page);
    }

    @Override
    public void goToPage() {
        page.navigate("/employee_registration/html-elements/basic_html.html");
    }


    public void createNewUser(UserDetails userDetails) {
        page.getByPlaceholder("Your first name..").fill(userDetails.getFirstName());
        page.getByPlaceholder("Your last name..").fill(userDetails.getLastName());
        page.locator("id=country").selectOption(userDetails.getCountry());
        page.locator("xpath=//input[@value='" + userDetails.getGender().getGender() + "']").click();
        page.getByPlaceholder("Write something..").fill(userDetails.getInterests());

        page.locator("xpath=//a[text()='Next']").click();

        page.locator("xpath=//input[@id='phone']").fill(userDetails.getPhoneNumber());
        page.locator("xpath=//input[@id='email']").fill(userDetails.getEmail());
        page.locator("xpath=//textarea[@id='address']").fill(userDetails.getAddress());

        page.locator("xpath=//a[text()='Next']").click();

        page.locator("xpath=//input[@id='designation']").fill(userDetails.getDesignation());
        page.locator("id=contract").selectOption(userDetails.getContract().getContract());
        page.locator("xpath=//input[@id='joined_date']").fill(userDetails.getJoinedDate());

        page.locator("xpath=//a[text()='Next']").click();
    }

    public Locator getElement(String element) {
        return page.locator("xpath=//label[text()='" + element + "']/following-sibling::span");
    }
}
