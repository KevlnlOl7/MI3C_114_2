package HWK6;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class MI3C_HWK6_412630153_01 {
    public static void main(String[] args) throws Exception{
        while(true){
            try {
                URL url = new URL("https://www.yahoo.com.tw");
                HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
                uc.addRequestProperty("User-Agent", "Mozilla/5.0");
                HttpsURLConnection.setFollowRedirects(false);
                InputStreamReader isr = new InputStreamReader(uc.getInputStream(), "utf-8");
                try (BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"))) {
                    String aLine = "", keyword = "日圓";
                    int i = 0, cnt = 0;
                    double delaySec = 60 * 10;
                    while ((aLine = br.readLine()) != null) {
                        int index = aLine.indexOf(keyword);
                        if (index != -1) {
                            int start = Math.max(0, index - 20);
                            int end = Math.min(aLine.length(), index + 40);
                            System.out.printf("[%d] ...\t %s\t...\n", i+1, aLine.substring(start, end));
                            i++;
                        }
                    }
                    cnt++;
                    System.out.printf("已完成第 %d 輪掃描，共找到 %d 筆關鍵字\n%.2f 秒後會進行下一輪掃描", cnt, i, delaySec);
                    delay(delaySec);
                } catch (Exception ie) {
                    ie.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void delay(double sec){
        try {
            Thread.sleep((int)sec * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
