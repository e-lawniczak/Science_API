package el.development.ScienceAPI.common.security;

import el.development.ScienceAPI.common.account.AccountRepository;
import el.development.ScienceAPI.common.account.AccountService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

import static el.development.ScienceAPI.common.security.SecurityVars.AUTH_COOKIE_NAME;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authHeader = request.getHeader("Authorization");
        String authCookie = null;
        String token = null;
        String username = null;

        var whitelist = Arrays.asList("/swagger-ui/", "/v3/api-docs", "/docs", "/auth/login", "/account/register");
        var isAnonymous = whitelist.stream().anyMatch(s -> request.getRequestURI().contains(s));
        if (isAnonymous) {
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getCookies() == null && request.getCookies().length == 0) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            filterChain.doFilter(request, response);
            return;
        }

        var cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals(AUTH_COOKIE_NAME)).findFirst();
        authCookie = cookie.map(Cookie::getValue).orElse(null);

        System.out.println("COOKIE: " + authCookie);

        if (authCookie != null && authCookie.length() > 0) {
//            token = authHeader.substring(7);
            token = authCookie;
            username = jwtUtil.extractEmail(token);
        }

        if (username == null || SecurityContextHolder.getContext().getAuthentication() != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            filterChain.doFilter(request, response);
            return;
        }

        
        var userDetails = accountService.loadUserByUsername(username);
        if (!jwtUtil.validateToken(token, userDetails)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            filterChain.doFilter(request, response);
            return;
        }

        var u = accountRepository.findByEmail(username);
        if (u.isPresent() && !u.get().getToken().equals(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            filterChain.doFilter(request, response);
            return;
        }


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails
                , null
                , userDetails.getAuthorities()
        );
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request, response);
    }
}
