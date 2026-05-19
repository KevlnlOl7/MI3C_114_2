package MI3C_HWK8_412630153_02;

import java.io.*;
import java.net.*;
import javax.swing.* ;
public class Receiver extends Thread {
    boolean running = true ;
    int port = 4444 ;
    JTextArea msgBoard = null ;
    
    public Receiver() { }
    public Receiver(int p, JTextArea mb) { port = p ; msgBoard = mb ;}
    @Override
    public void run() {
      Socket client = null ;        
      try {
        // System.out.println("My Host Name: " + inetAddress.getHostName());
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server Init ....\n");
        while (running) {
            client = ss.accept();
            System.out.println("accept a client:" + client);
            // === 讀取並處理client傳來的訊息
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String msg = dis.readUTF();
            if (msgBoard!=null) msgBoard.append(msg);
            String res = "[Receive] OK"; // default response
            new DataOutputStream(client.getOutputStream()).writeUTF(res);
            client.close();
        }
      } catch (Exception e) {
          System.out.println("Recive Error: client="+client) ;
          e.printStackTrace();           
      }
    }
    public void terminate() {
        running = false ;
    }
    public static String getMyIP() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            // System.out.println("My IP Address: " + inetAddress.getHostAddress());
            return inetAddress.getHostAddress().toString() ;
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return "getMyIP(): Fail" ;        
    }
    
}

