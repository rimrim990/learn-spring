package org.study.learnspring.envrionment;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

class AppConfigTest {

    @Test
    void propertySourceInjected() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TestBean testBean = (TestBean) applicationContext.getBean("testBean");
        assertThat(testBean.getName()).isEqualTo("myTestBean");
    }

    @Test
    void propertySourceAvailable_outsideOfConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Environment environment = applicationContext.getEnvironment();
        assertThat(environment.getProperty("testbean.name")).isEqualTo("myTestBean");
    }
}
