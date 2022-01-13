package com.derekdileo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Instantiate Scanner to monitor CLI input from user
        Scanner scanner = new Scanner(System.in);

        // Instantiate TodoList Singleton and print Instance ID
        TodoList list = TodoList.getInstance();
        System.out.println("Instance ID: " + System.identityHashCode(list));

        // Welcome user
        WelcomeToApp welcomeToApp = new WelcomeToApp();



        System.out.println("To ");







    }
}
