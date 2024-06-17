//programme to make a calculator using all the oop concepts
import java.util.Scanner;
public class reverloop {
    public static void main(String[] args) {
        System.out.println("programme to reverse a number");
        Scanner num=new Scanner(System.in);
        System.out.println("Enter a number to print it's reverse");
        int n=num.nextInt();
        int rev=0;
        for(int i=0;0<n;i++){
            int rem=n%10;
            rev=rev*10+rem;
            n=n/10;
        }
        System.out.println("Reverse"+rev);
    }

}
