package com.exitAlgo.bean;


public class PdpData
{
private String pdpCount;

private String timeData;

private String url;

public String getPdpCount ()
{
return pdpCount;
}

public void setPdpCount (String pdpCount)
{
this.pdpCount = pdpCount;
}

public String getTimeData ()
{
return timeData;
}

public void setTimeData (String timeData)
{
this.timeData = timeData;
}

public String getUrl ()
{
return url;
}

public void setUrl (String url)
{
this.url = url;
}

@Override
public String toString()
{
return "ClassPojo [pdpCount = "+pdpCount+", timeData = "+timeData+", url = "+url+"]";
}
}