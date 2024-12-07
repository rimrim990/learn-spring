package org.study.learnspring.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Declaring a Pointcut
 * - pointucst enable us to control when advice runs
 * - matches the execution of methods on Spring beans
 */
public class Pointcuts {

    /**
     * 1. a signature comprising a name and any paramters
     * - provided by a regular method definition
     * 2. a pointcut expression that determines exactly which method exeuctions we are intersted in
     * - defined by using the @Pointcut annotation
     */
    @Pointcut("execution(public * * (..))") // the pointcut expression (regular AspectJ pointcut expression)
    public void anyPublicMethod() {} // the pointcut signature

    @Pointcut("within(org.study.learnspring..*)")
    public void inLearnSpring() {}

    // Building more complex pointcuts out of a smaller named pointcusts is a best practive
    @Pointcut("anyPublicMethod() && inLearnSpring()")
    public void learnSpringOperation() {}
}
