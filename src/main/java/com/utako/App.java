package com.utako;

/**
 * Hello world!
 *
 */
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.IOException;

public class App {
    public static void main (String[] args) throws IOException {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String url = "http://zjy-hadoop-prc-ct01.bj:11201/jmx?qry=Hadoop:service=NameNode,name=NameNodeInfo";
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();

            String filepath = "/home/mi/Desktop/test1.txt";
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
