package MI3C_HWK8_412630153_02;
import java.net.* ;
import java.io.* ;
import javax.swing.* ;
public class Sender {
    JTextArea msgBoard = null;
    Sender(JTextArea mb) {
        msgBoard = mb ;
    }
    public void send(String ip, int port, String msg)  {
       try {
          System.out.println(ip+" "+port+" "+ msg) ;
          Socket querySocket = new Socket(ip,port); 
          DataOutputStream dos = new DataOutputStream(querySocket.getOutputStream()) ;
          dos.writeUTF(msg) ; 
          
          DataInputStream dis = new DataInputStream(querySocket.getInputStream()) ;
          System.out.println(dis.readUTF()) ; 
          // === (3) 關閉相關資料流
          dos.close() ; dis.close() ; querySocket.close();
       } catch (Exception e) {
           msgBoard.append("Connection to:"+ip+":"+port+"("+msg+")"+" fail!");
           e.printStackTrace();
       }
    }
}
