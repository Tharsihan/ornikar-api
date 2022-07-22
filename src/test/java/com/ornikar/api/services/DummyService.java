package com.ornikar.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

@Service
public class DummyService {

    @Value("${test.endpointR1}")
    private String endpointR1;
    @Value("${test.endpointR2}")
    private String endpointR2;
    @Value("${test.endpointR3}")
    private String endpointR3;
    @Value("${test.endpointR4}")
    private String endpointR4;
    @Value("${test.endpointR5}")
    private String endpointR5;


    public <T> T mapperResponse (String body, Class<T> reponseType) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(body, reponseType);
    }

    public ValidatableResponse getAllEmployeesRequest() {
         ValidatableResponse response= given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpointR1).then();
         return response;

    }
}

