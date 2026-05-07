package HWK7;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MI3C_HWK7_412630153_01 {
    public static void main(String[] args) throws Exception {
        String page = "https://tw.yahoo.com/";
        String destDir = "C:/Data/YahooPic";
        String html = getSource(page);
        var imgList = getImage(html);
        downloadImg(imgList, destDir);
    }
    public static String getSource(String page){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(page);
            HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
            uc.addRequestProperty("User-Agent", "Mozilla/5.0");
            HttpsURLConnection.setFollowRedirects(false);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()))){
                String line;
                while((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return sb.toString();
    }
    public static ArrayList<String> getImage(String html){
        ArrayList<String> imgList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(html, "<>=\" ", true);
        int state = 0; // state 0: 找到標籤, state 1: 找到src, state 2: 找到 "=", state 3: 找到 "\"" 並在遇到下一個 "\""時 加入 list
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.equals(" ")) continue;
            switch (state) {
                case 0:
                    if (token.equalsIgnoreCase("img")) {
                        state = 1;
                    }
                    break;
                case 1:
                    if (token.equalsIgnoreCase("src")) {
                        state = 2;
                    } else if (token.equals(">")) {
                        state = 0;
                    }
                    break;
                case 2:
                    if (token.equals("=")) {
                        state = 3;
                    } else if (token.equals(">")) {
                        state = 0;
                    }
                    break;
                case 3:
                    if (token.equals("\"")) {
                        StringBuilder urlb = new StringBuilder();
                        urlb.append(st.nextToken());
                        if (st.nextToken().equals("\"")) {
                            imgList.add(urlb.toString());
                        }
                    }
                    state = 0;
                    break;
                default:
                    break;
            }
        }
        return imgList;
    }
    public static void downloadImg(ArrayList<String> img, String destDir){
        try {
            for (int i = 0 ; i < img.size() ; i++){
                URL url = new URL(img.get(i));
                HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
                uc.addRequestProperty("User-Agent", "Mozilla/5.0");
                HttpsURLConnection.setFollowRedirects(false);
                File dir = new File(destDir);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                String contentType = uc.getContentType();
                String ext = ".jpg";
                if (contentType != null) {
                    if (contentType.contains("png")) ext = ".png";
                    else if (contentType.contains("gif")) ext = ".gif";
                    else if (contentType.contains("webp")) ext = ".webp";
                    else if (contentType.contains("svg")) ext = ".svg";
                }
                String fileName = String.format("pic%d%s", i, ext);
                File destFile = new File(destDir, fileName);
                try (BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))){
                    byte[] bs = new byte[8192];
                    int b;
                    while((b = bis.read(bs)) != -1){
                        bos.write(bs, 0, b);
                    }
                    bos.flush();
                    System.out.println("成功儲存："+fileName);
                    Thread.sleep((int) (500 + Math.random() * 1000));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
