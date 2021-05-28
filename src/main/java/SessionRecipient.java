import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @Author zwk
 * @Date 2021/5/26
 * @Version 1.0
 * @Description Session接收者
 **/
@ServerEndpoint("/**")
public class SessionRecipient {
    @OnOpen
    public void receive(Session session){
    }
    @OnMessage
    public void receive(Session session,String message){

    }
}
