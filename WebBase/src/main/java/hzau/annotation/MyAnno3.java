package hzau.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: su
 * @date: 2020/2/14
 */
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
}
