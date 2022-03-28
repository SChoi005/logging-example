package project.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import lombok.AllArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@AllArgsConstructor
public class Interceptor extends HandlerInterceptorAdapter{
    
    private final ObjectMapper objectMapper;
    
    // Request Body is null because controller doesn't execute yet
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper)request;
        final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper)response;
        
        log.info("====prehandle====");
        
        if(cachingRequest.getContentType()!=null && cachingRequest.getContentType().contains("application/json")){
            if(cachingRequest.getContentAsByteArray()!=null && cachingRequest.getContentAsByteArray().length!=0){
                log.info("Request Body : {}", objectMapper.readTree(cachingRequest.getContentAsByteArray()));
            }
        }

        if (cachingResponse.getContentType() != null && cachingResponse.getContentType().contains("application/json")) {
            if (cachingResponse.getContentAsByteArray() != null && cachingResponse.getContentAsByteArray().length != 0) {
                log.info("Response Body : {}", objectMapper.readTree(cachingResponse.getContentAsByteArray()));
            }
        }

        log.info("===================");
        
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
        
        final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper)request;
        final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper)response;
        
        log.info("====posthandle====");
        
        if(cachingRequest.getContentType()!=null && cachingRequest.getContentType().contains("application/json")){
            if(cachingRequest.getContentAsByteArray()!=null && cachingRequest.getContentAsByteArray().length!=0){
                log.info("Request Body : {}", objectMapper.readTree(cachingRequest.getContentAsByteArray()));
            }
        }

        if (cachingResponse.getContentType() != null && cachingResponse.getContentType().contains("application/json")) {
            if (cachingResponse.getContentAsByteArray() != null && cachingResponse.getContentAsByteArray().length != 0) {
                log.info("Response Body : {}", objectMapper.readTree(cachingResponse.getContentAsByteArray()));
            }
        }
        
        log.info("===================");
    
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper)request;
        final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper)response;
        
        log.info("====afterCompletion====");
        
        if(cachingRequest.getContentType()!=null && cachingRequest.getContentType().contains("application/json")){
            if(cachingRequest.getContentAsByteArray()!=null && cachingRequest.getContentAsByteArray().length!=0){
                log.info("Request Body : {}", objectMapper.readTree(cachingRequest.getContentAsByteArray()));
            }
        }

        if (cachingResponse.getContentType() != null && cachingResponse.getContentType().contains("application/json")) {
            if (cachingResponse.getContentAsByteArray() != null && cachingResponse.getContentAsByteArray().length != 0) {
                log.info("Response Body : {}", objectMapper.readTree(cachingResponse.getContentAsByteArray()));
            }
        }
        
        log.info("===================");
    }
    
}