package HWK5;

import java.util.Arrays;
import java.util.Random;
public class MI3C_HWK5_412630153_01 {
    public static void main(String[] args) {
        Random r = new Random(111);
        int num = 100;
        int[] a = new int[num], b = new int[num];
        int[] c = new int[num], d = new int[num];
        for(int i = 0 ; i < num ; i++){
            a[i] = 50 + r.nextInt(200-50+1);
            b[i] = 50 + r.nextInt(200-50+1);
        }
        Thread t1 = new Thread(
                () -> {
                    if (a.length != b.length) {
                        return;
                    }
                    for(int i = 0; i < a.length ; i++){
                        c[i] = a[i] + b[i];
                    }
                });
        Thread t2 = new Thread(
                () -> {
                    if (a.length != b.length) {
                        return;
                    }
                    for(int i = 0; i < a.length ; i++){
                        d[i] = a[i] - b[i];
                    }
                });
        t1.start(); t2.start();
        try{
            t1.join(); t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("c[]="+Arrays.toString(c));
        System.out.println("d[]="+Arrays.toString(d));
    }
}
