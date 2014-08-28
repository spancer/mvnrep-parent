package cn.v5cn.mvnrep.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ZYW on 2014/8/28.
 */
public class HttpUtils {
    public static InputStream getResult(String url)throws IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();
                if(response.getStatusLine().getStatusCode() == 200 && entity != null){
                    return entity.getContent();
                }
                return null;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
