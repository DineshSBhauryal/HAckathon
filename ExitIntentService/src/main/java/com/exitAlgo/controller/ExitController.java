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

		try{
		String currentUrl = 	customer.getCurrUrl() ;
		
		
		
		double pageTime =0 ;
		int pageVisitCount =0;
		MyData data = customer.getMyData() ;
		int pages =0 ;
		try{
		pages =  Integer.parseInt(data.getAllPageView()) ;
		}catch(java.lang.NumberFormatException n){
    	return 0;
		}
		//double histScore = custm.historyVal(user.replaceAll("\"", ""));
		//System.out.println("historic score: "  + histScore + user);
		double totalTime = 0 ;
		PdpData[] pdp = data.getPdpData() ;
		for(PdpData page : pdp ){
			System.out.println(currentUrl + ": " + page.getUrl());
			if(!currentUrl.equals(page.getUrl())){
				
				totalTime = totalTime + Double.parseDouble(page.getTimeData());
				continue ;
			}else{
				pageVisitCount =  Integer.parseInt(page.getPdpCount());
				pageTime =  Double.parseDouble(page.getTimeData());
				totalTime = totalTime + Double.parseDouble(page.getTimeData());
			}
		}


		score = -1.4822 - 0.0367*pages+0.000405*pageTime/(1000)+0.000369*totalTime/(1000)+
				0.1583*pageVisitCount ;


		
		double p =( 1 / (1+(Math.exp(-score))) );
		System.out.println(p);
		double scr =Math.log(p);
		

		return p ;
		}catch(Exception e){
			e.printStackTrace();
			return 0 ;
			
		}
	}
}


