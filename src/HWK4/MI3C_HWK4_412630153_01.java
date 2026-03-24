package HWK4;

import java.util.Arrays;
import java.util.Random;
class OprThread extends Thread{
    int[] a, b, rlt; char opr;
    OprThread(int[] a, int[] b, int[] rlt, char opr){
        this.a = a; this.b = b; this.rlt = rlt; this.opr = opr;
    }
    public void run(){
        if(a.length != b.length){
            return;
        }
        switch (opr){
            case '+':
                for(int i = 0; i < a.length ; i++){
                    rlt[i] = a[i] + b[i];
                }
                break;
            case '-':
                for(int i = 0; i < a.length ; i++){
                    rlt[i] = a[i] - b[i];
                }
                break;
        }
    }
}

public class MI3C_HWK4_412630153_01 {
    public static void main(String[] args) {
        Random r = new Random(111);
        int num = 100;
        int[] a = new int[num], b = new int[num];
        int[] c = new int[num], d = new int[num];
        for(int i = 0 ; i < num ; i++){
            a[i] = 50 + r.nextInt(200-50+1);
            b[i] = 50 + r.nextInt(200-50+1);
        }
        OprThread ot1 = new OprThread(a, b, c,'+');
        OprThread ot2 = new OprThread(a, b, d,'-');
        ot1.start(); ot2.start();
        try{
            ot1.join(); ot2.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("c[]="+Arrays.toString(c));
        System.out.println("d[]="+Arrays.toString(d));
    }
}
