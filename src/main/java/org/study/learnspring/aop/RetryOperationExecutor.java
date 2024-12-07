package org.study.learnspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryOperationExecutor implements Ordered {

    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;
    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Around("org.study.learnspring.aop.CommonPointcuts.aopService() && "
        + "@annotation(org.study.learnspring.aop.Retry)")
    public Object retry(ProceedingJoinPoint jp) throws Throwable {
        int numAttempts = 0;
        Throwable throwable;
        do {
            numAttempts++;
            try {
                return jp.proceed(jp.getArgs());
            } catch (Throwable t) {
                throwable = t;
            }
        } while (numAttempts <= maxRetries);
        throw throwable;
    }
}
