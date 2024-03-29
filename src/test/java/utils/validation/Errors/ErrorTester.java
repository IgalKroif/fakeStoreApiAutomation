package utils.validation.Errors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class ErrorTester {
    private final ObjectMapper objectMapper;

    public ErrorTester() {
        this.objectMapper = new ObjectMapper();
    }

    public void assertErrorResponse(String jsonResponse, String expectedMessage) {
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            String status = jsonNode.get("status").asText();
            String message = jsonNode.get("message").asText();

            MatcherAssert.assertThat("Status should be 'error'", status, Matchers.equalTo("error"));
            MatcherAssert.assertThat("Message should match", message, Matchers.equalTo(expectedMessage));
        } catch (Exception e) {
            throw new AssertionError("Failed to parse JSON response", e);
        }
    }
}