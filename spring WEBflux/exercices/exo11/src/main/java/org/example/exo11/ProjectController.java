package org.example.exo11;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class ProjectController {
    private final JwtService jwtService;

    public ProjectController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        return jwtService.generateToken(username,Map.of("role", "USER"));
    }
    @GetMapping
    public Mono<ResponseEntity<Map<String, Object>>> getProjects(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        try {
            // Vérifier si l'en-tête Authorization est présent
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of(
                                "error", "UNAUTHORIZED",
                                "message", "JWT token is missing or malformed"
                        )));
            }

            // Extraire le token (supprimer "Bearer ")
            String token = authorizationHeader.substring(7);

            // Valider le token et récupérer le username
            String username = jwtService.extractUsername(token);

            // Retourner la liste des projets
            return Mono.just(ResponseEntity.ok(Map.of(
                    "username", username,
                    "projects", new String[]{"Projet A", "Projet B"}
            )));
        } catch (ExpiredJwtException e) {
            return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "error", "UNAUTHORIZED",
                            "message", "JWT token has expired"
                    )));
        } catch (MalformedJwtException e) {
            return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "error", "UNAUTHORIZED",
                            "message", "Invalid JWT token"
                    )));
        } catch (Exception e) {
            return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "error", "UNAUTHORIZED",
                            "message", "Unauthorized access"
                    )));
        }
    }
}
