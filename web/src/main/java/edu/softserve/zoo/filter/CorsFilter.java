package edu.softserve.zoo.filter;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Taras Zubrei
 */
@Component
public class CorsFilter extends OncePerRequestFilter {
    @Value("${token.header}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!Strings.isNullOrEmpty(request.getHeader("Origin"))) {
            response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Headers",
                    request.getHeader("Access-Control-Request-Headers"));
            response.addHeader("Access-Control-Expose-Headers", tokenHeader);
        }
        if (Objects.equals(request.getMethod(), "OPTIONS")) {
            response.getWriter().print("OK");
            response.getWriter().flush();
            return;
        }
        filterChain.doFilter(request, response);
    }
}
