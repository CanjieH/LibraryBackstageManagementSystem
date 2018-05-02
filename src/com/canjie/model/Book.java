package com.canjie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Book {
    private int id;
    private String name;
    private String category;
    private int price;
    private String descript;
    private static final List<Map<String, Object>> cateList = new ArrayList<>();

    public Book(){

    }

    public Book(int id, String name, String category, int price, String descript) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.descript = descript;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public static List<Map<String, Object>> getCateList() {
        return cateList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", descript='" + descript + '\'' +
                '}';
    }
}
