package com.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonConstant {
	public static String isshang="0";
	public static String guquanzx1="境内法人及其他组织(上市企业)";
	public static String dalian="大连";
    public static HashMap<String, String> xiaoMap ;
    public static HashMap<String, List<String>> fuwuMap ;
    public static HashMap<String, String> liaoningshengMap ;
    public static HashMap<String, String> shandongMap;
    public static HashMap<String, String> fujianshengMap;
    public static HashMap<String, String> zhejiangshengMap;
    public static HashMap<String, String> zhenghaotype;
    public static String lianliucheng ="";
    public static HashMap getliaoningshengHashMap(){
    	liaoningshengMap =new  HashMap<String, String>();
    	liaoningshengMap.put("dalian","大连市" );
    	liaoningshengMap.put("dandong", "丹东市");
    	liaoningshengMap.put("yingkou", "营口市");
    	liaoningshengMap.put("liaoningsheng", "辽宁省");
    	
    	return liaoningshengMap;
    }
    public static HashMap shandongHashMap(){
    	shandongMap =new  HashMap<String, String>();
    	shandongMap.put("qingdao","青岛市" );
    	shandongMap.put("shandongsheng","山东省" );
    	return shandongMap;
    }
    public static HashMap fujianshengHashMap(){
    	fujianshengMap= new HashMap<String, String>();
    	fujianshengMap.put("xiamen", "厦门市");
    	fujianshengMap.put("fujiansheng", "福建省");
    	return fujianshengMap;
    	
    }
    public static HashMap zhejiangshengHashMap(){
    	zhejiangshengMap=new HashMap<String, String>();
    	zhejiangshengMap.put("ningbozhoushan", "宁波市,舟山市");
    	zhejiangshengMap.put("zhoushanningbo", "舟山市,宁波市");
    	zhejiangshengMap.put("zhejiangsheng", "浙江省");
    	zhejiangshengMap.put("ningbo", "宁波市");
    	zhejiangshengMap.put("zhoushan", "舟山市");
    	return zhejiangshengMap;
    	
    }
    public static HashMap  getxiaoMap(){
    	xiaoMap =new HashMap<String, String>();
    	xiaoMap.put("A","厦门,大连,丹东,营口,青岛,深圳");
    	xiaoMap.put("S","厦门,大连,丹东,营口,青岛,深圳");
    	xiaoMap.put("ASX","大连,丹东,营口");
    	xiaoMap.put("J","青岛,大连,厦门,宁波");
    	xiaoMap.put("Z","青岛,大连,厦门,宁波");
    	return xiaoMap;
    }
    
    public static HashMap  getfuwu(){
    	fuwuMap =new HashMap<String, List<String>>();
    	fuwuMap.put("信息服务业务（仅限互联网信息服务）",Arrays.asList("新闻","出版","药品和医疗器械","文化","视听节目"));
    	fuwuMap.put("在线数据处理与交易处理业务",Arrays.asList("电子数据交换业务","交易处理业务","网络/电子设备数据处理业务"));
    	fuwuMap.put("互联网接入服务业务",Arrays.asList("为上网用户提供接入服务","为互联网平台提供接入服务"));
    	fuwuMap.put("互联网数据中心业务",Arrays.asList("不含互联网资源协作服务","互联网资源协作服务"));
    	return fuwuMap;
    }
    
    public static HashMap<String,String>  getzhengzhaoType(){
    	zhenghaotype =new HashMap<String, String>();
    	zhenghaotype.put("境外自然人","护照");
    	zhenghaotype.put("境内自然人","身份证");
    	zhenghaotype.put("境外法人及其他组织","组织机构代码证");
    	zhenghaotype.put("境内法人及其他组织(机关法人、事业单位等)","组织机构代码证");
    	
    	zhenghaotype.put("境内法人及其他组织(上市企业)","组织机构代码证");
    	zhenghaotype.put("境内法人及其他组织(非上市企业)","组织机构代码证");
    	zhenghaotype.put("外资持股","组织机构代码证");
    	zhenghaotype.put("内资持股","组织机构代码证");
    	zhenghaotype.put("合资企业","组织机构代码证");
    	return zhenghaotype;
    }
    
    public static final String SANWANG_COMMON = "三网融合变更申请,联系方式,申请公共表单,";
    
    public static final String SANWANG_COMMON_CODE = "T01,T01T10,T01T11,";
    
    public static final String SANWANG_BIANGENG = "三网融合变更";
    
    /**
     * 互联网服务正选业务
     * 值：新闻出版药品和医疗器械文化视听节目
     */
    public static final String A12zheng = "新闻出版药品和医疗器械文化视听节目";//互联网服务正选业务
    
    /**
     * 互联网服务反选业务模板
     * 值：、信息发布平台和递送服务、信息搜索查询服务、 信息社区服务、信息即时交互服务、信息保护和加工处理服务、
     */
    public static final String A12fan = "、信息发布平台和递送服务、信息搜索查询服务、 信息社区服务、信息即时交互服务、信息保护和加工处理服务、";//互联网服务反选业务模板
}
