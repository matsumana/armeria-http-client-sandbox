package info.matsumana.sandbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linecorp.armeria.spring.AnnotatedServiceRegistrationBean;

import info.matsumana.sandbox.handler.RootHandler;

@Configuration
public class ArmeriaHttpServiceConfig {

    @Bean
    public AnnotatedServiceRegistrationBean rootHandlerRegistrationBean(RootHandler handler) {
        return new AnnotatedServiceRegistrationBean()
                .setServiceName("rootHandler")
                .setService(handler);
    }
}
