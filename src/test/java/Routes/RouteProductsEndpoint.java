package Routes;

import static Routes.BaseRoute.baseUrl;

public class RouteProductsEndpoint {
    public static final String allProducts = baseUrl + "/products";
    public static final String singleProduct = baseUrl + "/products" + "/{id}";
    public static final String allCategories = baseUrl + "/products/categories";
    public static final String specificCategory = baseUrl + "/products/category" + "/{category}";
}
