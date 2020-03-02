package lesson12_warmup;

import java.util.Scanner;

public class ConsoleCalculator {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter str:");
        String str=scanner.nextLine();

        calculate(str);
    }

    public static void calculate(String str) {
       int result=0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i)=='+') {
                result = Integer.parseInt(str.substring(0,i))+Integer.parseInt(str.substring(i+1,str.length()));
            }
            else if(str.charAt(i)=='-'){
                result =  Integer.parseInt(str.substring(0,i))-Integer.parseInt(str.substring(i+1,str.length()));
            }
            else if (str.charAt(i) == '*'){
                result =  Integer.parseInt(str.substring(0,i))*Integer.parseInt(str.substring(i+1,str.length()));

            }
            else if (str.charAt(i)=='/'){
                if (Integer.parseInt(str.substring(i+1,str.length()))==0){
                    System.out.printf("divide by zero.%s",str);
                }
                else result =  Integer.parseInt(str.substring(0,i))/Integer.parseInt(str.substring(i+1,str.length()));
            }
        }
        System.out.println(result);
    }
}

