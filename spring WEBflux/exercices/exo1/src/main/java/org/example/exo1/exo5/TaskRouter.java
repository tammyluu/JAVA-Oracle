package org.example.exo1.exo5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TaskRouter {

    @Bean
    public RouterFunction<ServerResponse> routeTasks(TaskHandler handler) {
        return RouterFunctions
                .route(GET("/api/tasks"), handler::getAllTasks)
                .andRoute(GET("/api/tasks/{id}"), handler::getTaskById)
                .andRoute(POST("/api/tasks"), handler::createTask)
                .andRoute(PUT("/api/tasks/{id}"), handler::updateTask)
                .andRoute(DELETE("/api/tasks/{id}"), handler::deleteTask);
    }
}
