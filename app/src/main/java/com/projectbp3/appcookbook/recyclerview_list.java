package com.projectbp3.appcookbook;

import androidx.fragment.app.Fragment;

public class recyclerview_list {
    private String title;
    private int image;
    private Fragment destinationFragment;

    public recyclerview_list(String title, int image, Fragment destinationFragment) {
        this.title = title;
        this.image = image;
        this.destinationFragment = destinationFragment;
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

    public Fragment getDestinationFragment() {
        return destinationFragment;
    }

    public void setDestinationActivity(Class<?> destinationActivity) {
        this.destinationFragment = destinationFragment;
    }
}
