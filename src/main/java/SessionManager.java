import javax.websocket.Session;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zwk
 * @Date 2021/5/27
 * @Version 1.0
 * @Description
 **/
public class SessionManager {
    private final Map<String, Session> map=new ConcurrentHashMap<String, Session>();
    private final ThreadLocal<Session> sessionThreadLocal=new ThreadLocal<Session>();
    private SessionManager(){}
    public static SessionManager getInstance(){
        return new SessionManager();
    }

    public void put(Session session){
        if (!this.map.containsKey(session.getId())){
            this.map.put(session.getId(),session);
        }
    }
    public Session getCurrent(){
        return sessionThreadLocal.get();
    }
    public List<Session> getAll(){
        return (List<Session>) this.map.values();
    }
}
