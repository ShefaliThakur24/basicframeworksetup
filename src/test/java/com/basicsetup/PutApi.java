package com.basicsetup;

import com.basicsetup.handlers.LoginHandler;
import com.basicsetup.handlers.PostHandler;
import com.basicsetup.utils.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PutApi extends BaseClass {

    private LoginHandler loginHandler;
    private PostHandler postHandler;

    @BeforeClass
    public void init() {
        this.loginHandler = new LoginHandler();
        this.postHandler = new PostHandler();
    }


    @Test(dataProvider = "TestDataProvider")
    public void testLoginThroughDataProvider(String username, String password) {
        loginHandler.getAccessTokenThroughDataProvider(username, password);
    }

    @Test(priority = 1)
    public void testPutPost() {
        String id = postHandler.putPost(3).jsonPath().getString("id");
        System.out.println(id);
    }
}