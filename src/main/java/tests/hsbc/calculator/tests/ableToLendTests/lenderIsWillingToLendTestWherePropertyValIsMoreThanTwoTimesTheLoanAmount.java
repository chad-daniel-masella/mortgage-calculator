package tests.hsbc.calculator.tests.ableToLendTests;

import org.junit.jupiter.api.*;
import tests.reusableTestMethods.pageObject.pageMethods;

import static tests.reusableTestMethods.testTearDown.terminateAllBrowserInstances.terminateBrowsers;

public class lenderIsWillingToLendTestWherePropertyValIsMoreThanTwoTimesTheLoanAmount extends pageMethods {

    String test_case = "TC1";

    /**
     * This test references to the test case "TC1" on the spreadsheet here:
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
                                        "323",
                                        "1.00");
        assertCalculatorResult("49.39 %",
                                "Rental income criteria met");


    }

    @AfterAll
    static void terminateBrowserWindows(){
        terminateBrowsers();
    }

}
