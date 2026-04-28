package HWK6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MI3C_HWK6_412630153_02 {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg"); // 老師給的網址不行用，代碼 301
            String path = "C:/Data/download.jpg";
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.addRequestProperty("User-Agent", "Mozilla/5.0");
            HttpURLConnection.setFollowRedirects(false);
            int len = uc.getContentLength();
            byte[] bs = new byte[len];
            System.out.println("Response: " + uc.getResponseCode());
            try(BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path))){
                int bytesGot, totalBytes = 0;
                while(totalBytes < len && (bytesGot = bis.read(bs, totalBytes, len - totalBytes)) != -1){
                    totalBytes += bytesGot;
                }
                bos.write(bs);
                bos.flush();
                System.out.printf("成功寫入 %.2f kb 的檔案\n存放於 %s", totalBytes / 1024.0, path);
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
