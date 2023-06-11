package tests.hsbc.calculator.tests.notAbleToLendTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.reusableTestMethods.pageObject.pageMethods;

import static tests.reusableTestMethods.testTearDown.terminateAllBrowserInstances.terminateBrowsers;

public class lenderIsNotWillingToLendTestWherePropertyValIsLessThanTwoTimesTheLoanAmount extends pageMethods {

    String test_case = "TC3";

    /**
     * This test references to the test case "TC3" on the spreadsheet here:
     * https://docs.google.com/spreadsheets/d/1ylQhPdgWgxmX1WwW-__SO05X9HXZVLSAV20Pj83LbY0/edit?usp=sharing
     */

    @BeforeAll
    public static void initializeBrowser(){
        initializeChromeBrowser(false);
    }

    @Test
    void lenderIsNotWillingToLendTest(){
        navigateToCalculatorUrl();
        inputValuesIntoBuyToLetFormPage("70000",
                "40000",
                "1000",
                "323",
                "1.00");
        assertCalculatorResult("57.15 %",
                "Property value criteria not met");


    }

    @AfterAll
    static void terminateBrowserWindows(){
        terminateBrowsers();
    }

}
