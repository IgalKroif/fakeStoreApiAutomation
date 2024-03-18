package Routes;

import static Routes.BaseRoute.baseUrl;

public class RouteProductsEndpoint {
    public static final String allProducts = baseUrl + "/products";
    public static final String singleProduct = allProducts + "/{id}";
}
