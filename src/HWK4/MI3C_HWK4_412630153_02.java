package HWK4;
class PrintRunnable implements Runnable{
    int[] a; String status;
    PrintRunnable(){
        status = "Hello";
    }
    PrintRunnable(int[] a){
        this.a = a;
        status = "Array";
    }
    public void run(){
        switch (status){
            case "Hello":
                for (int i = 0 ; i < 100 ; i++){
                    System.out.println("Hello");
                    delay(0.2);
                }
                break;
            case "Array":
                for (int i = 0 ; i < a.length; i++){
                    a[i] = Math.abs(a[i]);
                    System.out.println(a[i]);
                    delay(0.2);
                }
                break;
        }
    }
    public void delay(double sec){
        try{
            Thread.sleep((int) (sec * 1000));
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
public class MI3C_HWK4_412630153_02 {
    public static void main(String[] args) {
        int[] a = new int [100];
        for (int i = 0 ; i < a.length ; i++){
            a[i] = (int)(Math.random() * 101);
        }
        Thread t1 = new Thread(new PrintRunnable());
        Thread t2 = new Thread(new PrintRunnable(a));
        t1.start(); t2.start();

    }
}
