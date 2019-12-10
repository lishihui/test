package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 工具类杂项，用于整合数 数组 等一系列的求值操作
 * @author 王闽扬
 * 
 *
 */
public class RiCHangUtil {
	
	    public static String shu10To16(String[] args) {
	        String s = "15"; 
	       s= Integer.toHexString(Integer.parseInt(s));
	        return padLeft(s,3);
	    }
	    
	    public static int countchar(String s, char ch) {
	        int sum = 0;
	        int length = s.length();
	        for (int i = 0; i != length; ++i) {
	            if (ch == s.charAt(i)) {
	                ++sum;
	            }
	        }
	        return sum;
	    }
	    public static String[] shumap={"一","二","三","四","五","六","七","八","九","十","十一"
	    	,"十二","十三","十四","十五","十六","十七","十八","十九","二十","二十一","二十二","二十三"};
	    /**
	     * 
	     * @param str 2进制数
	     * @param len 补位位数
	     * @return Str 返回补位长度
	     */
	    public static String padLeft(String str,int len){
	        String pad="0000000000000000";
	 
	        return len>str.length()&&len<=16&&len>=0?pad.substring(0,len-str.length())+str:str;
	    }
	    
	    
	    /**
	     * 
	     * @param args 可以分割的字符串
	     * @param a 截取的位数，比如3 表示截取从0到3位，包含第3为
	     * @param fege 分隔符
	     * @return 返回结果数集
	     */ 
	    public static List<String> stringZU2QuChong(String args,int a,String fege) {
	       // String test = "T01,T02,T00,T02,T05";
	        String[] test1 = args.split(fege);
	        List<String> listguo =new ArrayList();
	        HashMap<String, String> set = new HashMap();
	        if(a!=0){
	        	List<String> listSubStrim =new ArrayList();
	        	for (String O : test1) {
	        		if(!(O.equals(""))){
	        		listSubStrim.add(O.substring(0, a));
	        		}
	        		
	        	}
	        	for (String R : listSubStrim) {
					if(set.get(R)==null){
						listguo.add(R);
						set.put(R, R);
					}
				}
		       
		        
		        return listguo;
	        }
	      
	        for (String O : test1) {
        		if(!(O.equals(""))){
        			if(set.get(O)==null){
						listguo.add(O);
						set.put(O,O);
					}
        		}
        		
        	}
	       
	        return listguo;
	    }
	    
	    public static void main(String[] args) {
			//String sql="select * from dxxzsp_area where name='北京市'";
			//Map pfMap =Access.getSingleMap(sql, null,"system");
	    	float original =(float) 100.00;
	    	Calendar now = Calendar.getInstance();
		}
	    
	    
	    public static int compare_date(String DATE1, String DATE2) {
	        
	        
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        try {
	            Date dt1 = df.parse(DATE1);
	            Date dt2 = df.parse(DATE2);
	            if (dt1.getTime() > dt2.getTime()) {
	                return 1;
	            } else if (dt1.getTime() < dt2.getTime()) {
	                return -1;
	            } else {
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
	}

