package org.wsplus;

import org.wsplus.annotation.WebSocketBody;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.wsplus.util.StringConverter;

import java.lang.reflect.Parameter;

/**
 * @Author zwk
 * @Date 2021/5/28
 * @Version 1.0
 * @Description
 **/
public class WebSocketCommandResolver {
    private final Gson gson=new GsonBuilder().create();
    private final StringConverter converter=new StringConverter();
    public Object[] resolve(Command command,Parameter[] parameters){
        if (parameters==null)
            return null;
        Object[] objects=new Object[parameters.length];
        for (int i=0;i<parameters.length;i++){
            boolean present = parameters[i].isAnnotationPresent(WebSocketBody.class);
            if (present){
                objects[i] = gson.fromJson(command.getBody(), parameters[i].getType());
            }else {
                var s=parameters[i].getName();
                objects[i]=converter.convert(command.getParams().get(s),parameters[i].getType());
            }
        }
        return objects;
    }
}
