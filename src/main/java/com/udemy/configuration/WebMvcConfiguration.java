package com.udemy.configuration;

import com.udemy.component.RequestTimeInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
Anotacion para indicar que es una clases de configuracion, en ocasiones la configuracion
de application.yml queda muy corta y es necesario implementar configuraciones a traves
de una clase,  la cual se aplicara globalmente dentro de la aplicacion
*/

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    @Qualifier("requestTimeInterceptor")
    RequestTimeInterceptor requestTimeInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTimeInterceptor);
    }
    
}