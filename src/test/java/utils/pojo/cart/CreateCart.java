package utils.pojo.cart;

import lombok.Data;

import java.util.List;

@Data
public class CreateCart {
    private Object userId;
    private Object date;
    private List<Product> products;
}
