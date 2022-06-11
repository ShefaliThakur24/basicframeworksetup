package com.basicsetup.helpers;

import com.basicsetup.constants.EndPoints;
import com.basicsetup.model.requestDto.PostRequestDto;
import com.basicsetup.model.responseDto.fastapi.GetResponse;
import com.basicsetup.model.responseDto.fastapi.LoginResponseDto;
import com.basicsetup.utils.BaseClass;
import com.basicsetup.utils.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


/*Helper for hitting the Get,Post,Patch,Put,Delete */
public class PostHelper extends BaseClass {

//    We need to read the config variables
//    We need to tell the rest assured with url and port
//    making the request on the given url and send data to test method

    public String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    public String USERNAME = ConfigManager.getInstance().getString("userName");
    public String PASSWORD = ConfigManager.getInstance().getString("password");
    Map<String, Integer> queryparams = new HashMap<>();
    PostRequestDto requestDto = new PostRequestDto();
    Map<String, String> userRequestDto = new HashMap<>();
    String bearerToken = "";


    public PostHelper() {
//        super();
        baseURI = BASE_URL;
        /*for get post queryparams*/
        queryparams.put("limit", 1);
        queryparams.put("skip", 0);

        /*for post requestbody*/
        requestDto.setTitle("2wewe");
        requestDto.setContent("wewew");
        requestDto.setPublished(true);

        /*for creating user*/
        userRequestDto.put("username", USERNAME);
        userRequestDto.put("password", PASSWORD);
//        userRequestDto.setEmail(USERNAME);
//        userRequestDto.setPassword(PASSWORD);
        //   bearerToken = getAccessToken();
    }


    public String getAccessToken() {
        Response loginResponse = given().contentType("application/x-www-form-urlencoded")
                .accept(ContentType.JSON)
                .formParams(userRequestDto).
                post(baseURI + EndPoints.FAST_API_GET_LOGIN).andReturn();

        LoginResponseDto responseDto = loginResponse.as(LoginResponseDto.class);
        String accessToken = responseDto.getAccessToken();
        this.bearerToken = accessToken;
        return bearerToken;
    }


    public List<GetResponse> getPostResponse() {
        Response r = given().queryParams(queryparams).header("accept", "application/json").log().all()
                .when().get(baseURI + EndPoints.FAST_API_GET_POST);
       String res= r.prettyPrint();
        logger.info("the response is"+ res);

        GetResponse[] response = r.as(GetResponse[].class);
        List<GetResponse> list = new ArrayList<>();

        for (int i = 0; i < response.length; i++) {
            list.add(response[i]);
        }

//how to iterate and perform assertations
        return list;
    }

    public Response createPost() {

        Response response = given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Authorization", "Bearer " + bearerToken).
                body(requestDto).log().all().
                post(baseURI + EndPoints.FAST_API_CREATE_POST).andReturn();
        //  Assert.assertEquals(response.getStatusCode(), 201);
        return response;
    }

    public Response putPost(Integer id) {
        Response response = given().pathParam("id", id)
                .contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Authorization", "Bearer " + bearerToken).
                body(requestDto).log().all().
                put(baseURI + EndPoints.FAST_API_GET_POST_BY_ID).andReturn();

  Assert.assertEquals(response.getStatusCode(), 200);
        return response;

    }


}
