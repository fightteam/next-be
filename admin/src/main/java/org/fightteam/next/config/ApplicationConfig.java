package org.fightteam.next.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@PropertySource(value = "classpath:properties/app.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
@ComponentScan(basePackages = "org.fightteam.next", excludeFilters = {
        @ComponentScan.Filter(Controller.class),
        @ComponentScan.Filter(ControllerAdvice.class),
        @ComponentScan.Filter(Configuration.class)
})
public class ApplicationConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
