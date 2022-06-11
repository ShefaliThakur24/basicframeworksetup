package com.basicsetup;

import com.basicsetup.helpers.PostHelper;
import com.basicsetup.model.responseDto.fastapi.GetResponse;
import com.basicsetup.utils.BaseClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GetApi extends BaseClass {

    private PostHelper postHelper;

    @BeforeClass
    public void init() {
        postHelper = new PostHelper();

    }

    @Test
    public void testGetPosts() {
        logger.info("Starting Get Request");
        List<GetResponse> response = postHelper.getPostResponse();
        Assert.assertNotNull(response, "response is not empty");
        Assert.assertEquals(response.get(0).getPost().getContent(), "checkout these awesome beaches");

        // Assert.assertEquals(list.get(1).getPost().getContent(),equals(""));
    }

}
