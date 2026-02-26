package Algo;

import java.util.Arrays;
import java.util.Random;

public class Test_0226 {
    public static void main(String[] args){
        Random r = new Random(111);
        int n = 20;
        int[] x = new int[n], y = new int[n];
        for (int i = 1; i < n ; i++){
            x[i] = r.nextInt(101); y[i] = r.nextInt(101);
        }
        System.out.printf("(%d, %d)\n", x[0], y[0]);
        System.out.printf("(%d, %d)\n", x[n-1], y[n-1]);

        for(int i = 0; i < n - 1; i++){
            for (int j = i + 1 ; j < n; j++){
                System.out.println(distance(x[i], y[i], x[j], y[j]));
            }
        }
    }
    static double distance(int x1, int y1, int x2, int y2){
        double x = x2 - x1;
        double y = y2 - y1;
        return Math.sqrt((x*x) + (y*y));
    }
}
