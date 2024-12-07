package org.study.learnspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Declaring an Aspect
 * - any bean defined with a class that has the @Aspect annotation is automatically detected by Spring
 * - aspect bean cannot be the targets of advice from other aspects
 */
@Aspect
@Component
public class SimpleAspect {

    @Before("org.study.learnspring.aop.CommonPointcuts.inAop()") // named pointcut
    public void doAccessCheckBefore() {
        System.out.println("do access check before running method");
    }

    @AfterReturning(
        pointcut="org.study.learnspring.aop.CommonPointcuts.inAop()",
        returning="retVal"
    )
    public void doAcessCheckAfterReturning(Object retVal) {
        System.out.println("do access check after returning method, returnValue=" + retVal);
    }

    /**
     * receive exeception only from the join point, not from an accompnaying @After/@AfterReturning method
     */
    @AfterThrowing(
        pointcut="org.study.learnspring.aop.CommonPointcuts.inAop()",
        throwing="ex"
    )
    public void doAcessCheckAfterThrowing(Exception ex) {
        System.out.println("do access check after throwing exception during method execution, exception=" + ex);
    }

    /**
     * analogous to a finally block in a try-catch statement
     */
    @After("org.study.learnspring.aop.CommonPointcuts.inAop()")
    public void doAcessCheckAfter() {
        System.out.println("do access check after method");
    }

    /**
     * runs "around" a matched method's execution
     * - should declare Object as its return type
     */
    @Around("org.study.learnspring.aop.CommonPointcuts.inAop()")
    public Object doAccessCheckAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("do access check around[before] method");

        try {
            Object retVal = joinPoint.proceed();
            System.out.println("do access check around[after] method");
            return retVal;
        } catch (Throwable throwable) {
            System.out.println("do access check around[throwing] method");
            throw throwable;
        }
    }
}
