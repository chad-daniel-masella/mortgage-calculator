package tests.reusableTestMethods.testSetup;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import tests.reusableTestMethods.pageObject.pageMethods;

public class initializeBrowser extends pageMethods{

    /**
     * The idea here is to move all setup methods (instantiating the browser and configurations)
     * This is not done at the moment, but can be completed in the next iteration
     */
    public static void initializeChromeBrowser(boolean isHeadless) {
        Playwright pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless).setSlowMo(50));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1800, 880));
        page = browserContext.newPage();
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
