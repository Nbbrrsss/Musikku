package com.example.musikku;

public class musikitem {

    private String title;
    private String key_id;
    private String fstatus;

    public musikitem() {
    }

    public musikitem(String title, String key_id, String fstatus) {
        this.title = title;
        this.key_id = key_id;
        this.fstatus = fstatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus;
    }
}
