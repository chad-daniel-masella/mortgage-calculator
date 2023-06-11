package tests.hsbc.calculator.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import tests.reusableTestMethods.testSetup.initializeBrowser;
import org.junit.jupiter.api.*;
import tests.reusableTestMethods.pageObject.pageMethods;
import tests.reusableTestMethods.testTearDown.terminateAllBrowserInstances;

import static tests.reusableTestMethods.testSetup.initializeBrowser.*;
import static tests.reusableTestMethods.testTearDown.terminateAllBrowserInstances.terminateBrowsers;

//import static tests.reusableTestMethods.testTearDown.terminateAllBrowserInstances.terminateBrowsers;

public class lenderIsWillingToLendTest extends pageMethods {

    @BeforeAll
    public static void initializeBrowser(){
        //to call initialize browser method
        //initializeBrowser.initializeChromeBrowser(false);
        initializeChromeBrowser(false);
    }

    @Test
    void lenderIsWillingToLendTest(){
        navigateToCalculatorUrl();


    }

    @AfterAll
    static void terminateBrowserWindows(){
        terminateBrowsers();
    }

}
