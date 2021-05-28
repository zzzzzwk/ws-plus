import org.reflections.Reflections;
import org.springframework.beans.BeansException;
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
public class WebSocketHandlerScanner implements ApplicationContextAware {
    private ApplicationContext context;

    public Set<Class<?>> scan(String packageUrl){
        Reflections reflections=new Reflections(packageUrl);
        return reflections.getTypesAnnotatedWith(WebSocketHandler.class);
    }
    public Set<String> getNames(){
        String[] namesForAnnotation = context.getBeanNamesForAnnotation(WebSocketHandler.class);
        return new HashSet<String>(Arrays.asList(namesForAnnotation));
    }
    public Set<Object> getBeans(){
        var set=new HashSet<Object>();
        getNames().forEach(s -> set.add(context.getBean(s)));
        return set;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
}
