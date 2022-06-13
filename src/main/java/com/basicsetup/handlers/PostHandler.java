package com.basicsetup.handlers;

import com.basicsetup.constants.EndPoints;
import com.basicsetup.model.requestDto.PostRequestDto;
import com.basicsetup.model.responseDto.fastapi.GetResponse;
import com.basicsetup.utils.BaseClass;
import com.basicsetup.utils.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


/**
 * Helper for hitting the Get,Post,Patch,Put,Delete
 */
public class PostHandler extends BaseClass {

//    We need to read the config variables
//    We need to tell the rest assured with url and port
//    making the request on the given url and send data to test method

    private String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private LoginHandler loginHandler;


    public PostHandler() {
//        baseURI = BASE_URL;
        loginHandler = new LoginHandler();
    }


    public List<GetResponse> getPostResponse() {
        Map<String, Integer> queryParams = new HashMap<>();
        queryParams.put("limit", 1);
        queryParams.put("skip", 0);

        Response r = given().queryParams(queryParams).header("accept", "application/json").log().all()
                .when().get(BASE_URL + EndPoints.FAST_API_GET_POST);
        String res = r.prettyPrint();
        logger.info("the response is" + res);

        GetResponse[] response = r.as(GetResponse[].class);
        List<GetResponse> list = new ArrayList<>();

        for (int i = 0; i < response.length; i++) {
            list.add(response[i]);
        }

//how to iterate and perform assertations
        return list;
    }

    public Response createPost() {
        PostRequestDto requestDto = new PostRequestDto();
        requestDto.setTitle("2wewe");
        requestDto.setContent("wewew");
        requestDto.setPublished(true);

        Response response = given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Authorization", "Bearer " + loginHandler.getAccessToken()).
                body(requestDto).log().all().
                post(BASE_URL + EndPoints.FAST_API_CREATE_POST).andReturn();
        //  Assert.assertEquals(response.getStatusCode(), 201);
        return response;
    }

    public Response putPost(Integer id) {
        PostRequestDto requestDto = new PostRequestDto();
        requestDto.setTitle("2wewe");
        requestDto.setContent("wewew");
        requestDto.setPublished(true);

        Response response = given().pathParam("id", id)
                .contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Authorization", "Bearer " + loginHandler.getAccessToken()).
                body(requestDto).log().all().
                put(BASE_URL + EndPoints.FAST_API_GET_POST_BY_ID).andReturn();

        Assert.assertEquals(response.getStatusCode(), 200);
        return response;

    }


}
