package HWK5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Counter extends JFrame{
    JLabel l1 = new JLabel("Counter"), l2 = new JLabel("Start"), l3 = new JLabel("End"), l4 = new JLabel("Gap");
    JTextField tf1 = new JTextField(), tf2 = new JTextField(), tf3 = new JTextField(), tf4 = new JTextField();
    JButton b1 = new JButton("Execute");
    Thread t1 = new Thread();
    Counter(){
        Container cp = super.getContentPane();
        cp.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JComponent[] cs = {l1, l2, l3, l4, tf1, tf2, tf3, tf4, b1};
        int[] x = {230, 100, 100, 100, 140, 140, 140, 280, 280}, y = {15, 60, 110, 160, 60, 110, 160, 110, 160}, width = {50, 50, 50, 50, 50, 50, 50, 100, 100}, height = {30};
        for (int i = 0 ; i < cs.length ; i++){
            cs[i].setBounds(x[i], y[i], width[i], height[0]);
            cp.add(cs[i]);
        }
        b1.addActionListener(
                c -> {
                    try{
                        if(t1 != null && t1.isAlive()){
                            return;
                        }
                        int lowerBound = Integer.parseInt(tf1.getText());
                        int upperBound = Integer.parseInt(tf2.getText());
                        if(lowerBound > upperBound){
                            throw new RuntimeException("下限不得大於上限");
                        }
                        int gap = Integer.parseInt(tf3.getText());
                        if(gap < 1 || gap > upperBound - lowerBound){
                            throw new RuntimeException("間距不得小於1 或 大於區間");
                        }
                        t1 = new Thread(
                                () -> {
                                    for (int i = lowerBound; i <= upperBound ; i += gap){
                                    tf4.setText(String.valueOf(i));
                                    delay();
                                }
                        });
                        t1.start();
                    }catch (NumberFormatException nfe){
                        System.out.println("欄位不得為空或非數字");
                    }
        });
        tf4.setEditable(false);
    }
    static void delay(){
        try{
            double sec = 1;
            Thread.sleep((int) (sec * 1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class MI3C_HWK5_412630153_03 {
    public static void main(String[] args) {
        Counter c = new Counter();
        c.setSize(500, 250);
        c.setVisible(true);
    }
}