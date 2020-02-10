import java.io.InputStream;
import java.util.Scanner;

public class twonumber {
    public static void main(String[] args){
        //int a,b;
       // int c=a+b;
        InputStream in = System.in;
        Scanner scanner = new Scanner(in);
        System.out.println("Enter first number:");
        int a= scanner.nextInt();
        System.out.println("Enter second number:");

        int b= scanner.nextInt();
        int c=a+b;

        System.out.printf("Sum of two numbers is:%d\n",c);

    }
}
