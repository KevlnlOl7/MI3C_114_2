package HWK5;

import java.util.Arrays;

interface Combine {
    int compute(int a, int b);
}

public class MI3C_HWK5_412630153_05 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2};
        int[] b = {22, 33, 44, 55};
        int[] c = new int[a.length];
        combine(a, b, c, (x, y) -> x + y);
        System.out.println("加法運算：" + Arrays.toString(c));
        combine(a, b, c, (x, y) -> (int)(x * x + Math.sqrt(y)));
        System.out.println("複雜運算：" + Arrays.toString(c));
    }
    public static void combine(int[] a, int[] b, int[] c, Combine cb){
        if(a.length != b.length){
            System.out.println("陣列 a 以及 b 的長度不一");
            return;
        }
        for (int i = 0 ; i < a.length ; i++){
            c[i] = cb.compute(a[i], b[i]);
        }
    }
}