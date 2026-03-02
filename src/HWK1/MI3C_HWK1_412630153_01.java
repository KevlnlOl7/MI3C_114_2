package HWK1;

import javax.swing.*;
import java.awt.*;

class Frame9 extends JFrame{
    JButton[] btns = new JButton[9];
    Frame9(){}
    Frame9(int startNo, int x, int y){
        Container cp = getContentPane();
        cp.setLayout(null);
        this.setLocation(x, y);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int w = 70, h = 70, row = 3, col = 3;
        for (int i = 0; i < btns.length; i++){
            String s = String.format("%s",i+startNo);
            btns[i] = new JButton(s);
            if(i < 9){
                btns[i].setBounds(w * (i % col), h * (i / row), w, h);
                cp.add(btns[i]);
            }else{
                throw new IllegalArgumentException("total plots cannot be larger than 9.");
            }
        }
    }
}
public class MI3C_HWK1_412630153_01 {
    public static void main(String[] args){
        int plotsSize = 70; // 九宮格每格大小，因為三位數會顯示...所以放大成70
        int col = 3; // 需要幾欄
        int gapW = 12, gapH = 35; // 因像素包含導航欄，所以要保留空間，確保空間符合要求
        int w = plotsSize * col + gapW, h = plotsSize * col + gapH, x1 = 0, y1 = 0, x2 = w - 10, y2 = 0;
        Frame9 f1 = new Frame9(1, x1, y1);
        f1.setSize(w, h);
        f1.setVisible(true);
        Frame9 f2 = new Frame9(15, x2, y2);
        f2.setSize(w, h);
        f2.setVisible(true);
    }
}
