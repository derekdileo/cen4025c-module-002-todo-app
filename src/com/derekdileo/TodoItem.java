package com.derekdileo;

public class TodoItem {

//  Luxury fields
//  private String briefDescription;
//  private short priority;
    private String description;

    public TodoItem(String briefDescription) {
        this.description = briefDescription;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "  " + description + "\n";
    }

}
