package com.basicsetup;

import com.basicsetup.handlers.LoginHandler;
import com.basicsetup.handlers.PostHandler;
import com.basicsetup.model.responseDto.fastapi.Post;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostApi {

    //Init initialize the PostHelper

    private LoginHandler loginHandler;
    private PostHandler postHandler;

    @BeforeClass
    public void init() {

        this.loginHandler = new LoginHandler();
        this.postHandler = new PostHandler();
        //      postHelper.getAccessToken();

    }

    @Test()//priority = 0)
    public void testLogin() {
        loginHandler.getAccessToken();
    }

    @Test(groups = {"sanity"},dependsOnMethods ={"testLogin"} )
    public void createPostTest() {
        Response response = postHandler.createPost();
        Assert.assertEquals(response.getStatusCode(), 201);
        Post postObject = response.as(Post.class);
        Assert.assertEquals(postObject.getTitle(), "2wewe");
        Assert.assertEquals(postObject.getContent(), "wewew");

        // Assert.assertEquals(title,p);
    }
}
