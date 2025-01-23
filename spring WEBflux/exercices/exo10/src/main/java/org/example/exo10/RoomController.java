package org.example.exo10;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    public Flux<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping()
    public Mono<Room> createRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteRoom(@PathVariable String id) {
        return roomService.deleteRoom(id);

    }
}
