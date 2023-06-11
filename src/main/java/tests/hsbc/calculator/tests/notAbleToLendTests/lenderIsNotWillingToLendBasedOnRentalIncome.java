package tests.hsbc.calculator.tests.notAbleToLendTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.reusableTestMethods.pageObject.pageMethods;

import static tests.reusableTestMethods.testTearDown.terminateAllBrowserInstances.terminateBrowsers;


public class lenderIsNotWillingToLendBasedOnRentalIncome extends pageMethods {

    String test_case = "TC4";

    /**
     * This test references to the test case "TC4" on the spreadsheet here:
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
                                        "1.00");
        assertCalculatorResult("49.39 %",
                                "Rental income criteria not met");


    }

    @AfterAll
    static void terminateBrowserWindows(){
        terminateBrowsers();
    }

}
