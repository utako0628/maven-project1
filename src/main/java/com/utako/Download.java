package com.utako;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.File;
import java.io.IOException;

public class Download {
    public static void main (String[] args) throws IOException {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://info.tsinghua.edu.cn/");
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();

            String filepath = "C:\\Users\\samsung\\Desktop\\test.txt";
            InputStream is = httpEntity.getContent();
            FileOutputStream fs = new FileOutputStream(new File(filepath));
            byte[] bytes =  new byte[1024];
            int length = 0;
            while ((length = is.read(bytes)) != -1) {
                fs.write(bytes, 0, length);
            }
            is.close();
            fs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
