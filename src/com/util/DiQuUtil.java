package com.util;

import horizon.json.JSONArray;
import horizon.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.horizon.context.Context;
import com.horizon.context.ContextFactory;
import com.horizon.db.Access;
@SuppressWarnings(value= {"unchecked","unused"})
public class DiQuUtil {
    public String getDiQuList() {

        Context context = ContextFactory.getContext();
        String userid = context.getUserId();
        String sql="select * from DXXZSP_AREA order by id asc";
        List<Map> maps=Access.getMultiMap(sql, null);

        String aa =JSONArray.fromObject(maps).toString();
        return aa;
    }
    /**
     * 根据城市获取对应省份
     * @param cityName
     * @return
     */
    public String getProvinceList(String cityName) {
        String querySql="select * from DXXZSP_AREA where substr(xiancode,0,2)=(select substr(xiancode,0,2) from DXXZSP_AREA where name='"+cityName+"') and length(xiancode)=3 order by id asc";
        List<Map> maps=Access.getMultiMap(querySql,null);
        String provinceStr=JSONArray.fromObject(maps).toString();
        return provinceStr;
    }
    /**
     * 查询全国字段
     * @return
     */
    public String getCountryWide() {
        String querySql="select * from DXXZSP_AREA where xiancode='100' order by id asc";
        List<Map> maps=Access.getMultiMap(querySql,null);
        String CountryWideStr=JSONArray.fromObject(maps).toString();
        return CountryWideStr;
    }
    /**
     * 查询只限全国和省份
     * @return
     */
    public String getProvinceAndCountryWide() {
        String querySql="select * from DXXZSP_AREA where length(xiancode)=3 order by id asc";
        List<Map> maps=Access.getMultiMap(querySql,null);
        String provAndCountryStr=JSONArray.fromObject(maps).toString();
        return provAndCountryStr;
    }


    /**
     * 查询只限全国和当前公司所在的省份
     * @return
     */
    public String getProvinceAndCountrybyuser() {
        Context context = ContextFactory.getContext();
        String loginname = context.getLoginName();
        String provincesql="select a.REGISTERPROVINCE as pro from WETRIL_CNKI_ENTBASE a where account='"+loginname+"'";
        String province=Access.getSingleMap(provincesql, null).get("pro").toString();
        String querySql="select * from DXXZSP_AREA where length(xiancode)=3 and  name='全国' or name='"+province+"'";
        List<Map> maps=Access.getMultiMap(querySql,null);
        String provAndCountryStr=JSONArray.fromObject(maps).toString();
        return provAndCountryStr;
    }


    /**
     * 查询只限全国和当前公司所在的省份下所有城市 liuhy 2018-09-10
     * @return
     */
    public String getProvinceAndCountrybyuserAll() {
        Context context = ContextFactory.getContext();
        String loginname = context.getLoginName();
        String provincesql="select a.REGISTERPROVINCE as pro from WETRIL_CNKI_ENTBASE a where account='"+loginname+"'";
        String province=Access.getSingleMap(provincesql, null).get("pro").toString();
        String querySql= "select * from DXXZSP_AREA where  name='全国' or name='"+province+"'"
                         + " union all "
                         + "select * from DXXZSP_AREA where parentid in(select id from DXXZSP_AREA where  name='"+province+"')";
        List<Map> maps=Access.getMultiMap(querySql,null);
        String provAndCountryStr=JSONArray.fromObject(maps).toString();
        return provAndCountryStr;
    }


