package utils.CONSTANTS;

import net.datafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public interface CONSTANTS extends CONSTANT_VALIDATION {
    String dateFieldPattern = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z";
    String headerDatePattern = "\\p{Alpha}{3}, \\d{2} \\p{Alpha}{3} \\d{4} \\d{2}:\\d{2}:\\d{2} GMT";
}
