package HWK2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControlFrame extends JFrame implements ActionListener {
    JButton b1 = new JButton("Inc"), b2 = new JButton("0"), b3 = new JButton("Dec");
    DisplayFrame df = new DisplayFrame();
    ControlFrame(){
        Container cp = super.getContentPane();
        cp.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JComponent[] cs = {b1, b2, b3};
        int[] x = {30, 30, 30}, y = {30, 70, 110};
        int width = 80, height = 30;
        for (int i = 0 ; i < cs.length ; i++){
            cs[i].setBounds(x[i], y[i], width, height);
            cp.add(cs[i]);
        }
        setDisplay(155,200);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void setDisplay(int width, int height){
        df.setSize(width, height);
        df.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        try{
            int num = Integer.parseInt(df.tf.getText());
            if(e.getSource() == b1){
                num = num + 1;
                System.out.println(num);
                df.tf.setText(num+"");
            }else if (e.getSource() == b2){
                df.tf.setText(0+"");
                System.out.println(0);
            }else if (e.getSource() == b3){
                num = num - 1;
                System.out.println(num);
                df.tf.setText(num+"");
            }else{
                System.out.println("Undefined operation");
            }
        }catch (NumberFormatException ex){
            df.tf.setText("Please input number ^_^");
            System.out.println("請輸入阿拉伯數字");
        }

    }
}
class DisplayFrame extends JFrame{
    JTextField tf = new JTextField("0");
    DisplayFrame(){
        Container cp = super.getContentPane();
        cp.setLayout(null);
        super.setLocation(160,0);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tf.setBounds(20,60,100,30);
        cp.add(tf);
    }
}
public class MI3C_HWK2_412630153_03 {
    public static void main(String[] args) {
        ControlFrame cf = new ControlFrame();
        cf.setSize(155, 200);
        cf.setVisible(true);
    }
}
