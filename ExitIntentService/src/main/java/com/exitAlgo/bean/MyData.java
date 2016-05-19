package com.exitAlgo.bean;

public class MyData
{
private String allPageView;

private PdpData[] pdpData;

public String getAllPageView ()
{
return allPageView;
}

public void setAllPageView (String allPageView)
{
this.allPageView = allPageView;
}

public PdpData[] getPdpData ()
{
return pdpData;
}

public void setPdpData (PdpData[] pdpData)
{
this.pdpData = pdpData;
}

@Override
public String toString()
{
return "ClassPojo [allPageView = "+allPageView+", pdpData = "+pdpData+"]";
}
}