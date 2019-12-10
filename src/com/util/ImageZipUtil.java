package com.util;

import java.awt.Color;  
import java.awt.Graphics2D;  
import java.awt.Image;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
  
import javax.imageio.ImageIO;  
    
public final class ImageZipUtil {    
      
    public static void main(String[] args) {  
        zipWidthHeightImageFile(new File("C:\\work\\apache-tomcat-6.0.45\\webapps\\govicardriverAppWeb\\upload\\20170110144727_3924.jpg"),
        		                new File("C:\\work\\apache-tomcat-6.0.45\\webapps\\govicardriverAppWeb\\upload\\min_20170110144727_3924.jpg"),425,0.7f);  
        System.out.println("ok");  
    }  

    /**  
     * 按设置的宽度高度压缩图片文件<br> 先保存原文件，再压缩、上传  
     * @param oldFile  要进行压缩的文件全路径  
     * @param newFile  新文件  
     * @param width  宽度  
     * @param height 高度  
     * @param quality 质量  
     * @return 返回压缩后的文件的全路径  
     */    
    public static String zipWidthHeightImageFile(File oldFile,File newFile, int width, float quality) {    
        if (oldFile == null) {    
            return null;    
        }    
        String newImage = null;    
        try {    
            /** 对服务器上的临时文件进行处理 */    
        	BufferedImage srcFile = ImageIO.read(oldFile);    
              
        	//等比例计算高度
            int height = srcFile.getHeight()*width/srcFile.getWidth();

            String srcImgPath = newFile.getAbsoluteFile().toString();  
            System.out.println(srcImgPath);  
            String subfix = "jpg";  
            subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".")+1,srcImgPath.length());  
  
            BufferedImage buffImg = null;   
            if(subfix.equals("png")){  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);  
            }else{  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            }  
  
            Graphics2D graphics = buffImg.createGraphics();  
            graphics.setBackground(new Color(255,255,255));  
            graphics.setColor(new Color(255,255,255));  
            graphics.fillRect(0, 0, width, height);  
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);    
  
            ImageIO.write(buffImg, subfix, new File(srcImgPath));    
        } catch (FileNotFoundException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return newImage;    
    }    
}    