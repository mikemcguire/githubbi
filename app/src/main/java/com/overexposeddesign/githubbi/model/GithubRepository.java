package com.overexposeddesign.githubbi.model;


import java.util.Date;

public abstract class GithubRepository {
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

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setLanguage(String Language){
        this.language = language;
    }
    public void setOwnerName(String name){
        this.ownerName = name;
    }
    public void setOwnerAvatar(String url){
        this.ownerAvatar = url;
    }
    public void setLastUpdatedTime(Date time){
        this.lastUpdatedTime = time;
    }

}
