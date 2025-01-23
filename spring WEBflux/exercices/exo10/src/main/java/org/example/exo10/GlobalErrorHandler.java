package org.example.exo10.config;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class GlobalErrorHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();

        if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            return handleError(response, "UNAUTHORIZED", "Vous devez vous connecter pour accéder à cette ressource");
        } else if (response.getStatusCode() == HttpStatus.FORBIDDEN) {
            return handleError(response, "FORBIDDEN", "Vous n'avez pas les droits nécessaires pour accéder à cette ressource");
        }

        return handleError(response, "INTERNAL_SERVER_ERROR", "Une erreur inattendue s'est produite");
    }

    private Mono<Void> handleError(ServerHttpResponse response, String error, String message) {
        // Configuration de la réponse HTTP
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(HttpStatus.valueOf(response.getStatusCode().value()));

        // Création du message d'erreur JSON
        String errorMessage = String.format("{\"error\": \"%s\", \"message\": \"%s\"}", error, message);

        // Écriture de la réponse
        byte[] bytes = errorMessage.getBytes(StandardCharsets.UTF_8);
        return response.writeWith(Mono.just(response.bufferFactory().wrap(bytes)));
    }
}
