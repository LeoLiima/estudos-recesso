package desafio.api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY_HEADER = "X-API-KEY";
    private static final String API_KEY_VALUE = "tagview-desafio-2024";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // Aplica delay global de 3 segundos
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //  Lê o header da requisição
        String apiKey = request.getHeader(API_KEY_HEADER);

        //  Valida a API Key
        if (apiKey == null || !apiKey.equals(API_KEY_VALUE)) {
            // Se inválida → retorna 401 e encerra
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //  Se passou, continua o fluxo normal
        filterChain.doFilter(request, response);
    }
}
