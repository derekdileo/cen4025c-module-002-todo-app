package com.derekdileo;

import java.util.Scanner;

public class Main {

    public static TodoList list;

    public static void main(String[] args) {

        // Instantiate TodoList Singleton and print Instance ID
        list = TodoList.getInstance();
        System.out.println("Instance ID: " + System.identityHashCode(list));

        // Welcome user
        WelcomeToApp welcomeToApp = new WelcomeToApp();

        // Enter looped menu program
        list.toDoMenu(0);

    }

}
