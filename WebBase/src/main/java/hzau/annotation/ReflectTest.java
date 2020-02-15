package hzau.annotation;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @description:
 * @author: su
 * @date: 2020/2/13
 */

@Pro(className = "hzau.annotation.Demo02", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //解析注解
        //1.1 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        String c = annotation.className();
        String m = annotation.methodName();

        Class<?> cls = Class.forName(c);
        Method method = cls.getMethod(m);
        Object o = cls.newInstance();
        method.invoke(o);
    }
}
