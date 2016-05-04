package com.exitIntent.Client;

public class CustomerBehave {
	
	//Introducing the dummy constructor
    public CustomerBehave() {
    	
    }
	
	private  String token;
    private  int totalTime;
    private  int pageTime;
    private  int mouseHover;
    private  int initScore ;
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
	public void setToken(String token) {
		this.token = token;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public int getPageTime() {
		return pageTime;
	}
	public void setPageTime(int pageTime) {
		this.pageTime = pageTime;
	}
	public int getMouseHover() {
		return mouseHover;
	}
	public void setMouseHover(int mouseHover) {
		this.mouseHover = mouseHover;
	}
	public int getInitScore() {
		return initScore;
	}
	public void setInitScore(int initScore) {
		this.initScore = initScore;
	}
	public int getPageVisited() {
		
		return pageVisited;
	}
	

}
