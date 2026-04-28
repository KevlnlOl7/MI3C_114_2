package HWK4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ImageViewer extends JFrame implements ActionListener {
    String path = "C:/Data/pic%02d.jpg"; // %02d 表示兩位數，不足補0
    ImageIcon[] imageIcons = new ImageIcon[8];
    JLabel l1 = new JLabel("ImageViewer"), l2 = new JLabel(""), l3 = new JLabel("延遲 (sec)");
    Font myFont = new Font("Times New Roman", Font.PLAIN, 16);
    JTextField tf1 = new JTextField("");
    JButton b1 = new JButton("Start"), b2 = new JButton("Stop");
    JScrollPane sp = new JScrollPane();
    int index = 0;
    boolean isPaused = false;
    Thread t = new Thread(new RunnableXX());;
    ImageViewer(int noPics){
        setImageIcons(noPics);
        Container cp = super.getContentPane();
        cp.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1.setFont(myFont);
        JComponent[] cs = {l1, sp, l3, tf1, b1, b2};
        sp.getViewport().add(l2);
        int[] x = {140, 60, 60, 100, 150, 200}, y = {5, 40, 230, 240, 240, 240}, width = {100, 190, 30, 30, 45, 45}, height = {30, 190, 30, 15, 15, 15};
        double scale = 2;
        for(int i = 0 ; i < cs.length ; i++){
            cs[i].setBounds((int)(x[i] * scale), (int)(y[i] * scale), (int)(width[i] * scale), (int)(height[i] * scale));
            cp.add(cs[i]);
        }
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void setImageIcons(int picNo){
        for(int i = 0 ; i < picNo ; i++){
            imageIcons[i] = new ImageIcon(String.format(path, i + 1));
        }
    }
    class RunnableXX implements Runnable{
        public void run(){
            double s = Double.parseDouble(tf1.getText());
            while(true){
                if(!isPaused){
                    index = index % imageIcons.length;
                    l2.setIcon(imageIcons[index]);
                    index++;
                }
                delay(s);
            }
        }
        void delay(double sec){
            try{
                Thread.sleep((int)(sec * 1000));
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        try {
            double delaySec = Double.parseDouble(tf1.getText());
            if (delaySec <= 0) {
                System.out.println("Go to hell!");
            }
            if (e.getSource() == b1) {
                isPaused = false;
                if (!t.isAlive()) {
                    t.start();
                }

            } else if (e.getSource() == b2) {
                isPaused = true;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("請輸入阿拉伯數字 :D");

        }
    }
}

public class MI3C_HWK4_412630153_05 {
    public static void main(String[] args){
        ImageViewer iv = new ImageViewer(8);
        iv.setSize(640, 640);
        iv.setVisible(true);
    }
}
