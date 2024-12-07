package org.study.learnspring.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Commonly used named pointcut expressions
 */
public class CommonPointcuts {

    /**
     * matching methods defined under the org.study.learnspring.aop package
     */
    @Pointcut("within(org.study.learnspring.aop..*)")
    public void inAop() {}

    @Pointcut("within(org.study.learnspring.envrionment..*)")
    public void inEnvironment() {}

    /**
     * matching methods using method signature designator
     * - any method in the 'service' layer of the 'com.xyz' package
     */
    @Pointcut("execution(* org.study..aop.*.*(..))")
    public void aopService() {}

    /**
     * exeuction (modifiers-pattern?
     *              ret-type-pattern
     *              declaring-type-pattern?name-pattern(param-pattern)
     *              throws-pattern?)
     */
    @Pointcut("execution(* org.study.learnspring.envrionment.*.*(..))")
    public void environmentService() {}

    /**
     * Any method execution where the target object implments the 'TestBean' interface
     */
    @Pointcut("target(org.study.learnspring.envrionment.TestBean)")
    public void TestBean() {}
}
