package test;

import com.horizon.util.encrypt.DESEDE;
/**
 * @author gyh
 * @date 2016/10/31
 * 外商自动提交到下个节点
 * 测试批量提交的测试 (去掉提交之后看一下),完善那个表
 * 核心功能上的修改
 */
public class Main {
    public static void main(String[] args) throws Exception {
            //System.out.println( DESEDE.encryptIt("20190506yulong"));	
//        System.out.println( DESEDE.decryptIt("CD469D2C4C639B54E9C5BC6152BC966D"));
       System.out.println( DESEDE.decryptIt("7B41516F018A3D465DA3F19984BAB118"));
       System.out.println( DESEDE.encryptIt("admin111111"));
       
//    System.out.println( DigestUtils.md5Hex("xmgd#123456"));
   }
}