package api.chat.service;

import api.chat.domain.Room;
import api.chat.dto.RoomDto;
import api.chat.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    // 방만들기
    public Room createRoom() {
        return new Room();
    }

    // 방 입장
    public Room enterRoom(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow();
    }

    // 방 삭제
    @Transactional
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}
