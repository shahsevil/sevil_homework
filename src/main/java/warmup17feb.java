import java.util.Arrays;
import java.util.Random;

public class warmup17feb {

    public static void main(String[] args) {
        Random rand=new Random();

        int range = 'Z' - 'A' + 1;
        String s="";
        String co="";
        String vo="";
        for(int i=0;i<30;i++){
            char c = (char) (rand.nextInt(26) + 'a');
            s=s+c;
            if (c== 'a' || c == 'A' || c == 'e' || c == 'E' ||c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U'){
                co+=c;
            }
            else vo+=c;
        }
        System.out.printf("Our rand is:%s\n",s);
        System.out.printf("Consonants:%s\n",co);
        System.out.printf("Vowels:%s\n",vo);
    }
}
