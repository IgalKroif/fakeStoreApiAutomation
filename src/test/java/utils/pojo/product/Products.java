package utils.pojo.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Products {
    private Object id;
    private Object title;
    private Object price;
    private Object description;
    private Object category;
    private Object image;
    private Rating rating;
}
