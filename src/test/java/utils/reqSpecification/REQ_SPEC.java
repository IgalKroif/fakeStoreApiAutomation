package utils.reqSpecification;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public interface REQ_SPEC {
    default RequestSpecification getRequestSpec() {
        HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", 6000)
                .setParam( "http.receive.timeout", 6000)
                .setParam("http.socket.timeout", 6000);

        RestAssuredConfig restAssuredConfig = RestAssuredConfig.config()
                .httpClient(httpClientConfig)
                .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())
                .logConfig(LogConfig.logConfig().enablePrettyPrinting(true));

        return new RequestSpecBuilder()
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .log(LogDetail.PARAMS)
                .log(LogDetail.COOKIES)
                .setConfig(restAssuredConfig)
                .build()
                .filter(new AllureRestAssured());
    }
}
