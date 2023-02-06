package api.chat.controller;

import api.chat.domain.Room;
import api.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat-room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    // 채팅방 참여하기 - 굳이 필요한가..?
    @GetMapping("/{roomId}")
    public ResponseEntity<Room> enterRoom(@PathVariable Long roomId) {
        Room room = roomService.enterRoom(roomId);
        return ResponseEntity.ok(room);
    }

    // 채팅방 등록
    @PostMapping
    public ResponseEntity<Room> createRoom() {
        Room room = roomService.createRoom();
        return ResponseEntity.ok(room);
    }

    // 채팅방 삭제
    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
    }
}