    /**
     * 根据条件查询省市
     * @param businessCode
     */
    public String getProvinceByCondition(String businessCode,String userId,String num) {
        Map<String, String> idMap = new HashMap<String, String>();//查询id
        Map<String, String> covMap = new HashMap<String, String>();//覆盖范围
        String licid = "";
        String coverage = "";
        String provAndCountryStr="";
        String entid="";
        String loginName="";
        String inCondition="";//sql语句中in的条件
        StringBuffer cityBuffer = new StringBuffer();
        {
            //找到licid
            if (userId != null && !"".equals(userId)) {
                //根据userid 找到 登录名
                String queryLogin="select login_name from TO_HORIZON_USER where id='"+userId+"'";
                Map loginMap = Access.getSingleMap(queryLogin, null);
                if(loginMap!=null) {
                    loginName=loginMap.get("login_name").toString();
                } else {
                    loginMap=new HashMap();
                }
                //根据登录名找到企业entid
                String queryEntid = "select entid from WETRIL_CNKI_ENTBASE where account='"+loginName+"' and version='1'";
                Map entidMap = Access.getSingleMap(queryEntid, null);
                if(entidMap!=null) {
                    entid=entidMap.get("entid").toString();
                } else {
                    entidMap=new HashMap();
                }
                //根据企业id 查询许可证licid
                String queryId="select licid from WETRIL_CNKI_LICENSE where entid='"+entid+"'  and version='1'"+"and num='"+num+"'";
                //根据yewucode 判断如果是变更申请则加条件
                {  //gyh 2018-12-2
                    switch(businessCode.charAt(0)){
                    case 'a' :
                    case 'A' :
                        queryId += "AND VERSIONMISSIONID = 'snxk'";
                        break;
                    case 'k' :
                    case 'K' :
                        queryId += "AND VERSIONMISSIONID = 'kdqxk'";
                        break;
                    case 'z' :
                    case 'Z' :
                        queryId += "AND VERSIONMISSIONID = 'zimaoqu'";
                        break;
                    }
                }
                idMap = Access.getSingleMap(queryId,null);
                if(idMap==null) {
                    idMap=new HashMap();
                }
                licid = idMap.get("licid") == null ? "" : idMap.get("licid").toString();
            }
        }

        String queryCovSql="select trim(ywfw) as ywfw from WETRIL_CNKI_LICBUS where licid='"+licid+"' and yewucode='"+businessCode+"'  and version='1'";
        covMap = Access.getSingleMap(queryCovSql, null);
        if(covMap!=null) {
            coverage = covMap.get("ywfw") == null ? "" : covMap.get("ywfw").toString();
            //全国找到所有的省
            if("全国".equals(coverage.trim())) {
                String querySql="select * from DXXZSP_AREA where length(xiancode)=3 order by id asc";
                List<Map> allMaps=Access.getMultiMap(querySql,null);
                provAndCountryStr = JSONArray.fromObject(allMaps).toString();
                Map<String,Object> map =new HashMap();
                map.put("result",allMaps);
                map.put("type", "1");
                return JSONObject.fromObject(map).toString();
            } else {
                //找出省份,拼接成 in 查询条件
                String[] coverageArr=coverage.split(",");
                for(int i=0; i<coverageArr.length; i++) {
                    cityBuffer.append("'"+coverageArr[i]+"',");
                }
                inCondition = (cityBuffer.substring(0,cityBuffer.length()-1)).toString();//去除最后一个","
                String querySql="select * from DXXZSP_AREA where  name in("+inCondition+") or name='全国' order by id asc";
                List<Map> cityMaps=Access.getMultiMap(querySql,null);
                Map<String,Object> map =new HashMap();
                map.put("result",cityMaps);
                map.put("type", "2");
                //如果是互联网数据中心业务  --则bussunesscode   = k04 
                {//20181203 gyh
                    StringBuffer  buffer = new StringBuffer("SELECT * FROM DXXZSP_AREA WHERE  ID IN(");
                    if("A04".equalsIgnoreCase(businessCode)||"K04".equalsIgnoreCase(businessCode)){
                        boolean iscity = false;
                        Iterator<Map> it = cityMaps.iterator();
                        Map<String,Object> temp = null;
                        while(it.hasNext()){
                            temp = it.next();
                            if( !"100000".equals(temp.get("parentid").toString()) && !"100000".equals(temp.get("id").toString())){
                                buffer.append("'"+temp.get("parentid").toString()+"',");
                                iscity = true;
                           }
                        }
                        buffer.setCharAt(buffer.length()-1,')');
                        if(iscity){
                            List<Map> parentMaps=Access.getMultiMap(buffer.toString(),null);
                            cityMaps.addAll(parentMaps);
                            map.put("type", "3"); 
                        }
                    }
                }
                return JSONObject.fromObject(map).toString();
            }
        }
        return "{\"result\":[],\"type\":\"2\"}";
    }





