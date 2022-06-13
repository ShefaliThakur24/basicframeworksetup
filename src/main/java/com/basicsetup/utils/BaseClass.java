package com.basicsetup.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class BaseClass {
    public static Logger logger;

    @BeforeSuite
    public void setUp() {
        logger = Logger.getRootLogger();
        PropertyConfigurator.configure("log4j.properties");
        logger.info("In Before Suite");
    }

    @DataProvider(name="TestDataProvider")
    public Object[][] getDataFromProvider(){
return new Object[][]{{"shefali@gmail.com","shefali"},{"shefali24@gmail.com","shefali24"}};
    }


}
