package org.ptc.platform.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandlerController {
 
    @RequestMapping("/error")
    String error(Model model, HttpServletRequest http) {

    	int httpErrorCode = getErrorCode(http);
    	String errorMsg = "";
    	
    	
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
            	
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
        }
        
    	model.addAttribute("errorMsg", errorMsg);
    	model.addAttribute("jumTitle", "Oups... may be a problem ??!");
 
        return "errorHandler";
    }
    
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
}