package com.udemy.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("batchComponent")
public class BatchComponent {
    
    private static final Log LOGGER = LogFactory.getLog(BatchComponent.class);

    //anotacion para indicar que se reptira la tarea con spring batch
    @Scheduled(fixedDelay = 3000) //ms
    public void repetir(){
        LOGGER.info("HORA: "+new Date());
    }

}
