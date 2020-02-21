package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author su
 * @description
 * @date 2020/2/21
 */
public class Teacher implements People {


    @Override
    public String work() {
        System.out.println("老师教书育人");
        return "教书";
    }
}
