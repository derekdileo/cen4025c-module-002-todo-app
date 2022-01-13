package com.derekdileo;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    // Used with lazy instantiation via getInstance()
    private static TodoList firstInstance = null;

    // List to hold todoItems
    private ArrayList<TodoItem> todoList;

    // private constructor (only getInstance() can instantiate)
    private TodoList() {
        todoList = new ArrayList<>();
    }

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

    public ArrayList<TodoItem> getTodoList() {
        return firstInstance.todoList;
    }

    public boolean listEmpty() {
        if (firstInstance.todoList.isEmpty()) {
            System.out.println("Error: TDL is empty!");
            return true;
        } else {
            return false;
        }
    }

    public boolean addTodoItem(String description) {
        // Validate user input
        if (description != null && !description.isBlank()) {
            TodoItem todoItem = new TodoItem(description);
            firstInstance.todoList.add(todoItem);
            return true;
        } else {
            System.out.println("Invalid entry. Please try again.");
            return false;
        }
    }

    public void deleteFirstTodoItem() {
        if (!listEmpty()) {
            System.out.println("Deleting item: " + firstInstance.todoList.get(0).toString());
            firstInstance.todoList.remove(0);
        } else {
            return;
        }
    }

    public void deleteLastTodoItem() {
        if (!listEmpty()) {
            int index = firstInstance.todoList.size() - 1;
            System.out.println("Deleting item: " + firstInstance.todoList.get(index).toString());
            firstInstance.todoList.remove(index);
        } else {
            return;
        }
    }

    public void deleteTodoItemAtIndex(int index) {
        if (!listEmpty()) {
            if ((index - 1) <= firstInstance.todoList.size()) {
                System.out.println("Deleting item: " + firstInstance.todoList.get(index).toString());
                firstInstance.todoList.remove(index - 1);
            } else {
                System.out.println("Error. No item at that location!");
                return;
            }
        } else {
            return;
        }
    }

    public void showTodoList() {
        int counter = 1;
        if (firstInstance.todoList.isEmpty()) {
            System.out.println("\nThe TDL is currently empty. Please add some items and get to work!\n");
        } else {
            System.out.println(" - - TO DO LIST - - ");
            for (TodoItem item : firstInstance.todoList) {
                System.out.println("Item " + counter++ + "): " + item.toString());
            }
        }
    }

    public void toDoMenu(int choice) {
        while (choice != 6) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1 - View Current Todo List");
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
                    System.out.println("Exiting TDL. Goodbye");
                    return;
                }

            } else {
                System.out.println("Invalid entry! Reloading options...");
            }

        }

    }

    public static void performOperationsUsingSwitch(int choice, Scanner scanner) {
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
                    System.out.print("\nPlease type in the number of the Todo item to be deleted.");
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
