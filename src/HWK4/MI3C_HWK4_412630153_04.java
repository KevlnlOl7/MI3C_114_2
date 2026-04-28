package HWK4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class RunnableX implements Runnable{
    ChatRoom cr;
    RunnableX(ChatRoom cr){
        this.cr = cr;
    }
    public void run(){
        delay(Math.random() * 1.5 + 0.5);
        cr.chatBot();
    }
    void delay(double sec){
        try{
            Thread.sleep((int)(sec * 1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ChatRoom extends JFrame implements ActionListener {
    JLabel l = new JLabel("Chatroom: Tamsui Never Sleep");
    JTextArea ta = new JTextArea();
    JScrollPane sp = new JScrollPane(ta);
    JTextField tf1 = new JTextField("Name"), tf2 = new JTextField("Message");
    Font clubFont = new Font("Script MT Bold", Font.ITALIC, 24);
    ChatRoom(){
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = super.getContentPane();
        cp.setLayout(null);
        l.setFont(clubFont);
        JComponent[] cs = {l, sp, tf1, tf2};
        int[] x = {85, 30, 30, 90}, y = {30, 70, 250, 250}, width = {400, 425, 50, 375}, height = {30, 170, 30, 30};
        for (int i = 0 ; i < cs.length; i++){
            cs[i].setBounds(x[i], y[i], width[i], height[i]);
            cp.add(cs[i]);
        }
        ta.setEditable(false);
        tf1.addActionListener(this);
        tf2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(tf1.getText().isEmpty() || tf2.getText().isEmpty()){
            ta.append("姓名欄或留言欄不得為空\n");
            return;
        }
        if(e.getSource() == tf2){
            String s = tf1.getText().trim() + ": " + tf2.getText().trim()+"\n";
            ta.append(s);
            tf2.setText("");
            Thread t = new Thread(new RunnableX(this));
            t.start();
        }
    }
    public void chatBot(){
        String name = "Mary";
        String[] msgs = {"嗯嗯", "哈哈真的", "那確實", "我也這麼覺得", "我媽叫我吃飯了", "先洗澡等等回你", "先睡啦"};
        int index = (int)(Math.random() * msgs.length);
        ta.append(name +": "+ msgs[index] + "\n");
    }
}
public class MI3C_HWK4_412630153_04 {
    public static void main(String[] args) {
        ChatRoom cr = new ChatRoom();
        cr.setSize(500,350);
        cr.setVisible(true);
    }
}
