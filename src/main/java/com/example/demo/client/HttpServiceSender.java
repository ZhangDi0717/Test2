package com.example.demo.client;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.methods.DeleteMethod;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.methods.PutMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;

import org.apache.commons.codec.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HttpServiceSender {

    protected static final Logger LOGGER = LoggerFactory.getLogger(HttpServiceSender.class);


    public static String[] get(String url) throws Exception{
        String[] response = new String[2];
        response[0] = "-1";

        //创建接收对象
        CloseableHttpClient client = HttpClientBuilder.create().build();


        HttpGet get = new HttpGet(url);
        HttpResponse resp = client.execute(get);

        if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            //解析数据
            String data = EntityUtils.toString(resp.getEntity(), Charsets.UTF_8);
            response[1] = data;
            System.out.println(data);
        }

        response[0] = String.valueOf(resp.getStatusLine().getStatusCode());
        return response;
    }

    public static String[] post(String url) throws Exception {
        String[] response = new String[2];
        response[0] = "-1";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name", "wang"));
        params.add(new BasicNameValuePair("age", "12"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
        post.setEntity(entity);
        HttpResponse resp = client.execute(post);
        // 判断是否正常返回
        if (resp.getStatusLine().getStatusCode() == 200) {
            // 解析数据
            HttpEntity resEntity = resp.getEntity();
            String data = EntityUtils.toString(resEntity);
            System.out.println(data);
            response[1]=data;
        }
        response[0] = String.valueOf(resp.getStatusLine().getStatusCode());
        return response;
    }
    public static String[] postJson(String url) throws Exception {
        String[] response = new String[2];
        response[0] = "-1";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json;charset=UTF-8");

        String js = "{\"name\":\"wang\",\"age\":\"706923\"}";
        StringEntity entity = new StringEntity(js);

        entity.setContentType("application/json");
        post.setEntity(entity);
        HttpResponse resp = client.execute(post);
        // 判断是否正常返回
        if (resp.getStatusLine().getStatusCode() == 200) {
            // 解析数据
            HttpEntity resEntity = resp.getEntity();
            String data = EntityUtils.toString(resEntity);
            System.out.println(data);
            response[1]=data;
        }
        response[0] = String.valueOf(resp.getStatusLine().getStatusCode());
        return response;
    }


    public static void main(String[] args) throws Exception {
        HttpServiceSender cl = new HttpServiceSender();
        String url = "http://127.0.0.1:8080/postjson";
        String [] a=cl.postJson(url);
        System.out.println("++++++++++++++"+a[0]+"  "+a[1]);
    }

    //        HttpClient client = new HttpClient();
//        client.getHttpConnectionManager().getParams().setConnectionTimeout(2000);
//        client.getHttpConnectionManager().getParams().setSoTimeout(2000);
//        GetMethod getMethod = new GetMethod(url);
//        getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
//        getMethod.setRequestHeader("Content-Type", "application/json");
//        try {
//            client.executeMethod(getMethod);
//            response[0] = String.valueOf(getMethod.getStatusCode());
//            if (getMethod.getStatusCode() == SC_OK) {
//                response[1] = new String(getMethod.getResponseBodyAsString());// .getBytes("ISO-8859-1"),"utf-8");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            getMethod.releaseConnection();
//        }
//        return response;






}
