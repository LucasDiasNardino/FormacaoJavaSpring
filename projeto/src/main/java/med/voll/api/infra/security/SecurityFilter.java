package med.voll.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {           
        
        var tokenJWT = recuperarTokenJWT(request);
        System.out.println(tokenJWT);
        filterChain.doFilter(request, response);
    }

    private String recuperarTokenJWT(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if(authHeader == null){
            throw new RuntimeException("Token JWT não informado");
        }

        return authHeader;
    }
}
