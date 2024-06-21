package sms.pages;

import com.microsoft.playwright.Page;

public class MenuPage extends BasePage {
    public MenuPage(Page page) {
        super(page);
    }

    @Override
    public void goToPage() {
        page.navigate("/employee_registration/menu.html");
    }

    public BasicUserRegistrationPage goToBasicRegistration() {
        page.navigate("/employee_registration/html-elements/basic_html.html");
        return new BasicUserRegistrationPage(page);
    }

}