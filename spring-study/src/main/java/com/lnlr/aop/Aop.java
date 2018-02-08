package com.lnlr.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author 雷洪飞 on 10:02 2018/2/8.
 * desc
 */

@Aspect
public class Aop {

    @Pointcut("execution(* com.lnlr.aop..*.*(..))")
    public void test() {
    }

    @Before("test()")
    public void befor() {
        System.out.println("this is befor");
    }


}
