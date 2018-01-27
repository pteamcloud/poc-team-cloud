package org.ptc.platform.config;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomErrorController implements ErrorController {
	  
    private static final String PATH = "/error";
 
    @Override
    public String getErrorPath() {
        return PATH;
    }
}