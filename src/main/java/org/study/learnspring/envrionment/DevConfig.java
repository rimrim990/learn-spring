package org.study.learnspring.envrionment;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    public TestBean testBean() {
        return new TestBean();
    }
}
