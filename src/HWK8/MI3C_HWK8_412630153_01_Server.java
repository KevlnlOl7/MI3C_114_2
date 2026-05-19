package HWK8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MI3C_HWK8_412630153_01_Server {
    static String pubDir = "C:/pub/";
    static boolean running = true;

    static int port = 4444;
    static int bufferSize = 8192;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("File Server init ....");
            while (running) {
                Socket client = ss.accept();
                System.out.println("Client: " + client);
                new Thread(()->{
                   server(client);
                }).start();

            }
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void server(Socket client){
        try (DataInputStream dis = new DataInputStream(client.getInputStream());
             DataOutputStream dos = new DataOutputStream(client.getOutputStream())) {
            File[] fileList = new File(pubDir).listFiles();
            String method = dis.readUTF();
            if (method.equalsIgnoreCase("getFile") || method.equalsIgnoreCase("putFile")) {
                dos.writeUTF("Success");
                if (method.equalsIgnoreCase("getFile")) {
                    if (fileList.length <= 0) {
                        System.out.println("No file in this directory");
                        return;
                    }
                    String fileName = dis.readUTF();
                    for (int i = 0; i < fileList.length; i++) {
                        if (fileName.equals(fileList[i].getName())) {
                            int len = (int) fileList[i].length();
                            dos.writeInt(len);
                            byte[] bs = new byte[bufferSize];
                            try (DataInputStream fdis = new DataInputStream(new FileInputStream(fileList[i]))) {
                                int b, totalLen = 0;
                                while (totalLen < len && (b = fdis.read(bs)) != -1) {
                                    dos.write(bs, 0, b);
                                    totalLen += b;
                                }
                                dos.flush();
                            }
                            break;
                        }
                        if (i == fileList.length && !fileList[i].exists()) {
                            dos.writeUTF("Fail");
                            return;
                        }
                    }
                } else if (method.equalsIgnoreCase("putFile")) {
                    String fileName = dis.readUTF();
                    File destiFile = new File(pubDir + fileName);
                    try (DataOutputStream fdos = new DataOutputStream(new FileOutputStream(destiFile))) {
                        int len = dis.readInt();
                        byte[] bs = new byte[bufferSize]; //因為len 有可能會很大，所以這邊我不直接套用len
                        int b, totalRead = 0;
                        while (totalRead < len && (b = dis.read(bs)) != -1) {
                            fdos.write(bs, 0, b);
                            totalRead += b;
                        }
                        fdos.flush();
                    }
                    dos.writeUTF("Put complete! (" + fileName + ")");

                }
            } else {
                dos.writeUTF("Fail");
                System.out.println("Fail");
            }
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
