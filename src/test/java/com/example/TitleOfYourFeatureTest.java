package com.example;

import org.testng.annotations.*;

public class TitleOfYourFeatureTest {
    // Tags: tag
    public Actionwords actionwords;
    
    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(String browser) {
        actionwords = new Actionwords(browser);
    }

    @Test
    public void accessoriesPageNavigation() throws Exception {
        // Given URL for Ribble Bikes works
        actionwords.uRLForRibbleBikesWorks();
        // When User hover over accessories in nav section
        actionwords.userHoverOverAccessoriesInNavSection();
        // And User clicks on Frameset
        actionwords.userClicksOnFrameset();
        // And User selects Price - Low to High
        actionwords.userSelectsPriceLowToHigh();
        // Then The price should be in acscending order
        actionwords.thePriceShouldBeInAcscendingOrder();
        // And User shuts down the browser
        actionwords.userShutsDownTheBrowser();
    }
}