package com.assignments;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Boolean check = true;
        int num1 = random.nextInt(10);
        while (check) {
                for (int i = 0; i <= 2; i++) {
                   // System.out.println(num1);
                    System.out.println("Type your number here b/w 0 to 10...");
                    int num2 = scanner.nextInt();
                    if(num1 != num2){
                        System.out.println("Sorry! you are wrong ");
                    } else{
                        System.out.println("Wow! Your guess is awesome");
                        break;
                    }
                }
            System.out.println("Hey! Do you want play again?, Type ' y ' if  you want to play again,Click any other key to exit.. ");
            Scanner input = new Scanner(System.in);
            String ans = input.nextLine();
                if(ans.equals("y")){
                System.out.println("Welcome back");
            }   else{
                System.out.println("Thank you");
                check = false;
            }
        }
            System.out.println("Hello")   
        }
}
