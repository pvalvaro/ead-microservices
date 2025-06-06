package com.ead.authuser.configs;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@Configuration

@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class ResolverConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentsResolvers){
        argumentsResolvers.add(new SpecificationArgumentResolver());
        var pageable = new PageableHandlerMethodArgumentResolver();
        pageable.setFallbackPageable(PageRequest.of(0, 10));
        argumentsResolvers.add(pageable);
    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        //corsRegistry.addMapping("/users/**").allowedOrigins("http://example.com");
        //corsRegistry.addMapping("/auth/**").allowedOrigins("http://bbc.com");
        corsRegistry.addMapping("*").maxAge(3600);
    }
}
