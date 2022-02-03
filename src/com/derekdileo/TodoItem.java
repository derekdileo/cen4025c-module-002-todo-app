package com.derekdileo;

public class TodoItem {
    // Instance variables (id is required for Hibernate / DB)
    private int id;
    private String description;

    // Default Constructor (needed to be persistent class for Hibernate) (POJO model)
    public TodoItem() {}
    public TodoItem(String description) {
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "  " + description;
    }

}
