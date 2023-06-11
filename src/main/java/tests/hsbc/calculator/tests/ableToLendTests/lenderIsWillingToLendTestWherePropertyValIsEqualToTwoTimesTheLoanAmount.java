package tests.hsbc.calculator.tests.ableToLendTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.reusableTestMethods.pageObject.pageMethods;

import static tests.reusableTestMethods.testTearDown.terminateAllBrowserInstances.terminateBrowsers;

public class lenderIsWillingToLendTestWherePropertyValIsEqualToTwoTimesTheLoanAmount extends pageMethods {

    String test_case = "TC2";

    /**
     * This test references to the test case "TC2" on the spreadsheet here:
     * https://docs.google.com/spreadsheets/d/1ylQhPdgWgxmX1WwW-__SO05X9HXZVLSAV20Pj83LbY0/edit?usp=sharing
     */

    @BeforeAll
    public static void initializeBrowser(){
        initializeChromeBrowser(false);
    }

    @Test
    void lenderIsWillingToLendTest(){
        navigateToCalculatorUrl();
        inputValuesIntoBuyToLetFormPage("80000",
                                        "40000",
                                        "1000",
                                        "323",
                                        "1.00");
        assertCalculatorResult("50.00 %",
                                "Rental income criteria met");


    }

    @AfterAll
    static void terminateBrowserWindows(){
        terminateBrowsers();
    }

}
