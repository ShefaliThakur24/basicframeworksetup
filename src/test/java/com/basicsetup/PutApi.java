package com.basicsetup;

import com.basicsetup.helpers.PostHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PutApi {

    private PostHelper postHelper;

    @BeforeClass
    public void init() {
        postHelper = new PostHelper();
        postHelper.getAccessToken();
    }

    @Test
    public void testPutPost() {
        String id = postHelper.putPost(3).jsonPath().getString("id");
        System.out.println(id);
    }
}