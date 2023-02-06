package api.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.chat.domain.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
