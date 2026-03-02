package HWK1;

import javax.swing.*;
import java.awt.*;

class Frame9 extends JFrame{
    JButton[] btns = new JButton[9];
    Frame9(){
        Container cp = getContentPane();
        cp.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int x = 0, y = 0, w = 50, h = 50;
        btns[0] = new JButton("1");
        btns[0].setBounds(0,0,w,h);
        btns[1] = new JButton("2");
        btns[1].setBounds(50,0,w,h);
        btns[2] = new JButton("3");
        btns[2].setBounds(100,0,w,h);
        btns[3] = new JButton("4");
        btns[3].setBounds(0,50,w,h);
        btns[4] = new JButton("5");
        btns[4].setBounds(50,50,w,h);
        btns[5] = new JButton("6");
        btns[5].setBounds(100,50,w,h);
        btns[6] = new JButton("7");
        btns[6].setBounds(0,100,w,h);
        btns[7] = new JButton("8");
        btns[7].setBounds(50,100,w,h);
        btns[8] = new JButton("9");
        btns[8].setBounds(100,100,w,h);
        for(int i = 0; i < btns.length; i++){
            if(i < 3){

            }
            cp.add(btns[i]);
        }
    }
    Frame9(int startNo, int x, int y){
        Container cp = getContentPane();
        cp.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int w = 50, h = 50;
        btns[0] = new JButton("1");
        btns[0].setBounds(0,0,w,h);
        btns[1] = new JButton("2");
        btns[1].setBounds(50,0,w,h);
        btns[2] = new JButton("3");
        btns[2].setBounds(100,0,w,h);
        btns[3] = new JButton("4");
        btns[3].setBounds(0,50,w,h);
        btns[4] = new JButton("5");
        btns[4].setBounds(50,50,w,h);
        btns[5] = new JButton("6");
        btns[5].setBounds(100,50,w,h);
        btns[6] = new JButton("7");
        btns[6].setBounds(0,100,w,h);
        btns[7] = new JButton("8");
        btns[7].setBounds(50,100,w,h);
        btns[8] = new JButton("9");
        btns[8].setBounds(100,100,w,h);
        for(int i = 0; i < btns.length; i++){
            if(i < 3){

            }
            cp.add(btns[i]);
        }
    }
}
public class MI3C_HWK1_412630153_01 {
    public static void main(String[] args){
        int w = 162, h = 185, x1 = 0, y1 = 0, x2 = w * 2, y2 = 0;
        Frame9 f1 = new Frame9(1, x1, y1);
        f1.setSize(w, h);
        f1.setVisible(true);
        Frame9 f2 = new Frame9(15, x2, y2);
        f2.setSize(w,h);
        f2.setVisible(true);
    }
}
