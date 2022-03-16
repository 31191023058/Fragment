package com.quocanh.fragment;

public class Photo {
    private int id;
    private int category;
    private String source_photo;
    private String title_photo;
    private String description_photo;

    public Photo(int id, int category, String source_photo, String title_photo,
                 String description_photo) {
        this.id = id;
        this.category = category;
        this.source_photo = source_photo;
        this.title_photo = title_photo;
        this.description_photo = description_photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getSource_photo() {
        return source_photo;
    }

    public void setSource_photo(String source_photo) {
        this.source_photo = source_photo;
    }

    public String getTitle_photo() {
        return title_photo;
    }

    public void setTitle_photo(String title_photo) {
        this.title_photo = title_photo;
    }

    public String getDescription_photo() {
        return description_photo;
    }

    public void setDescription_photo(String description_photo) {
        this.description_photo = description_photo;
    }

}
