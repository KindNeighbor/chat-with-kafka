package api.chat.config;

import api.chat.dto.ChattingMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<String, ChattingMessage> kafkaTemplate;

    public void send(String topic, ChattingMessage data) {
        log.info("sending data='{}' to topic='{}'", data, topic);
        kafkaTemplate.send(topic, data); // send to react clients via websocket(STOMP)
    }
}
