package tests.reusableTestMethods.pageObject;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator;
import tests.reusableTestMethods.testSetup.initializeBrowser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1800, 880));
        page = browserContext.newPage();
    }

    public static void navigateToCalculatorUrl(){
        page.navigate(returnCalculatorUrl());
        //assert that you have landed on the "Buy to Let Calculator" page
        assertThat(page.locator("//h1[text()='Buy to Let Calculator ']")).isVisible();
    }

    public static void pauseTestForSeconds(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void inputValuesIntoBuyToLetFormPage(String propertyValue,
                                                       String loanAmount,
                                                       String feeAmountToBeCapitalized,
                                                       String monthlyRentalIncome,
                                                       String productRate){
        //inputting the "Property Value"
        page.locator("//input[@id='property-value-input']").fill(propertyValue);

        //inputting the "Loan Amount"
        page.locator("//input[@id='loan-amount-input']").fill(loanAmount);

        //inputting the "Fee Amount To Be Capitalized"
        page.locator("//input[@id='fee-amount-input']").fill(feeAmountToBeCapitalized);

        //inputting the "Monthly Rental Income"
        page.locator("//input[@id='monthly-rental-income-input']").fill(monthlyRentalIncome);

        //inputting the "Application Type" > "Additional Borrowing"
        Locator dropDownAppType = page.locator("//select[@id='likeByLikeRemortgage-dropdown']");
        dropDownAppType.selectOption("1");

        //inputting the "Product Type" > "2 year fixed rate"
        Locator dropDownProdType = page.locator("//select[@id='productType-dropdown']");
        dropDownProdType.selectOption("1");

        //inputting the "Product Rate"
        page.locator("//input[@id='product-rate-input']").fill(productRate);

        //inputting the "Basic Rate Tax Payer"
        Locator dropDownIsTaxRatePayer = page.locator("//select[@id='taxRate-dropdown']");
        dropDownIsTaxRatePayer.scrollIntoViewIfNeeded();
        dropDownIsTaxRatePayer.selectOption("145");

        pauseTestForSeconds(2000);
    }

    public static void assertCalculatorResult(String expectedLoanToValPerc){

        String loanToValPerc = page.locator("//div[@id='ltv-value']").textContent();
        System.out.println("The loanToValPerc is ==== " + loanToValPerc);
        assertThat(page.locator("//div[@id='ltv-value']")).hasText(expectedLoanToValPerc);
    }

}
