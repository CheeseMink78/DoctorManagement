package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static int getInt(String name) {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            try {
                System.out.print("Enter " + name + ":");
                input = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter integer!");
                sc.next();
            }
        }
        return input;
    }

    public static String getString(String name) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print("Enter " + name + ":");
            s = sc.nextLine();
        }
        return s;
    }
    public static char getChar(String name) {
        Scanner sc=new Scanner(System.in);
        String s=null;
        char ch='\0';
        while (s==null || s.isEmpty()) {
            System.out.print("Enter " + name + ":");
            s= sc.nextLine();
            ch=s.charAt(0);
            if(s.length()>1) {
                System.out.println("Please enter char!");
                continue;
            }
        }
        return ch;
    }
    public static char getOperator(String name) {
        Scanner sc=new Scanner(System.in);
        String s=null;
        char ch='\0';
        while (s==null || s.isEmpty() || s.length()>1) {
            System.out.print("Enter " + name + ":");
            s= sc.nextLine();
            ch=s.charAt(0);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '=') break;
            else {
                System.out.println("Please enter operator!");
                s=null;
            }
        }
        return ch;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static double getDouble(String name) {
        Scanner sc = new Scanner(System.in);
        double input;
        while (true) {
            try {
                System.out.print("Enter " + name + ":");
                input = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter number!");
                sc.next();
            }
        }
        return input;
    }

}
