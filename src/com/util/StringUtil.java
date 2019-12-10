package com.util;

import horizon.json.JSONObject;

import java.util.Iterator;
import java.util.List;

public class StringUtil {
      
      public static String isEmpty(String str) {
            return null == str  || "".equals(str.trim()) || "null".equals(str.trim())? null : str.trim();
      }
	// 判断字符创是否为空
	public static boolean isNull(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	// 拼接报文
	public static String jointReport(JSONObject requestData) {
		String param = "";

		Iterator iterator = requestData.keys();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = requestData.getString(key);

			value = null;//isNull(value) == true ? "" : Arithmetic.getEncString(value,
					//Constants.InspectUserInfo.secretkey);
			param += "<" + key.toUpperCase() + ">" + value + "</"
					+ key.toUpperCase() + ">";
		}

		return param;
	}

	// 判断对象是否为空
	public static boolean isObjEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if ((obj instanceof List)) {
			return ((List) obj).size() == 0;
		}
		if ((obj instanceof String)) {
			return ((String) obj).trim().equals("");
		}
		return false;
	}
	
	//去除字符串中的多余逗号 两个逗号留一个，末尾的逗号删除  20190809 mhl
	public static String deleteChar(String str){
		str = str.trim().replaceAll(",,", "").replaceAll("、",",");
		if(str.lastIndexOf(",")==str.length())
			str = str.substring(0,str.length()-2);
		if(str.indexOf(",")>0) {
			String[] s = str.split(",");
			str = "";
			for(int i=0;i<s.length; i++){
				if(!"".equals(s[i])&&s[i]!=null) if(i==s.length-1) str = str + s[i]; else str = str + s[i]+",";
			}
		}
		
		 return str;
	}
	
	//判断覆盖字符串是否包含全国所有省，包含所有省返回全国
	public static String isAllProvince(String str){
		str = str.trim().replaceAll(",,", "");
		if(str.lastIndexOf(",")==str.length())
			str = str.substring(0,str.length()-2);
		if(str.indexOf(",")>0) {
			String[] pro = str.split(",");
			if(pro.length==31){
				str = "全国";
			}
		}
		return str;
	}

}
