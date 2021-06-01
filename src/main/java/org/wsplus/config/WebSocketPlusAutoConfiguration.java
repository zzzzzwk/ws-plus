package org.wsplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wsplus.SessionManager;
import org.wsplus.SessionRecipient;
import org.wsplus.WebSocketCommandDispatcher;
import org.wsplus.WebSocketHandlerScanner;

/**
 * @Author zwk
 * @Date 2021/6/1
 * @Version 1.0
 * @Description 配置类
 **/
@Configuration
public class WebSocketPlusAutoConfiguration {
    @Bean
    public WebSocketHandlerScanner webSocketHandlerScanner(){
        return WebSocketHandlerScanner.getInstance();
    }
    @Bean(initMethod = "init")
    public WebSocketCommandDispatcher webSocketCommandDispatcher(WebSocketHandlerScanner scanner){
        return new WebSocketCommandDispatcher(scanner);
    }
    @Bean
    public SessionManager sessionManager(){
        return SessionManager.getInstance();
    }

    @Bean
    public SessionRecipient sessionRecipient(){
        return new SessionRecipient();
    }
}
