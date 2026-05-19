package HWK8;

import java.io.*;
import java.net.Socket;

public class MI3C_HWK8_412630153_01_Client {
    static final int PORT = 4444;
    static final String IP = "127.0.0.1";
    static String downloadDir = "C:/download/";
    static String fileName = "dog_1.jpg";
    static String fileName2 = "dog_2.jpg";
    static int bufferSize = 8192;
    public static void main(String[] args) {
        getFile(fileName);
        putFile(fileName2, (int) new File(downloadDir+fileName2).length(), new byte[bufferSize]);
    }
    public static void putFile(String fileName, int len, byte[] bs){
        String res = "";
        String cmd = "PutFile";
        File sourceFile = new File(downloadDir+fileName);
        try {
            Socket querySocket = new Socket(IP, PORT);
            try (DataOutputStream dos = new DataOutputStream(querySocket.getOutputStream());
                 DataInputStream dis = new DataInputStream(querySocket.getInputStream())){
                dos.writeUTF(cmd);
                res = dis.readUTF();
                System.out.println("response: " + res);
                if(res.equalsIgnoreCase("Success")){
                    dos.writeUTF(fileName);
                    try (FileInputStream fis = new FileInputStream(sourceFile)){
                        dos.writeInt(len);
                        int b, totalLen = 0;
                        while(totalLen < len && (b = fis.read(bs))!= -1){
                            dos.write(bs, 0, b);
                        }
                        dos.flush();
                    }
                    System.out.println(dis.readUTF());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getFile(String fileName){
        String res = "";
        File destiFile = new File(downloadDir + fileName);
        try {
            Socket querySocket = new Socket(IP, PORT);
            try (DataOutputStream dos = new DataOutputStream(querySocket.getOutputStream());
                 DataInputStream dis = new DataInputStream(querySocket.getInputStream())){
                String cmd = "GetFile";
                dos.writeUTF(cmd);
                res = dis.readUTF();
                System.out.println("response: " + res);
                if(res.equalsIgnoreCase("Success")){
                    dos.writeUTF(fileName);
                    int len = dis.readInt();
                    byte[] bs = new byte[bufferSize];
                    int b, totalLen = 0;
                    try (FileOutputStream fos = new FileOutputStream(destiFile)){
                        while(totalLen < len && (b = dis.read(bs)) != -1){
                            fos.write(bs, 0, b);
                        }
                        fos.flush();
                    }
                    System.out.println("Download complete! (" + fileName + ")");
                }
            }
            querySocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
