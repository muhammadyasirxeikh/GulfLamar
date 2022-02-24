package com.gulflamar.app.model;

public class SingleServiceData {
    String Name;
    int images;

    public SingleServiceData(String name, int images) {
        Name = name;
        this.images = images;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
