package org.wsplus;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author zwk
 * @Date 2021/5/26
 * @Version 1.0
 * @Description Session接收者
 **/
@ServerEndpoint("/t")
public class SessionRecipient {
    private final SessionManager sessionManager=SessionManager.getInstance();
    private WebSocketCommandDispatcher dispatcher;
    public static final Log LOG= LogFactory.getLog(SessionRecipient.class);

    public SessionRecipient() {
        this.dispatcher= (WebSocketCommandDispatcher) WebSocketHandlerScanner.getInstance().getBean(WebSocketCommandDispatcher.class);
    }

    @OnOpen
    public void receive(Session session){
        sessionManager.put(session);
    }
    @OnMessage
    public void receive(Session session,String message){
        Command command=null;
        try {
            command = new Gson().fromJson(message, Command.class);
        }catch (Exception e){
            LOG.warn("invalid command form for "+message);
            return;
        }
        try {
            assert command != null;
            dispatcher.dispatch(command);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
