package org.study.learnspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Enabling @AspectJ Support
 * - configure Spring AOP based on @AspectJ aspects
 * - enable auto-proxying beans
 */
@EnableAspectJAutoProxy
@ServletComponentScan
@SpringBootApplication
public class LearnSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringApplication.class, args);
    }

}
