package com.listener.demo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListner
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("Request is destroyed");
    }
	
    public void requestInitialized(ServletRequestEvent event) {
    	System.out.println("Request created");
    }
}
