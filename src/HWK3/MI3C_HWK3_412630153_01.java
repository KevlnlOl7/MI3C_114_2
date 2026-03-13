package HWK3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OrderMenu extends JFrame implements ActionListener {
    JLabel l1 = new JLabel("點餐系統"), l2 = new JLabel("總金額："), l3 = new JLabel("(主餐一率 99 元)");
    Font myFont = new Font("DFKai-SB", Font.PLAIN, 16);
    JTextField tf = new JTextField();
    JRadioButton rb1 = new JRadioButton("Combo A (NT$50)"), rb2 = new JRadioButton("Combo B (NT$70)"), rb3 = new JRadioButton("Combo C (NT$80)");
    JCheckBox cb1 = new JCheckBox("Large Drink (+ NT$5)"), cb2 = new JCheckBox("Large Fries (+ NT$5)");
    ButtonGroup g = new ButtonGroup();
    OrderMenu(){
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = super.getContentPane();
        cp.setLayout(null);
        JComponent[] cs = {l1, l2, l3, tf, rb1, rb2, rb3, cb1, cb2};
        l1.setFont(myFont);
        g.add(rb1); g.add(rb2); g.add(rb3);
        int[] x = {150, 40, 270, 100, 50, 50, 50, 200, 200}, y = {30, 60, 60, 60, 110, 160, 210, 110, 160}, width = {100, 50, 100, 150, 150, 150, 150, 150, 150}, height = {30, 30, 30, 30, 40, 40, 40, 40, 40};
        for (int i = 0 ; i < cs.length ; i++){
            cs[i].setBounds(x[i], y[i], width[i], height[i]);
            cp.add(cs[i]);
        }
    }
    public void actionPerformed(ActionEvent e){

    }
}
public class MI3C_HWK3_412630153_01 {
    public static void main(String[] args){
        OrderMenu om = new OrderMenu();
        om.setSize(400,400);
        om.setVisible(true);
    }
}
