package com.maple.healthyfoods;

public class SingleItemModel {
    private String name, url, description,rating;

    public SingleItemModel(String rating,String name, String description, String url) {
        this.name = name; this.description = description;this.url = url;
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
