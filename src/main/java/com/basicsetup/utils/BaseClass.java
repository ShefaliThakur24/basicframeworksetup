package com.basicsetup.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    public static Logger logger;

    @BeforeSuite
    public void setUp() {
        logger = Logger.getRootLogger();
        PropertyConfigurator.configure("log4j.properties");
        logger.info("In Before Suite");
    }


}
