package HWK2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrameCal extends JFrame implements ActionListener{
    JTextField tf1 = new JTextField(), tf2 = new JTextField(), tf3 = new JTextField(), tf4 = new JTextField(), tf5 = new JTextField("錯誤提示");
    JButton b1 = new JButton("=");
    JLabel l1 = new JLabel("簡易計算機");
    MyFrameCal(){
        Container cp = super.getContentPane();
        JComponent[] cs = {l1, tf1, tf2, tf3, b1, tf4, tf5};
        super.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int[] x = {175, 10, 120, 155, 265, 320, 130}, y = {50, 85, 85, 85, 85, 85, 120}, width = {100, 100, 25, 100, 45, 100, 160}, height = {25, 25, 25, 25, 25, 25, 25};
        for (int i = 0; i < cs.length; i++){
            cs[i].setBounds(x[i], y[i], width[i], height[i]);
            cp.add(cs[i]);
        }
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        try{
            boolean vaild = true;
            double rlt = 0;
            double operand1 = Double.parseDouble(tf1.getText().trim()), operand2 = Double.parseDouble(tf3.getText().trim());
            switch (tf2.getText().trim()){
                case "+":
                    rlt = operand1 + operand2;
                    break;
                case "-":
                    rlt = operand1 - operand2;
                    break;
                case "*":
                    rlt = operand1 * operand2;
                    break;
                case "/":
                    if(operand2 == 0){
                        tf4.setText("Error!");
                        tf5.setText("除數不得為零");
                        return;
                    }
                    rlt = operand1 / operand2;
                    break;
                default:
                    tf5.setText("請輸入有效的運算子(+, -, *, /)");
                    System.out.println("請輸入有效的運算子(+, -, *, /)");
                    vaild = false;
            }
            if(vaild){
                tf4.setText(rlt+"");
            }
        } catch (NumberFormatException ex){
            tf5.setText("請輸入有效的阿拉伯數字");
            System.out.println("請輸入有效的阿拉伯數字");
        }

    }
}
public class MI3C_HWK2_412630153_02 {
    public static void main(String[] args){
        MyFrameCal mfc = new MyFrameCal();
        mfc.setSize(450, 250);
        mfc.setVisible(true);
    }
}
