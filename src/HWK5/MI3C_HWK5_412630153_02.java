package HWK5;

import java.util.Arrays;

public class MI3C_HWK5_412630153_02 {
    public static void main(String[] args){
        int[] a = new int[100];
        for (int i = 0 ; i < a.length ; i++){
            a[i] = -100 + (int)(Math.random() * 101);
        }
        double sec = 0.2;
        Thread t1 = new Thread(()->{
            for (int i = 0 ; i < a.length ; i++){
                System.out.println("Hello");
                delay(sec);
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0 ; i < a.length ; i++){
                a[i] = Math.abs(a[i]);
                System.out.println(a[i]);
                delay(sec);
            }
        });
        t1.start(); t2.start();
        try{
            t1.join(); t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void delay(double sec){
        try {
            Thread.sleep((int)(sec * 1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
