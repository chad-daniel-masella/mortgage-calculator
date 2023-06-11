package tests.reusableTestMethods.testTearDown;

import tests.reusableTestMethods.pageObject.pageMethods;

public class terminateAllBrowserInstances extends pageMethods{
    public static void terminateBrowsers(){
        page.close();
    }
}
