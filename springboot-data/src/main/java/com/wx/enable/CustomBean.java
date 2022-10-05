package com.wx.enable;

public class CustomBean {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
