package com.asymptotik.web

import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
open class WebConfig : WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/hello")
        registry.addViewController("/index")
        registry.addRedirectViewController("/", "/index")
    }

    @Bean
    open fun viewResolver(): ViewResolver {
        val bean = InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/view/")
        bean.setSuffix(".jsp")
        return bean
    }

    @Bean
    open fun beanFactoryPostProcessor(): BeanFactoryPostProcessor {
        return BeanFactoryPostProcessor { beanFactory ->
            val bean = beanFactory.getBeanDefinition(
                DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME
            )

            bean.propertyValues.add("loadOnStartup", 1)
        }
    }
}