package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    static int x = 0;
    static int y = 0;


    public static void main(String[] args) {

        scanIn();
        System.out.println("x = " + x + "\n" + "y = " + y);

    }

    private static void scanIn(){
        String str = null;
        int in = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter the direction: ");
            try {
                str = scanner.nextLine();
                if(!(str.equalsIgnoreCase("north") || str.equalsIgnoreCase("south") || str.equalsIgnoreCase("west") || str.equalsIgnoreCase("east"))){
                    throw new NotDirectionException();
                }
            } catch (NotDirectionException e){
                System.out.println(e.toString());
                continue;
            }
            System.out.println("enter steps number: ");
            try {
                in = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println(e.toString());
                continue;
            }
            calculateCoordinates(str, in);
        } while (!str.equalsIgnoreCase("stop"));
    }

    private static void calculateCoordinates(String direction, int steps){
        DirEnum dirEnum = DirEnum.valueOf(direction.toUpperCase());
        switch (dirEnum){
            case NORTH:
                y += steps;
                break;
            case SOUTH:
                y -= steps;
                break;
            case WEST:
                x -= steps;
                break;
            case EAST:
                x += steps;
        }
    }
}

enum DirEnum{
    NORTH, SOUTH, WEST, EAST;
}

class NotDirectionException extends Exception {
    String info;
    NotDirectionException (){
        this.info = "there is no such direction";
    }
    NotDirectionException (String message){
        this.info = message;
    }

    @Override
    public String toString() {
        return info;
    }
}