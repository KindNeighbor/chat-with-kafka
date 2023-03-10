package api.chat.config;

import api.chat.dto.ChattingMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaReceiver {

    private final SimpMessagingTemplate template;

    @KafkaListener(id = "main-listener", topics = "kafka-chatting")
    public void receive(ChattingMessage message) throws Exception {

        log.info("message='{}'", message);

        HashMap<String, String> msg = new HashMap<>();
        msg.put("nickname", message.getNickname());
        msg.put("message", message.getMessage());
        msg.put("timestamp", message.getTimeStamp().toString());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(msg);

        this.template.convertAndSend("/api/topic/chat-room/" + message.getRoomId(), json);
    }
}
