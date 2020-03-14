package com.example.storage.model;

public class Post {
    private String title,detail,date,image_url,video_url;
    private boolean is_verify;

    public Post() {
    }

    public Post(String title, String detail, String date, String image_url, String video_url, boolean is_verify) {
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.image_url = image_url;
        this.video_url = video_url;
        this.is_verify = is_verify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public boolean isIs_verify() {
        return is_verify;
    }

    public void setIs_verify(boolean is_verify) {
        this.is_verify = is_verify;
    }
}
