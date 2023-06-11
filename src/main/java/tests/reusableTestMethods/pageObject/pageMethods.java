package tests.reusableTestMethods.pageObject;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import tests.reusableTestMethods.testSetup.initializeBrowser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class pageMethods {

    public static Browser browser;
    public static BrowserContext browserContext;
    public static Page page;

    public static String returnCalculatorUrl(){

        String propertyValToReturn;

        InputStream input = initializeBrowser.class.getClassLoader().getResourceAsStream("environmentConfig.properties");
        Properties prop = new Properties();
        if (input == null) {
            System.out.println("Sorry, unable to find config.properties");
        }
        //load a properties file from class path, inside static method
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //get the property value and print it out
        propertyValToReturn = prop.getProperty("hsbc.buyToLetCalculatorURL");
        System.out.println("PROPERTY VALUE IS: " + propertyValToReturn);


        return propertyValToReturn;
    }

    public static void initializeChromeBrowser(boolean isHeadless) {
        Playwright pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless).setSlowMo(50));
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    public static void navigateToCalculatorUrl(){
        page.navigate(returnCalculatorUrl());
        System.out.println("This is the PAGE TITLE: " + page.title());

    }

//    public static void terminateBrowsers(){
//        page.close();
//    }
}
