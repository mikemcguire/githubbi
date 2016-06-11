package com.overexposeddesign.githubbi.model;


import java.util.Date;

public class GIthubRepository {
    private String title;
    private String description;
    private String language;
    private String ownerName;
    private String ownerAvatar;
    private Date   lastUpdatedTime;
    private String URL;

    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public String getLanguage(){
        return this.language;
    }
    public String getOwnerName(){
        return this.ownerName;
    }
    public String getOwnerAvatar(){
        return this.ownerAvatar;
    }
    public Date getLastUpdatedTime(){
        return this.lastUpdatedTime;
    }

}
