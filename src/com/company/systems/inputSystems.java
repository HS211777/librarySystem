package com.company.systems;

import java.util.Scanner;

public class inputSystems {
    public static int inputInt(){
        Scanner input = new Scanner(System.in);
        int out = 0;
        boolean valid = false;
        while(!valid){
            try{
                out = input.nextInt();
                valid = true;
            }
            catch (Exception e){
                System.out.println("Error: "+e);
            }
        }
        return out;
    }

    public static String inputString(){
        Scanner input = new Scanner(System.in);
        String out = "";
        boolean valid = false;
        while(!valid){
            try{
                out = input.next();
                valid = true;
            }
            catch (Exception e){
                System.out.println("Error: "+e);
            }
        }
        return out;
    }
}
