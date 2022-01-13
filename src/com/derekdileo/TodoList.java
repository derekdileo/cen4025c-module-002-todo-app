package com.derekdileo;

import java.util.ArrayList;
import java.util.Scanner;

// Most of the program logic happens here
public class TodoList {
    // Used with lazy instantiation via getInstance()
    private static TodoList firstInstance = null;

    // List to hold todoItems
    private ArrayList<TodoItem> todoList;

    // Constructor is private because TodoList is a Singleton
    // only getInstance() can instantiate
    private TodoList() {
        todoList = new ArrayList<>();
    }

    // TodoList is a Singleton Class uses getInstance and a private constructor
    public static TodoList getInstance() {
        // Lazy instantiation - only instantiated if needed
        if (firstInstance == null) {
            synchronized (TodoList.class) {
                if (firstInstance == null) {
                    firstInstance = new TodoList();
                }
            }
        }
        return firstInstance;
    }

    private ArrayList<TodoItem> getTodoList() {
        return firstInstance.todoList;
    }

    // Used in other methods as conditional
    private boolean listEmpty() {
        if (firstInstance.todoList.isEmpty()) {
            System.out.println("Error: TDL is empty!");
            return true;
        } else {
            return false;
        }
    }

    private void addTodoItem(String description) {
        // Validate user input
        if (description != null && !description.isBlank()) {
            TodoItem todoItem = new TodoItem(description);
            firstInstance.todoList.add(todoItem);
        } else {
            System.out.println("Invalid entry. Please try again.");
        }
    }

    private void deleteFirstTodoItem() {
        if (!listEmpty()) {
            System.out.println("Deleting item: " + firstInstance.todoList.get(0).toString());
            firstInstance.todoList.remove(0);
        } else {
            return;
        }
    }

    private void deleteLastTodoItem() {
        if (!listEmpty()) {
            int index = firstInstance.todoList.size() - 1;
            System.out.println("Deleting item: " + firstInstance.todoList.get(index).toString());
            firstInstance.todoList.remove(index);
        } else {
            return;
        }
    }

    private void deleteTodoItemAtIndex(int index) {
        if (!listEmpty()) {
            if ((index) <= firstInstance.todoList.size()) {
                System.out.println("Deleting item: " + firstInstance.todoList.get(index).toString());
                firstInstance.todoList.remove(index);
            } else {
                System.out.println("Error. No item at that location!");
                return;
            }
        } else {
            return;
        }
    }

    private void showTodoList() {
        int counter = 0;
        if (firstInstance.todoList.isEmpty()) {
            System.out.println("\nThe TDL is currently empty. Please add some items and get to work!");
        } else {
            System.out.println("\n - - TO DO LIST - - ");
            for (TodoItem item : firstInstance.todoList) {
                System.out.println("Item " + counter++ + "): " + item.toString());
            }
        }
    }

    // Method called from Main to run TDL App
    public void toDoMenu(int choice) {
        while (choice != 6) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n1 - View Current Todo List");
            System.out.println("2 - Add Todo Item ");
            System.out.println("3 - Remove First Todo Item");
            System.out.println("4 - Remove Last Todo Item");
            System.out.println("5 - Remove Particular Todo Item");
            System.out.println("6 - Exit");
            System.out.print("\nChoice: ");
            choice = scanner.nextInt();

            // Validate user input
            if (choice > 0 && choice <= 6) {

                if (choice != 6) {
                    performOperationsUsingSwitch(choice, scanner);

                } else {
                    System.out.println("\nExiting TDL. Goodbye");
                    return;
                }

            } else {
                System.out.println("Invalid entry! Reloading options...");
            }

        }

    }

    // Method which uses switch statement to handle user choices
    private static void performOperationsUsingSwitch(int choice, Scanner scanner) {
        if (firstInstance.getTodoList() != null) {
            switch (choice) {
                case 1:
                    firstInstance.showTodoList();
                    break;
                case 2:
                    System.out.print("\nPlease type in the Todo item to be added: ");
                    scanner.nextLine();
                    String item = scanner.nextLine();
                    firstInstance.addTodoItem(item);
                    break;
                case 3:
                    firstInstance.deleteFirstTodoItem();
                    break;
                case 4:
                    firstInstance.deleteLastTodoItem();
                    break;
                case 5:
                    System.out.print("\nPlease type in the number of the Todo item to be deleted: ");
                    int toDelete = scanner.nextInt();
                    firstInstance.deleteTodoItemAtIndex(toDelete);
                    break;
                default:
                    System.out.println
                            ("Invalid entry...How did you even get in here??");
                    break;
            }

        }

    }

}
