package project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.val;
import lombok.extern.slf4j.Slf4j;
import project.inter.FuctionNameAware;

@Slf4j
@Configuration
public class LoggingFuctionNameInterceptor extends HandlerInterceptorAdapter{
    
    // Before operation
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("시작시작");

        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
        log.info("종료종료");
    
    }
}