package utils.validation.Header;

import io.restassured.response.Response;
import utils.CONSTANTS.CONSTANTS;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static org.hamcrest.Matchers.matchesPattern;

public class validateHeaders implements CONSTANTS {
    public static void validateHeaderResponseData(Response response) {
        response.then()
                .headers("Content-Type", "application/json; charset=utf-8")
                .and()
                .headers("Content-Encoding", "gzip")
                .and()
                .headers("Connection", "keep-alive")
                .and()
                .headers("Server", "cloudflare")
                .and()
                .header("Date", matchesPattern(headerDatePattern));
    }

    public static SimpleDateFormat findGmtTime() {
        // Get the current date in the GMT time zone
        SimpleDateFormat gmtDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return gmtDateFormat;
    }
}