package com.derekdileo;

import java.util.LinkedList;

public class TodoList {
    // Used with lazy instantiation via getInstance()
    private static TodoList firstInstance = null;

    // List to hold todoItems
    private LinkedList<TodoItem> todoList;

    //
    static boolean firstThread = true;

    // private constructor (only getInstance() can instantiate)
    private TodoList() {
        todoList = new LinkedList<>();
    }

    public static TodoList getInstance() {
        // Lazy instantiation - only instantiated if needed
        if(firstInstance == null) {
            synchronized (TodoList.class) {
                if(firstInstance == null) {
                    firstInstance = new TodoList();
                }
            }
        }
        return firstInstance;
    }

    public LinkedList<TodoItem> getTodoList() {
        return firstInstance.todoList;
    }

    public void deleteFirstTodoItem() {
        firstInstance.todoList.remove(0);
    }

    public void deleteLastTodoItem() {
        int index = firstInstance.todoList.size() - 1;
        firstInstance.todoList.remove(index);
    }

    public void deleteTodoItem(int index) {
        firstInstance.todoList.remove(index);
    }

    public void addTodoItem(String description) {
        TodoItem todoItem = new TodoItem(description);
        firstInstance.todoList.add(todoItem);
    }

    public void showTodoList() {
        for(TodoItem item : firstInstance.todoList) {
            System.out.println(item.toString());
        }
    }

}
