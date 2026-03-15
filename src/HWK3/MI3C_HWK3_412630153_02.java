package HWK3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
[要求]:

       (a) 將這四張圖片事先載入一個ImageIcon陣列中備用，可寫在建構式中的initComponent();之前。

       (b) 一開始畫面保持空白，按下[Load]會載入pic0.jpg，之後再進行[>]或[<]。
 */
class ImageViewer extends JFrame implements ActionListener {
    String path = "C:/Data/pic%02d.jpg"; // %02d 表示兩位數，不足補0
    ImageIcon[] imageIcons = new ImageIcon[4];
    JLabel l1 = new JLabel("ImageViewer"), l2 = new JLabel("");
    Font myFont = new Font("Times New Roman", Font.PLAIN, 16);
    JButton b1 = new JButton("<"), b2 = new JButton("Load"), b3 = new JButton(">");
    JScrollPane sp = new JScrollPane();
    int no = 0;
    ImageViewer(){
        setImageIcons(4);
        Container cp = super.getContentPane();
        cp.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1.setFont(myFont);
        JComponent[] cs = {l1, sp, b1, b2, b3};
        sp.getViewport().add(l2);
        int[] x = {110, 60, 40, 105, 220}, y = {5, 40, 240, 240, 240}, width = {100, 190, 45, 90, 45}, height = {30, 190, 30, 30, 30};
        for(int i = 0 ; i < cs.length ; i++){
            cs[i].setBounds(x[i], y[i], width[i], height[i]);
            cp.add(cs[i]);
        }
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void setImageIcons(int picNo){
        for(int i = 0 ; i < picNo ; i++){
            imageIcons[i] = new ImageIcon(String.format(path, i + 1));
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            no = (no - 1 + imageIcons.length) % imageIcons.length;
            l2.setIcon(imageIcons[no]);
        }if(e.getSource() == b2){
            no = 0;
            l2.setIcon(imageIcons[0]);
        }if(e.getSource() == b3){
            no = (no + 1) % imageIcons.length;
            l2.setIcon(imageIcons[no]);
        }
    }
}

public class MI3C_HWK3_412630153_02 {
    public static void main(String[] args){
        ImageViewer iv = new ImageViewer();
        iv.setSize(320, 320);
        iv.setVisible(true);
    }
}
