package utils.resSpecification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class SpecifyResponse {
    public static ResponseSpecification getResponseSpec() {
        HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", 6000)
                .setParam("http.receive.timeout", 6000)
                .setParam("http.socket.timeout", 6000);

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.STATUS)
                .log(LogDetail.COOKIES)
                .log(LogDetail.BODY)
                .build();
    }
}
