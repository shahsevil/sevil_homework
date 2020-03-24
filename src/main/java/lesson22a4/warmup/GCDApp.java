package lesson22a4.warmup;

import java.util.Scanner;

public class GCDApp {

  static int gcd(int num1, int num2) {
        if (num2 != 0) { return gcd(num2,num1%num2);
        } else return num1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      System.out.println("First num:");
        int num1 = scanner.nextInt();
      System.out.println("Second num:");
        int num2 = scanner.nextInt();
        int res = gcd(num1, num2);
        System.out.printf("Gcd=%d", res);
    }
}
