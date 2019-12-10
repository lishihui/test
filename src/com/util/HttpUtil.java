package com.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/** 
 *  
 * @author junhu 
 * 
 */  
public class HttpUtil{  
    /** 
     * 使用URLConnection实现GET请求 
     *  
     * 1.实例化一个java.net.URL对象； 2.通过URL对象的openConnection()方法得到一个java.net.URLConnection; 
     * 3.通过URLConnection对象的getInputStream()方法获得输入流； 4.读取输入流； 5.关闭资源； 
     */  
    public static void get(String urlStr) throws Exception  
    {  
  
        URL url = new URL(urlStr);  
        URLConnection urlConnection = url.openConnection(); // 打开连接  
  
        System.out.println(urlConnection.getURL().toString());  
  
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8")); // 获取输入流  
        String line = null;  
        StringBuilder sb = new StringBuilder();  
        while ((line = br.readLine()) != null)  
        {  
            sb.append(line + "\n");  
        }  
        br.close();  
        System.out.println(sb.toString());  
    }  
  
    /** 
     * 使用HttpURLConnection实现POST请求 
     *  
     * 1.实例化一个java.net.URL对象； 2.通过URL对象的openConnection()方法得到一个java.net.URLConnection; 
     * 3.通过URLConnection对象的getOutputStream()方法获得输出流； 4.向输出流中写数据； 5.关闭资源； 
     */  
    public static String post(String urlStr, Map<String, String> parameterMap) throws IOException  
    {  
  
        URL url = new URL(urlStr);  
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();  
  
        httpURLConnection.setDoInput(true);  
        httpURLConnection.setDoOutput(true); // 设置该连接是可以输出的  
        httpURLConnection.setRequestMethod("POST"); // 设置请求方式  
        httpURLConnection.setRequestProperty("charset", "utf-8");  
  
        System.out.println(httpURLConnection.getURL().toString());  
  
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(httpURLConnection.getOutputStream()));  
          
        StringBuffer parameter = new StringBuffer();  
        parameter.append("1=1");  
        for (Entry<String, String> entry : parameterMap.entrySet())  
        {  
            parameter.append("&" + entry.getKey() + "=" + entry.getValue());  
        }  
        pw.write(parameter.toString());// 向连接中写数据（相当于发送数据给服务器）  
          
        pw.flush();  
        pw.close();  
  
        System.out.println("parameter: " + parameter.toString());  
  
        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));  
        String line = null;  
        StringBuilder sb = new StringBuilder();  
        while ((line = br.readLine()) != null)  
        { // 读取数据  
            sb.append(line + "\n");  
        }  
        br.close();
        
        return sb.toString();
    }
    
    /**
     * 发送httpclient请求
     * @param url 请求地址
     * @param headerMap 需要传入的header参数
     * @param contentMap 需要传入的body参数
     * @return
     */
    public static String postMap(String url,Map<String,String> headerMap,String contentMap) {
    	String result = null;
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	HttpPost post = new HttpPost(url);
    	List<NameValuePair> content = new ArrayList<NameValuePair>();
    	//Iterator iterator = contentMap.entrySet().iterator();           //将content生成entity
//    	while(iterator.hasNext()){
//    		Entry<String,String> elem = (Entry<String, String>) iterator.next();  
//    		content.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
//    	}
    	CloseableHttpResponse response = null;
    	try {
    		Iterator headerIterator = headerMap.entrySet().iterator();          //循环增加header
    		while(headerIterator.hasNext()){
    			Entry<String,String> elem = (Entry<String, String>) headerIterator.next();  
    			post.addHeader(elem.getKey(),elem.getValue());
    		}
    			StringEntity postingString = new StringEntity(contentMap);// json传递
    			post.setEntity(postingString);
//    		if(content.size() > 0){
//    			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(content,"UTF-8");
//    			post.setEntity(entity);
//    		}
    		
    		response = httpClient.execute(post);            //发送请求并接收返回数据
    		//if(response != null && response.getStatusLine().getStatusCode() == 200) {
    			
    			HttpEntity entity = response.getEntity();       //获取response的body部分
    			result = EntityUtils.toString(entity);          //读取reponse的body部分并转化成字符串
    		//}
    		return result;
    		
    		
    	}catch (UnsupportedEncodingException e) {
    		e.printStackTrace();
    	}catch (ClientProtocolException e) {
    		e.printStackTrace();
    	}catch (IOException e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			httpClient.close();
    			if(response != null) {
    				 response.close();
    			}
    		}catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	return null;
    	
    }
    
    
    
    
    
} 
