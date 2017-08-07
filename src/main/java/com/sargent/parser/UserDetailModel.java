package com.sargent.parser;

public class UserDetailModel {

    private long id;
    private String name;
    private String location;
    private String text;
    private String modifiedText;



    public UserDetailModel () {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getModifiedText() {
        return modifiedText;
    }

    public void setModifiedText(String modifiedText) {
        this.modifiedText = modifiedText;
    }
}
