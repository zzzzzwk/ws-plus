import exceptions.IllegalCommandException;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zwk
 * @Date 2021/5/28
 * @Version 1.0
 * @Description
 **/
public class WebSocketCommandMap {
    private final Map<String, Method> methodMap=new ConcurrentHashMap<>();
    private final Map<Method,Object> methodObjectMap=new ConcurrentHashMap<>();
    public static WebSocketCommandMap getInstance(){
        return new WebSocketCommandMap();
    }
    private WebSocketCommandMap() {
    }
    public void putMethod(String command,Method method){
        if (this.methodMap.containsKey(command))
            throw new IllegalCommandException("");
        this.methodMap.put(command,method);
    }
    public Method getMethod(String command){
        if (this.methodMap.containsKey(command))
            return this.methodMap.get(command);
        else throw new IllegalCommandException("");
    }
    public void putObject(Method method,Object object){
        if (this.methodObjectMap.containsKey(method))
            throw new IllegalCommandException("");
        this.methodObjectMap.put(method,object);
    }
    public Object getObject(Method method){
        if (this.methodObjectMap.containsKey(method))
            return this.methodObjectMap.get(method);
        else throw new IllegalCommandException("");
    }
}