    /**
     * 外资互联网接入服务业务根据条件查询省
     * @param businessCode
     */
    public String waizigetProvinceByCondition(String cityname) {

        StringBuffer cityBuffer = new StringBuffer();
        if(cityname!="") {
            if("全国".equals(cityname)) {
                String querySql="select * from DXXZSP_AREA where length(xiancode)=3 order by id asc";
                List<Map> allMaps=Access.getMultiMap(querySql,null);
                String provAndCountryStr = JSONArray.fromObject(allMaps).toString();
                Map<String,Object> map =new HashMap();
                map.put("result",allMaps);
                map.put("type", "1");
                return JSONObject.fromObject(map).toString();
            } else {

                String[] coverageArr=cityname.split(",");
                for(int i=0; i<coverageArr.length; i++) {
                    cityBuffer.append("'"+coverageArr[i]+"',");
                }
                String inCondition = (cityBuffer.substring(0,cityBuffer.length()-1)).toString();//去除最后一个","
                String querySql="select * from DXXZSP_AREA where  name in("+inCondition+") or name='全国' order by id asc";
                List<Map> cityMaps=Access.getMultiMap(querySql,null);
                Map<String,Object> map =new HashMap();
                map.put("result",cityMaps);
                map.put("type", "2");
                return JSONObject.fromObject(map).toString();

            }
        }
        return "{\"result\":[],\"type\":\"2\"}";
    }







    /**
     * 查询全国省和市
     *@return
      */
    public String getProvinceAndCountryAll() {
        String querySql="select * from DXXZSP_KDJR_AREA order by id asc";
        List<Map>maps=Access.getMultiMap(querySql,null);
        String countryAll=JSONArray.fromObject(maps).toString();
        return countryAll;
    }

    /**
     * 查询全国省
     */
    public  String getQuanguosheng() {
        Context context = ContextFactory.getContext();
        String userid = context.getUserId();
        String username = context.getUserName();
        String querySql="select  *  from DXXZSP_KDJR_AREA  where length(xiancode)=3  and  name  NOT in  (select  a.cityname from DXXZSP_YEWUJILU_USER a,BXXZSP_YEWUKE_SJ_VIEWYUANAAAA b where a.shijianid=b.id and b.status != '已办结' and a.yewucode='J01' and a.cityname is not null and (a.status != '3' and a.status != '33' or a.status is null) and a.rname='"+username+"') order by id asc";
        List<Map>maps=Access.getMultiMap(querySql,null);
        String countryAllsheng=JSONArray.fromObject(maps).toString();
        return countryAllsheng;
    }
    /**
     * 不同企业根据省获取相应城市
     */
    public String getProvincecityes(String aa) {

        String sqlString="select * from DXXZSP_KDJR_AREA where name='"+aa+"' order by id asc";
        Map map1=Access.getSingleMap(sqlString, null);
        String shenid =map1.get("id").toString();
        String sqlStrings="select * from dxxzsp_kdjr_area where xiancode='100' order by id asc";//获得全国的名称及
        Map map2=Access.getSingleMap(sqlStrings, null);

        String querySql="select * from DXXZSP_KDJR_AREA  where (id='"+shenid+"' or parentid='"+shenid+"' ) order by id asc";
        List<Map>maps=Access.getMultiMap(querySql,null);
        maps.add(map2);
        String countryAll=JSONArray.fromObject(maps).toString();
        return countryAll;
    }

