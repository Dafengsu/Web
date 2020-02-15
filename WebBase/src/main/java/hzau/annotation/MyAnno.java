package hzau.annotation;

/**
 * @description:
 * @author: su
 * @date: 2020/2/14
 */

public @interface MyAnno {

    int show();

    String name() default "张三";

    String[] names();
}
