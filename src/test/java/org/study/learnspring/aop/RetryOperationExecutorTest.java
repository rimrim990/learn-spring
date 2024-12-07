package org.study.learnspring.aop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetryOperationExecutorTest {

    @Autowired
    AopService aopService;

    @Test
    void retryAfterException() throws Throwable {
        /**
         * [try-1]
         * do access check around[before] method
         * do access check before running method
         * do access check after method
         * do access check around[throwing] method
         *
         * [try-2]
         * do access check around[before] method
         * do access check before running method
         * do access check after returning method, returnValue=success
         * do access check after method
         * do access check around[after] method
         */
        String result = aopService.countWithException();

        assertThat(result).isEqualTo("success");
        assertThat(AopService.executeCount).isEqualTo(2);
    }
}
