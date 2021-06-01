package org.wsplus.annotation;

import org.springframework.context.annotation.Import;
import org.wsplus.config.WebSocketPlusAutoConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author zwk
 * @Date 2021/6/1
 * @Version 1.0
 * @Description 开关
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(WebSocketPlusAutoConfiguration.class)
public @interface EnableWebSocketPlus {
}
