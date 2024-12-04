package org.study.learnspring.envrionment;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class DevConfigTest {

    @Test
    void configNotAvailble_ifProfileNotActive() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DevConfig.class);
        assertThatThrownBy(() -> applicationContext.getBean("testBean"))
            .isInstanceOf(NoSuchBeanDefinitionException.class);
    }
}
