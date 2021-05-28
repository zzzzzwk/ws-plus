
import java.util.Set;

/**
 * @Author zwk
 * @Date 2021/5/28
 * @Version 1.0
 * @Description
 **/
public class WebSocketCommandDispatcher {
    private Set<Object> webSocketHandlers;
    private final WebSocketHandlerScanner scanner;
    private final WebSocketCommandMap commandMap=WebSocketCommandMap.getInstance();

    public WebSocketCommandDispatcher(WebSocketHandlerScanner scanner) {
        this.scanner = scanner;
    }

    public void init(){
        this.webSocketHandlers=scanner.getBeans();
        for (var obj:webSocketHandlers){
            for (var method:obj.getClass().getMethods()){
                boolean isAnnotationPresent = method.isAnnotationPresent(WebSocketCommand.class);
                if (isAnnotationPresent){
                    var command=method.getAnnotation(WebSocketCommand.class).value();
                    this.commandMap.putMethod(command,method);
                    this.commandMap.putObject(method,obj);
                }
            }
        }
    }
}
