//package warmup;
//
//import java.util.Arrays;
//
//public class Main {
//    private static String dataOrdered(int R, int C, int[][] a) {
//        String string = Arrays.deepToString(a).replaceAll("],", " ");
//        string.replaceAll("[,", " ");
//
//        return string;
//    }
//
//    public static void main(String[] args) {
//        int[][]a =
//                {
//                        {  1,  2,  3 },
//                        {  5,  6,  7 },
//                        {  9, 10, 11 },
//                        { 13, 14, 15 },
//                        { 17, 18, 19 },
//                        { 21, 22, 23 },
//                };
//
//        System.out.println(dataOrdered(a.length, a[0].length, a));
//    }
//}
