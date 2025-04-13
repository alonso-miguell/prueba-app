package com.udemy.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.udemy.repository.LogRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Log LOGGER=LogFactory.getLog(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("logRepository")
    private LogRepository LogRepository;
    ///Metodo que se ejecutara antes de manejarse las peticiones
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                //obtenemos la hr actual en ms 
                LOGGER.info("ejecutando preHnadle");
                request.setAttribute("startTime", System.currentTimeMillis());
                return true;
    }

    //Metodo que se ejecutara DESPUES de manjear las peticiones
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        long startTime= (long) request.getAttribute("startTime");
        long totalTime=System.currentTimeMillis()-startTime;

        String URL=request.getRequestURL().toString();

        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        String username="";
        //checamos si esta autenticado el usuario
        if(auth!=null && auth.isAuthenticated() ){
            username=auth.getName();
        }

        
        com.udemy.entity.Log log=new com.udemy.entity.Log(new Date(), auth.getDetails().toString() , username, URL);
        LogRepository.save(log);



        LOGGER.info("Ejecutando afterCOmpletion Request desde: " +URL +" en "+totalTime+" ms");
    }

   
    
}