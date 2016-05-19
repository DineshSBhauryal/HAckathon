package com.exitAlgo.controller;

	import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exitAlgo.bean.Customer;
import com.exitAlgo.bean.MyData;
import com.exitAlgo.bean.PdpData;

	@RestController
	public class ExitController {

	    private static  double score=0;
	    private final AtomicLong counter = new AtomicLong();
	    @CrossOrigin
	    @RequestMapping( value="getIntent",method = RequestMethod.POST)
	    
	    public @ResponseBody  double getIntent(@RequestBody Customer customer) {
	    	
	   
		   // score =  behave.getInitScore() +  behave.getTotalTime() + 2* behave.getPageTime()
		   // + 5* behave.getMouseHover() + 15*  behave.getPageVisited();   	
	    	
	   String currentUrl = 	customer.getCurrUrl() ;
	   double pageTime =0 ;
	   int pageVisitCount =0;
	   MyData data = customer.getMyData() ;
	   ;
	 int pages =  Integer.parseInt(data.getAllPageView()) ;
	 double totalTime = 0 ;
	   PdpData[] pdp = data.getPdpData() ;
	   for(PdpData page : pdp ){
		   System.out.println(currentUrl + ": " + page.getUrl());
		   if(!currentUrl.equals(page.getUrl())){
			   //System.out.println(page.getUrl() +"iside if");
			   totalTime = totalTime + Double.parseDouble(page.getTimeData());
			   continue ;
		   }else{
			  pageVisitCount =  Integer.parseInt(page.getPdpCount());
			  pageTime =  Double.parseDouble(page.getTimeData());
			  totalTime = totalTime + Double.parseDouble(page.getTimeData());
		   }
	   }
	   
		    
		  score = -1.7268 - 0.0366*pages+0.1478*pageTime/(1000*60)+0.000369*totalTime/(1000*60)+
		    		0.2697*pageVisitCount ;
		 
		  
		  System.out.println(pages  + " : " + pageTime + " : " +totalTime+ " : " +pageVisitCount );
		    double p = 1 / (1+(java.lang.Math.exp(-score))) ;
		    System.out.println(score + "  :   " + p);
		    
	        return p ;
	        
	    }
	}


