package Routes;

import static Routes.BaseRoute.baseUrl;

public class RouteUsersEndPoint {
    public static final String allUsers = baseUrl + "/users";
    public static final String singleUser = baseUrl + "/users" + "/{id}";
}
