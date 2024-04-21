package CreateRequest.deprecated;

import org.junit.jupiter.api.Disabled;
import utils.pojo.product.Products;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Deprecated
@Disabled
public class DeprecatedValidations {
    @Disabled
    public static void assertStreamedProductPrice(Products product, List<Object> expectedFieldNames) {
        assertThat(expectedFieldNames.stream().anyMatch(fieldName -> fieldName.equals(product.getPrice())), equalTo(true));
    }
    @Disabled
    public static void assertStreamedProductTitle(Products product, List<Object> expectedFieldNames) {
        assertThat(expectedFieldNames.stream().anyMatch(fieldName -> fieldName.equals(product.getTitle())), equalTo(true));
    }
    @Disabled
    public static void assertStreamedProductDescription(Products product, List<String> expectedFieldNames) {
        assertThat(expectedFieldNames.stream().anyMatch(fieldName -> fieldName.equals(product.getDescription())), equalTo(true));
    }
    @Disabled
    public static void assertStreamedProductCategory(Products product, List<String> expectedFieldNames) {
        assertThat(expectedFieldNames.stream().anyMatch(fieldName -> fieldName.equals(product.getCategory())), equalTo(true));
    }
    @Disabled
    public static void assertStreamedProductImage(Products product, List<String> expectedFieldNames) {
        assertThat(expectedFieldNames.stream().anyMatch(fieldName -> fieldName.equals(product.getCategory())), equalTo(true));
    }
}