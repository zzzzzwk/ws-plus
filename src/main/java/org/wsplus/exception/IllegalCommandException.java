package org.wsplus.exception;

/**
 * @Author zwk
 * @Date 2021/5/28
 * @Version 1.0
 * @Description
 **/
public class IllegalCommandException extends WebSocketPlusException{
    public IllegalCommandException(String message) {
        super(message);
    }
}
