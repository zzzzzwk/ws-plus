package org.wsplus;

import org.wsplus.annotation.WebSocketHandler;
import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author zwk
 * @Date 2021/5/27
 * @Version 1.0
 * @Description
 **/
public class WebSocketHandlerScanner implements ApplicationContextAware{
    private ApplicationContext context;
    private static final WebSocketHandlerScanner instance=new WebSocketHandlerScanner();

    private WebSocketHandlerScanner() {
    }

    public static WebSocketHandlerScanner getInstance(){
        return instance;
    }
    public Set<Class<?>> scan(String packageUrl){
        Reflections reflections=new Reflections(packageUrl);
        return reflections.getTypesAnnotatedWith(WebSocketHandler.class);
    }
    public Set<String> getNames(){
        String[] namesForAnnotation = context.getBeanNamesForAnnotation(WebSocketHandler.class);
        return new HashSet<>(Arrays.asList(namesForAnnotation));
    }
    public Set<Object> getBeans(){
        var set=new HashSet<>();
        getNames().forEach(s -> set.add(context.getBean(s)));
        return set;
    }
    public Object getBean(Class<?> clazz){
        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        this.context=applicationContext;
    }
}
