package tests.reusableTestMethods.testSetup;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class initializeBrowser{


    public static void initializeChromeBrowser(boolean isHeadless) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("https://intermediaries.hsbc.co.uk/calculator/");
            System.out.println("This is the PAGE TITLE: " + page.title());
        }
    }

    // TODO: 2023/06/11 paramatize the start browser method to allow different types of browsers to be started from a single method
    public static void initializeBrowser(String browserType){
        if (browserType == "chromium"){
            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
                Page page = browser.newPage();
                //reusableTestMethods.navigate("http://playwright.dev");
                //System.out.println(reusableTestMethods.title());
            }
        }
    }
}
