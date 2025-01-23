package org.example.exo10;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class RoomService {

        private final Map<String, Room> rooms = new HashMap<>();


        public Flux<Room> getAllRooms() {
            return Flux.fromIterable(rooms.values());
        }


        public Mono<Room> addRoom(Room room) {
            String id = UUID.randomUUID().toString();
            room.setId(id);
            rooms.put(room.getId(), room);
            return Mono.just(room);
        }

        public Mono<Void> deleteRoom(String id) {
            rooms.remove(id);
            return Mono.empty();
        }


}
