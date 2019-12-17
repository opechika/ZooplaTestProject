package co.uk.zoopla.hooks;

import co.uk.zoopla.commons.BrowserClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BrowserClass
{
    @Before
    public void setUp()
    {
        launchBrowser("Headless");
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
