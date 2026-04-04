package HWK5;

import javax.swing.* ; // for JFrame
import java.awt.* ; // for Graphics
class CounterFrame extends JFrame {
    double delayInSec;
    int no = 0 ;
    int num = 100;
    CounterFrame(int x, int y, int w, int h, double delay) {
        setBounds(x,y,w,h) ; setVisible(true) ; delayInSec = delay ;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void count() {
        repaint(); //會呼叫 paint();
        for (int i = 0 ; i<num ; i++) {
            no = i; repaint(); // 在視窗印製整數 i, repaint()會間接呼叫 paint();
            delay(delayInSec) ; // 延遲 delayInSec 秒
        }
    }
    public void paint(Graphics g) { //在視窗畫面中央繪製數字
        int w = getWidth(), h = getHeight() ;
        g.clearRect(0,0, w,h) ; //清除畫面
        g.drawString(Integer.toString(no), w/2, h/2) ; // 在畫面中央印出數字
    }
    void delay(double delayInSec){
        try{
            Thread.sleep((int)(1000 * delayInSec));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
public class MI3C_HWK5_412630153_04 {
    public static void main(String[] args) {
        CounterFrame cf1 = new CounterFrame(0, 0, 50,100, 0.2) ; //x, y, w, h, delay
        CounterFrame cf2 = new CounterFrame(121, 0, 50,100, 0.5) ;
        Thread t1 = new Thread(()->{
            cf1.count();
        });
        Thread t2 = new Thread(()->{
            cf2.count();
        });
        t1.start(); t2.start();
        try {
            t1.join(); t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
