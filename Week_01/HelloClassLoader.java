package jvm;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args){
        try{
            new HelloClassLoader().findClass("jvm.Hello").newInstance();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
                e.printStackTrace();
        } catch (InstantiationException e) {
                e.printStackTrace();
        }
    }
}

@Override
protected Class<?> findClass(String name) throws ClassNotFoundException{
    File f = new File(this.getClass().getResource("/Hello.xlass").getPath());
    int length = (int)f.length();
    byte[] bytes = new byte[length];
    for (int i = 0; i < bytes.length; i++){
      bytes[i] = (byte)(255 - bytes[i]);
       }
    return defineClass(name,bytes,0,bytes.length);
}
