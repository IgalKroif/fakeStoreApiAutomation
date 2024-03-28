package utils.Validation.Header;

import io.restassured.response.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class validateHeaders {
    public static void validateHeaderResponseData(Response response) {
        SimpleDateFormat gmtDateFormat = findGmtTime();
        response.then()
                .headers("Content-Type", "application/json; charset=utf-8")
                .and()
                .headers("Content-Encoding", "gzip")
                .and()
                .headers("Connection", "keep-alive")
                .and()
                .headers("Server", "cloudflare")
                .and()
                .headers("Date", gmtDateFormat.format(new Date()));
    }

    public static SimpleDateFormat findGmtTime() {
        // Get the current date in the GMT time zone
        SimpleDateFormat gmtDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return gmtDateFormat;
    }
}
