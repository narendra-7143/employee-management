package com.exm.fp.response;

import org.springframework.stereotype.Component;

@Component
public class Message {
	
	    private String message;

	    public Message(String message) {
	        // TODO Auto-generated constructor stub
	        this.message = message;
	    }
	    
	    public Message() {
	        
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	}