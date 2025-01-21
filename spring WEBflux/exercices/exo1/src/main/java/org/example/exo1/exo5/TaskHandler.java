package org.example.exo1.exo5;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TaskHandler {

    private final TaskService taskService;
    public TaskHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public Mono<ServerResponse> getAllTasks(ServerRequest request) {
        return ServerResponse.ok().body(taskService.getTasks(), Task.class);
    }

    public Mono<ServerResponse> getTaskById(ServerRequest request) {
        String id = request.pathVariable("id");
        return taskService.getTask(id)
                .flatMap(task -> ServerResponse.ok().bodyValue(task))
                .switchIfEmpty(ServerResponse.notFound().build());  
    }
    public Mono<ServerResponse> createTask(ServerRequest request) {
        return request.bodyToMono(Task.class)
                .flatMap(taskService::addTask)
                .flatMap(task -> ServerResponse.ok().bodyValue(task));
    }

    public Mono<ServerResponse> updateTask(ServerRequest request) {
        String id = request.pathVariable("id");
        return request.bodyToMono(Task.class)
                .flatMap(task -> taskService.updateTask(id, task))
                .flatMap(updatedTask -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(updatedTask))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteTask(ServerRequest request) {
        String id = request.pathVariable("id");
        return taskService.deleteTask(id)
                .then(ServerResponse.noContent().build());
    }

}
