package api.chat.controller;

import api.chat.config.KafkaSender;
import api.chat.dto.ChattingMessage;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ChatController {

    private final KafkaSender kafkaSender;

    private static String BOOT_TOPIC = "kafka-chatting";

    // "/api/chat-room/{roomId}"로 들어오는 메시지를 "/api/topic/chat-room/{roomId}"을 구독하고있는 사람들에게 송신
    @MessageMapping("/{roomId}") // @MessageMapping works for WebSocket protocol communication. This defines the URL mapping.
    @SendTo("/api/topic/chat-room/{roomId}") // websocket subscribe topic & direct send
    public void sendMessage(@DestinationVariable Long roomId, ChattingMessage message) {
        message.setRoomId(roomId);
        message.setTimeStamp(LocalDateTime.now());
        kafkaSender.send(BOOT_TOPIC, message);
    }
}
