package hzau.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: su
 * @date: 2020/2/14
 */
public class TestTask {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        int number = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : calculator.getClass().getMethods()) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(calculator);
                } catch (Exception e) {
                    number++;
                    writer.write(method.getName() + "方法出异常了");
                    writer.newLine();
                    writer.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    writer.newLine();
                    writer.write("异常原因： " + e.getCause().getMessage());
                    writer.newLine();
                    writer.write("--------------------------------");
                    writer.newLine();
                }
            }
        }
        writer.write("本次测试一共出现" + number + "次异常。");
        writer.flush();
        writer.close();
    }
}
