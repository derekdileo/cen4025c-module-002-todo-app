package com.derekdileo;

public class TodoItem {
    // Instance variable(s)
    private String description;

    // Constructor
    public TodoItem(String description) {
        this.description = description;
    }

    // Getter
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "  " + description;
    }

}
