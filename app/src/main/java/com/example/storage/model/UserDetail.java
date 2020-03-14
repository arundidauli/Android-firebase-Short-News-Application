package com.example.storage.model;

public class UserDetail {
    private String image,name,sp_name,rpt_type;


    public UserDetail() {

    }

    public UserDetail(String image, String name, String sp_name, String rpt_type) {
        this.image = image;
        this.name = name;
        this.sp_name = sp_name;
        this.rpt_type = rpt_type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSp_name() {
        return sp_name;
    }

    public void setSp_name(String sp_name) {
        this.sp_name = sp_name;
    }

    public String getRpt_type() {
        return rpt_type;
    }

    public void setRpt_type(String rpt_type) {
        this.rpt_type = rpt_type;
    }
}
