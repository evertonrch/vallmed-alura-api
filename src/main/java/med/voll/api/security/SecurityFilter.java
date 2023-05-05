package med.voll.api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import med.voll.api.security.exception.TokenNuloException;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = headerAuth(request);

        System.out.println(tokenJWT);

        filterChain.doFilter(request,response);
    }

    private String headerAuth(HttpServletRequest request) {
        var token = request.getHeader("Authorization");
        if(token == null)
            throw new TokenNuloException("Token não enviado");

        return token.replaceAll("Bearer ", "");
    }
}
