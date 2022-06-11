package com.basicsetup;

import com.basicsetup.helpers.PostHelper;
import com.basicsetup.model.responseDto.fastapi.Post;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostApi {

    //Init initialize the PostHelper

    private PostHelper postHelper;

    @BeforeClass
    public void init() {

        postHelper = new PostHelper();
        postHelper.getAccessToken();

    }

    @Test()
    public void createPostTest() {
        Response response = postHelper.createPost();
        Assert.assertEquals(response.getStatusCode(), 201);
        Post postObject = response.as(Post.class);
        Assert.assertEquals(postObject.getTitle(),"2wewe");
        Assert.assertEquals(postObject.getContent(),"wewew");

        // Assert.assertEquals(title,p);
    }
}
