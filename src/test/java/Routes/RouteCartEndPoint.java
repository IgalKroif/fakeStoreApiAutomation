package Routes;

import static Routes.BaseRoute.baseUrl;

public class RouteCartEndPoint {
    /*
    * 2 carts as well as sort and order by using ? query params
    * */
    public static final String allCarts = baseUrl + "/carts";
    public static final String cartById = baseUrl + "/carts" + "/{id}";
}
