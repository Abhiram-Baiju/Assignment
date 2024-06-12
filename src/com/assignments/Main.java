package com.assignments;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner n= new Scanner(System.in);
        int condition;
        System.out.println("Odd or Even");
        do{
            System.out.println("Enter the number ");
            int num=n.nextInt();
            if(num%2==0){
                System.out.println(num+" is even");
            }
            else{
                System.out.println(num+" is odd");
            }
            System.out.println("do you want to continue\n1-yes\n2-no");
            condition=n.nextInt();
        }while (condition==1);
        System.out.println("program terminated");
    }
}