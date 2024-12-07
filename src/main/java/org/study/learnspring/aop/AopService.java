package org.study.learnspring.aop;

import org.springframework.stereotype.Service;

@Service
public class AopService {

    public static int executeCount = 0;

    @Retry
    public String countWithException() throws Throwable {
        executeCount++;
        if (executeCount < 2) {
            throw new Throwable();
        }

        return "success";
    }
}
