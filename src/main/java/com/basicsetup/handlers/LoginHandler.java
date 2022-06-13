package com.basicsetup.handlers;

import com.basicsetup.constants.EndPoints;
import com.basicsetup.model.responseDto.fastapi.LoginResponseDto;
import com.basicsetup.utils.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginHandler {

    public String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    public String USERNAME = ConfigManager.getInstance().getString("userName");
    public String PASSWORD = ConfigManager.getInstance().getString("password");

    public String getAccessToken() {
        Map<String, String> userRequestDto = new HashMap<>();
        userRequestDto.put("username", USERNAME);
        userRequestDto.put("password", PASSWORD);

        Response loginResponse = given().contentType("application/x-www-form-urlencoded")
                .accept(ContentType.JSON)
                .formParams(userRequestDto).
                post(BASE_URL + EndPoints.FAST_API_GET_LOGIN).andReturn();

        LoginResponseDto responseDto = loginResponse.as(LoginResponseDto.class);
        String accessToken = responseDto.getAccessToken();
//        this.bearerToken = accessToken;
        return accessToken;
    }

    public String getAccessTokenThroughDataProvider(String username, String password) {
        Map<String, String> formParamMap = new HashMap<>();
        formParamMap.put("username", username);
        formParamMap.put("password", password);

        Response loginResponse = given().contentType("application/x-www-form-urlencoded")
                .accept(ContentType.JSON)
                .formParams(formParamMap)
                .log().all()
                .post(BASE_URL + EndPoints.FAST_API_GET_LOGIN)
                .andReturn();

//        String res = loginResponse.prettyPrint();
//        System.out.println(res);
        LoginResponseDto responseDto = loginResponse.as(LoginResponseDto.class);
        String accessToken = responseDto.getAccessToken();
        return accessToken;
    }
}
