package org.wsplus.util;

/**
 * @Author zwk
 * @Date 2021/5/31
 * @Version 1.0
 * @Description
 **/
public class StringConverter {
    public Object convert(String s,Class<?> clazz){
        Object obj=null;
        if (clazz==Integer.TYPE||clazz==Integer.class)
            obj=Integer.valueOf(s);
        else if (clazz==Double.TYPE||clazz==Double.class)
            obj=Double.valueOf(s);
        else if (clazz==Float.TYPE||clazz==Float.class)
            obj=Float.valueOf(s);
        else if (clazz==Boolean.TYPE||clazz==Boolean.class)
            obj=Boolean.valueOf(s);
        else if (clazz==Short.TYPE||clazz==Short.class)
            obj=Short.valueOf(s);
        else if (clazz==String.class||clazz==Character.TYPE||clazz==Character.class)
            obj=s;
        return obj;
    }
}
