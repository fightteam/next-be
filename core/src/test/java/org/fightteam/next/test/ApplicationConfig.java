package org.fightteam.next.test;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

/**
 * spring 的javaconfig配置
 */
@Configuration
@PropertySource(value = "classpath:properties/app.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
@ComponentScan(basePackages = "org.fightteam.next", excludeFilters = {
        @ComponentScan.Filter(Controller.class),
        @ComponentScan.Filter(Configuration.class)
})
public class ApplicationConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
