package el.development.ScienceAPI.security;

public class SecurityVars {
    public static final long JWT_EXPIRATION = 60 * 60* 1000;
    public static final String JWT_SECRET = "secret";
    public static final String AUTH_COOKIE_NAME ="jwt_auth_cookie";
}
