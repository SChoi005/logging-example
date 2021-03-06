package project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import project.interceptor.Interceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Autowired
    private Interceptor interceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor)
            .addPathPatterns("/api/**");
            //.excludePathPatterns();        
    }
    
}