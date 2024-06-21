package sms.tests;

import com.automation.e2e.config.Configuration;
import com.bic.end_to_end.playwright.BicsPlaywright;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {
    static Playwright playwright;
    static Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeAll
    static void startPlaywright() {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(Boolean.parseBoolean(System.getenv("CI")));
        options.setSlowMo(0);
        playwright = Playwright.create();
        browser = playwright.chromium().launch(options);
    }

    @AfterAll
    static void cleanup() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void startBrowser() {
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        contextOptions.setIgnoreHTTPSErrors(true);
        contextOptions.setBaseURL(Configuration.getConfig().baseUrl());
        context = browser.newContext(contextOptions);
        context.setDefaultTimeout(30000);
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}

