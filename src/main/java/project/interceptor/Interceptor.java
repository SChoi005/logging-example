package project.interceptor;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import lombok.val;
import lombok.extern.slf4j.Slf4j;
import project.inter.FuctionNameAware;

@Slf4j
@Configuration
public class Interceptor extends HandlerInterceptorAdapter{
    
    // Before operation
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        log.info("\n"+
                 "\tMethod:{}"+
                 "\n\tBody:{}", 
                 request.getMethod(), 
                 getRequestBody((ContentCachingRequestWrapper)request)
                );
        
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
        log.info("종료종료");
    
    }
    
    private Map getHeaders(HttpServletRequest request){
        Map headerMap = new HashMap<>();
        
        Enumeration headerArray = request.getHeaderNames();
        while(headerArray.hasMoreElements()){
            String headerName = headerArray.nextElement().toString();
            headerMap.put(headerMap, request.getHeader(headerName));
        }
        
        if(headerMap == null)
            return null;
        
        return headerMap;
    }
    
    private String getRequestBody(ContentCachingRequestWrapper request){
        
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        
        if(wrapper != null){
            byte[] buf = wrapper.getContentAsByteArray();
            if(buf.length>0){
               try{
                   return new String(buf,0,buf.length,wrapper.getCharacterEncoding());
               }catch(UnsupportedEncodingException e){
                   return "-";
               }
            }
        }
        
        return "-";
    }
    
    
    
}