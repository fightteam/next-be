package org.fightteam.next.config;

import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by excalibur on 2014/6/23.
 */
@Order(1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class, DataSourceConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebSpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        DelegatingFilterProxy shiroFilter = new DelegatingFilterProxy("shiroFilter");
        shiroFilter.setTargetFilterLifecycle(true);

        OpenEntityManagerInViewFilter entityManagerFactory = new OpenEntityManagerInViewFilter();
        entityManagerFactory.setEntityManagerFactoryBeanName("entityManagerFactory");

        return new Filter[]{characterEncodingFilter, shiroFilter, entityManagerFactory};
    }

}
