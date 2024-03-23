package utils.reqSpecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class SpecifyRequest {

    public static RequestSpecification getRequestSpec() {
        HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout", 60000)
                .setParam( "http.receive.timeout", 60000)
                .setParam("http.socket.timeout", 60000);

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
                .build();
    }
}