    /**
     * 根据省获取地区 宽带专用
     */
    public String getdiqus() {
        //当为省的情况
        List<Map> list =new ArrayList<>();
        Context context = ContextFactory.getContext();
        String deptid =context.getDeptId();
        String deptnamesql ="select dept_name from TO_HORIZON_DEPT where id=(select parent_id from TO_HORIZON_DEPT where id='"+deptid+"') ";
        Map map2 =Access.getSingleMap(deptnamesql, null);//

        //获取其是否含有部级的权限
        String userid =context.getUserId();
        String rolesql ="select role_id from TPR_HORIZON_OBJ_ROLE where (role_id='HZ2885fc650dd0d501650e2216560329' or role_id='HZ402881321aa4f8ef011aa4ffb0a400') and object_id='"+userid+"'";
        Map maprole=Access.getSingleMap(rolesql, null);//是否含有部的权限

        if(maprole!=null||userid.equals("admin")) {

            //当为部里面情况
            String sqldiqu ="select name,id from DXXZSP_KDJR_AREA where leave='2'  order by id asc";
            list=Access.getMultiMap(sqldiqu, null);
            for (Map map : list) {
                String id=map.get("id")+"";
                String sqldiqushi ="select name,id from DXXZSP_KDJR_AREA where parentid='"+id+"' order by id asc";
                List<Map> list2=Access.getMultiMap(sqldiqushi, null);
                map.put("listshi", list2);
            }
        } else {
            if(map2!=null) {
                String deptName =map2.get("dept_name")+"";
                String sqldiqu ="select name,id from DXXZSP_KDJR_AREA where leave='2' and name like '%"+deptName+"%'  order by id asc";
                list=Access.getMultiMap(sqldiqu, null);
                for (Map map : list) {
                    String id=map.get("id")+"";
                    String sqldiqushi ="select name,id from DXXZSP_KDJR_AREA where parentid='"+id+"' order by id asc";
                    List<Map> list2=Access.getMultiMap(sqldiqushi, null);
                    map.put("listshi", list2);

                }
            }

        }

        return JSONArray.fromObject(list).toString();
    }

    /**
     * 根据省获取地区 宽带专用
     */
    public String getdiqusjian() {
        //当为省的情况
        List<Map> list =new ArrayList<>();
        Context context = ContextFactory.getContext();
        String deptid =context.getDeptId();
        String deptnamesql ="select dept_name from TO_HORIZON_DEPT where id=(select parent_id from TO_HORIZON_DEPT where id='"+deptid+"') ";
        Map map2 =Access.getSingleMap(deptnamesql, null);//

        //获取其是否含有部级的权限
        String userid =context.getUserId();
        String rolesql ="select role_id from TPR_HORIZON_OBJ_ROLE where role_id='HZ2885fc650dd0d501650e2216560329' and object_id='"+userid+"'";
        Map maprole=Access.getSingleMap(rolesql, null);//是否含有部的权限

        if(maprole!=null) {

            //当为部里面情况
            String sqldiqu ="select name,id from DXXZSP_KDJR_AREA where leave='2'  order by id asc";
            list=Access.getMultiMap(sqldiqu, null);
//         for (Map map : list) {
//             String id=map.get("id")+"";
//             String sqldiqushi ="select name,id from DXXZSP_KDJR_AREA where parentid='"+id+"' order by id asc";
//             List<Map> list2=Access.getMultiMap(sqldiqushi, null);
//             map.put("listshi", list2);
//
//         }
        } else {
            if(map2!=null) {
                String deptName =map2.get("dept_name")+"";
                String sqldiqu ="select name,id from DXXZSP_KDJR_AREA where leave='2' and name like '%"+deptName+"%'  order by id asc";
                list=Access.getMultiMap(sqldiqu, null);
//                 for (Map map : list) {
//                     String id=map.get("id")+"";
//                     String sqldiqushi ="select name,id from DXXZSP_KDJR_AREA where parentid='"+id+"' order by id asc";
//                     List<Map> list2=Access.getMultiMap(sqldiqushi, null);
//                     map.put("listshi", list2);
//
//                 }
            }

        }

        return JSONArray.fromObject(list).toString();
    }

