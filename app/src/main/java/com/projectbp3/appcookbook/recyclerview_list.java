package com.projectbp3.appcookbook;

public class recyclerview_list {
    private String title;
    private int image;
    private Class<?> destinationActivity;

    public recyclerview_list(String title, int image, Class<?> destinationActivity) {
        this.title = title;
        this.image = image;
        this.destinationActivity = destinationActivity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {

        this.image = image;
    }

    public Class<?> getDestinationActivity() {
        return destinationActivity;
    }

    public void setDestinationActivity(Class<?> destinationActivity) {
        this.destinationActivity = destinationActivity;
    }
}
