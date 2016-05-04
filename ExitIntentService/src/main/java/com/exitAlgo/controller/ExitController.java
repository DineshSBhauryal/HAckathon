package com.exitAlgo.controller;

	import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class ExitController {

	    private static  double score=0;
	    private final AtomicLong counter = new AtomicLong();
	    @CrossOrigin
	    @RequestMapping( value="getIntent",method = RequestMethod.POST)
	    
	    public @ResponseBody  double getIntent(@RequestBody CustomerBehave behave) {
	    	
	   
		   // score =  behave.getInitScore() +  behave.getTotalTime() + 2* behave.getPageTime()
		   // + 5* behave.getMouseHover() + 15*  behave.getPageVisited();   	
	    	
		    
		    score = -1.7268 - 0.0366*behave.getPageVisited()+0.1478*behave.getPageTime()+0.000369*behave.getTotalTime()+
		    		0.2697*behave.getMouseHover() ;
		 
		    double p = 1 / (1+(java.lang.Math.exp(-score))) ;
		    
	        return p ;
	        
	    }
	}