    public String getdiqus4jieguo() {
        List<Map> list =new ArrayList<>();
        Context context = ContextFactory.getContext();
        String deptid =context.getDeptId();
        String deptnamesql ="select dept_name from TO_HORIZON_DEPT where id=(select parent_id from TO_HORIZON_DEPT where id='"+deptid+"') ";
        Map map2 =Access.getSingleMap(deptnamesql, null);//

        //获取其是否含有部级的权限
        String userid =context.getUserId();
        String rolesql ="select role_id from TPR_HORIZON_OBJ_ROLE where role_id='HZ2885fc650dd0d501650e2216560329' and object_id='"+userid+"'";
        Map maprole=Access.getSingleMap(rolesql, null);//是否含有部的权限
        Map<String,Object> map3=new HashMap<String,Object>();
        if(maprole!=null) {
            map3.put("sibu","yes");

        } else {
            if(map2!=null) {
                String deptName =map2.get("dept_name")+"";
                String sqldiqu ="select name,id from DXXZSP_KDJR_AREA where leave='2' and name like '%"+deptName+"%'  order by id asc";
                map3=Access.getSingleMap(sqldiqu, null);
                if(map3==null) {
                    map3= new HashMap<String,Object>();
                    map3.put("cixu","0");
                } else {
                    map3.put("sibu","no");
                    String sqldiqus ="select name,id from DXXZSP_KDJR_AREA where leave='2' order by id asc";
                    List<Map> listdiqu =Access.getMultiMap(sqldiqus, null);
                    for (int i=0; i<listdiqu.size() ; i++) {
                        String diqu=listdiqu.get(i).get("name")+"";
                        if(diqu.contains(deptName)) {
                            map3.put("cixu",""+i);
                        }
                    }
                }

            }
            map3.put("sibu","no");
        }
        String countryAll=JSONObject.fromObject(map3).toString();
        return countryAll;
    }

    public Map getdiqus4xuke() {
        List<Map> list =new ArrayList<>();
        Context context = ContextFactory.getContext();
        String deptid =context.getDeptId();
        String deptnamesql ="select dept_name from TO_HORIZON_DEPT where id=(select parent_id from TO_HORIZON_DEPT where id='"+deptid+"') ";
        Map map2 =Access.getSingleMap(deptnamesql, null);//

        Map tiaojian =new HashMap<String,String>();
        //如果不里面为不里面的，者给不里面的条件
        if(map2 !=null&&(map2.get("dept_name")+"").contains("电信业务")) {
            tiaojian.put("proid", "000000");
            tiaojian.put("versionmissionid", "kdqxk");
            return tiaojian;
        } else {
            //获取其是否含有部级的权限
            String deptName =map2.get("dept_name")+"";
            String sqldiqu ="select name,id as proid  from DXXZSP_AREA where leave='2' and name like '%"+deptName+"%'  order by id asc";
            Map map3=Access.getSingleMap(sqldiqu, null);
            String  proid =  map3.get("proid")+"" ;
            tiaojian.put("proid", proid);
            tiaojian.put("versionmissionid", "snxk");
            String countryAll=JSONObject.fromObject(tiaojian).toString();
            return tiaojian;
        }
    }

    public  String getAreaByorder(String args){
    	String inCondition="'"+args.replaceAll(",","','")+"'";
    	String querySql="select wm_concat(name) names from DXXZSP_AREA where  name in ("+inCondition+")  order by id asc";
    	Map map2 =Access.getSingleMap(querySql, null);//
    	String names =(map2.get("names")+"").replace("null", "");
    	return names;
    }
}
