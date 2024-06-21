package sms.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    public LoginPage(Page page) {
        super(page);
    }

    @Override
    public void goToPage() {
        page.navigate("/employee_registration/");
    }

    public MenuPage login(String username, String password) {
        page.getByPlaceholder("Your username..").fill(username);
        page.getByPlaceholder("Enter password").fill(password);
        page.locator("id=submit").click();
        return new MenuPage(page);
    }


}
