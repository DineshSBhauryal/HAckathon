package com.exitIntent.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exitIntent.Client.ScoreCalculate;
 
/*
 * author: Dinesh
 * 
 */
 
@Controller
public class ExitController {
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 System.out.println(ScoreCalculate.calculateScore());
 
		String message = ScoreCalculate.calculateScore() ;
		
				return new ModelAndView("welcome", "message", message);
	}
}