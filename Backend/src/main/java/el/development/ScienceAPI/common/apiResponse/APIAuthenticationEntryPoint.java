package el.development.ScienceAPI.common.apiResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.server.Cookie;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static el.development.ScienceAPI.common.security.SecurityVars.AUTH_COOKIE_NAME;

@Component
public class APIAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        ApiResponse<Void> body =
                new ApiResponse<>(ApiStatusCode.UNAUTHORIZED);

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));

        ResponseCookie cookie = ResponseCookie.from(AUTH_COOKIE_NAME, "")
                .httpOnly(true)
                .path("/")
                .maxAge(0)
                .sameSite(Cookie.SameSite.LAX.toString())
                .build();

        response.addHeader("Set-Cookie", cookie.toString());
    }
}