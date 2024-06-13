package com.assignments;
import java.util.Scanner;
class Calc{
    int add(int a,int b){
        int sum=a+b;
        return sum;

    }

}
public class calc {
    public static void main(String[] args) {
        Scanner n=new Scanner(System.in);
        System.out.println("Enter two numbers");
        int a,b;
        a= n.nextInt();
        b= n.nextInt();
        Calc c=new Calc();
        int s=c.add(a,b);
        System.out.println(s);

    }
}
