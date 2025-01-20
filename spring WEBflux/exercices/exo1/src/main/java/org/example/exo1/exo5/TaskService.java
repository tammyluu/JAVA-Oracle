package org.example.exo1.exo5;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TaskService {

    private final Map<String, Task> tasks = new HashMap<>();

    public Flux<Task> getTasks() {
        return Flux.fromIterable(tasks.values());
    }
    public Mono<Task> getTask(String id) {
        return Mono.justOrEmpty(tasks.get(id));

    }
    public Mono<Task> addTask(Task task) {
        UUID uuid = UUID.randomUUID();
        task.setUuid(uuid);
        tasks.put(uuid.toString(), task);
        return Mono.just(task);
    }

    public Mono<Task> updateTask(String id, Task updatedTask) {
        if (tasks.containsKey(id)) {
            Task existingTask = tasks.get(id);
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setCompleted(updatedTask.isCompleted());
            return Mono.just(existingTask);
        } else {
            return Mono.empty();
        }
    }

    public Mono<Void> deleteTask(String id) {
        tasks.remove(id);
        return Mono.empty();
    }
}
