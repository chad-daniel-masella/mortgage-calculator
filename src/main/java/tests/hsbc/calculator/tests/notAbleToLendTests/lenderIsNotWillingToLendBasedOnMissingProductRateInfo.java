package tests.hsbc.calculator.tests.notAbleToLendTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.reusableTestMethods.pageObject.pageMethods;

import static tests.reusableTestMethods.testTearDown.terminateAllBrowserInstances.terminateBrowsers;


public class lenderIsNotWillingToLendBasedOnMissingProductRateInfo extends pageMethods {

    String test_case = "TC5";

    /**
     * This test references to the test case "TC5" on the spreadsheet here:
     * https://docs.google.com/spreadsheets/d/1ylQhPdgWgxmX1WwW-__SO05X9HXZVLSAV20Pj83LbY0/edit?usp=sharing
     */

    @BeforeAll
    public static void initializeBrowser(){
        initializeChromeBrowser(false);
    }

    @Test
    void lenderIsWillingToLendTest(){
        navigateToCalculatorUrl();
        inputValuesIntoBuyToLetFormPage("81000",
                                        "40000",
                                        "1000",
                                        "300",
                                        "");
        assertCalculatorResult("--- %",
                                "Please ensure all fields are completed to generate a result");


    }

    @AfterAll
    static void terminateBrowserWindows(){
        terminateBrowsers();
    }

}
