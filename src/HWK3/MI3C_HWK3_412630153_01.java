package HWK3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OrderMenu extends JFrame implements ActionListener {
    JLabel l1 = new JLabel("點餐系統"), l2 = new JLabel("總金額："), l3 = new JLabel("(主餐一率 99 元)");
    Font myFont = new Font("DFKai-SB", Font.PLAIN, 16);
    JTextField tf = new JTextField();
    OrderMenu(){
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = super.getContentPane();
        cp.setLayout(null);
        JComponent[] cs = {l1, l2, l3, tf};
        l1.setFont(myFont);
        int[] x = {150, 40, 270, 100}, y = {30, 60, 60, 60}, width = {100, 50, 100, 150}, height = {30, 30, 30, 30};
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
