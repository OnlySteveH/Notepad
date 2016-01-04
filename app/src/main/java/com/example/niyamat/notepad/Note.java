package com.example.niyamat.notepad;

/**
 * Created by Niyamat on 1/3/2016.
 */
public class Note {
    private String mId;
    private String mTitle;
    private String mBody;


    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
