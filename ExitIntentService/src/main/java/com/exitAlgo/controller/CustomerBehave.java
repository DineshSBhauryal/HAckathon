package com.exitAlgo.controller;

public class CustomerBehave {
	
	//Introducing the dummy constructor
    public CustomerBehave() {
    	
    }
	
	private  String token;
    private  int totalTime;
    private  int pageTime;
    private   int mouseHover;
    private   int initScore ;
    private  int pageVisited ;

    
    public CustomerBehave(String token,int totalTime,int pageTime,int mouseHover,int initScore,int pageVisited) {
        this.token =token;
        this.totalTime = totalTime;
        this.pageTime = pageTime;
        this.mouseHover = mouseHover;
        this.initScore = initScore;
        this.pageVisited = pageVisited;
    }
    
    
	public String getToken() {
		return token;
	}
	
	public int getTotalTime() {
		return totalTime;
	}
	
	public int getPageTime() {
		return pageTime;
	}
	
	public int getMouseHover() {
		return mouseHover;
	}
	
	public int getInitScore() {
		return initScore;
	}
	
	public int getPageVisited() {
		
		return pageVisited;
	}
	

}
