package com.exitAlgo.bean;

public class Customer
{
    private MyData myData;

    private String currUrl;

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