package org.wsplus;

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
    private final Map<String, Session> map=new ConcurrentHashMap<>();
    private final ThreadLocal<Session> sessionThreadLocal=new ThreadLocal<>();
    private static final SessionManager manager=new SessionManager();
    private SessionManager(){}
    public static SessionManager getInstance(){
        return manager;
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
    public void setCurrent(Session session){
        this.sessionThreadLocal.set(session);
    }
}
