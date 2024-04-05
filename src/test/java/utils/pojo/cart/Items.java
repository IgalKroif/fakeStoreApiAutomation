package utils.pojo.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private int id;
    private int userId;
    private String date;
    private List<Product> products;
    private int __v;
}
