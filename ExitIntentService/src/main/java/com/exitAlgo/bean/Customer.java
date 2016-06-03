package com.exitAlgo.bean;

public class Customer
{
    private MyData myData;

    private String currUrl;
    
    private String user="root" ;

    public String getUser() {
    	if(user.length()<4){user="root";}
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public MyData getMyData ()
    {
        return myData;
    }

    public void setMyData (MyData myData)
    {
        this.myData = myData;
    }

    public String getCurrUrl ()
    {
        return currUrl;
    }

    public void setCurrUrl (String currUrl)
    {
        this.currUrl = currUrl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [myData = "+myData+", currUrl = "+currUrl+"]";
    }
}