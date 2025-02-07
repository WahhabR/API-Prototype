package com.IndividualAssignment.demo;

public class WikiSummary {

    public String title;

    public double pageid;

    public String description;

    public WikiSummary(String title, double pageid, String description){

        this.title = title;
        this.pageid = pageid;
        this.description = description;


    }

    public String getTitle (){
        return title;

    }
public void setTitle(String title){
        this.title = title;
}

public double getPageid(){
        return pageid;
}

public void setPageid(double pageid){
        this.pageid = pageid;

}

public String getDescription(){
        return description;
}

public void setDescription(String description){
        this.description = description;

}
}
