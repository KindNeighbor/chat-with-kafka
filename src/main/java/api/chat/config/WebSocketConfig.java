package api.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/api/chat-room");       //클라이언트에서 보낸 메세지를 받을 prefix
        registry.enableSimpleBroker("/api/topic/chat-room");    //해당 주소를 구독하고 있는 클라이언트들에게 메세지 전달
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") //SockJS 연결 주소
            .setAllowedOrigins("*");
//            .withSockJS(); //버전 낮은 브라우저에서도 적용 가능 (이 부분 테스트 필요)
        // 주소 : ws://localhost:8080/chat
    }
}
