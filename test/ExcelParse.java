package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParse {
      @SuppressWarnings("resource")
      public static void main(String[] args) {
            String dm_jdbcUrl = "jdbc:dm://219.141.169.240:8003";
            String dm_username = "DXYWSCGL_TEST";
            String dm_password = "DXYWSCGL_TEST";
//            String dm_jdbcUrl = "jdbc:dm://10.1.5.12:5236";
//            String dm_username = "DXYWSCGL";
//            String dm_password = "HC886nc25y";
            String dm_driver = "dm.jdbc.driver.DmDriver";
            String source = "C:/Users/Administrator/Desktop/1.xlsx";
            String output = "C:/Users/Administrator/Desktop/2.xlsx";
            Connection conn = null;
            PreparedStatement ps = null;
            PreparedStatement prefectPs = null;
            ResultSet result = null;
            File file = new File(source);
            InputStream is = null;
            try {
                  is = new FileInputStream(file);
            } catch (FileNotFoundException e2) {
            }
            Workbook workbook = null;
            try {
                  workbook = new XSSFWorkbook(is);
            } catch (IOException e2) {
                  e2.printStackTrace();
            }
            Sheet sheet = workbook.getSheetAt(0);
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            System.out.println(lastRow);
            Sheet out = workbook.createSheet("结果");
            Row row = null;
            try {
                  Class.forName(dm_driver);
            } catch (ClassNotFoundException e) {
                  e.printStackTrace();
            }
            try {
                  conn = DriverManager.getConnection(dm_jdbcUrl, dm_username,dm_password);
                  String prefect = "select CORPORATENAME,CORPORATEMOBILE,CORPORATEPHONE,LINKMAN,LINKMOBILE,LINKPHONE from wetril_cnki_license a left join  wetril_cnki_entbase b on a.entid = b.entid  where num = ? and a.version = '1' and b.version = '1' and a.flag = '1'";
                  String sql = "select CORPORATENAME,CORPORATEMOBILE,CORPORATEPHONE,LINKMAN,LINKMOBILE,LINKPHONE from wetril_cnki_entbase where name= ? and version = '1'";
                  ps = conn.prepareStatement(sql);
                  prefectPs = conn.prepareStatement(prefect);
                  for (; firstRow < lastRow; firstRow++) {
                        if(sheet.getRow(firstRow + 1).getCell(0).getStringCellValue()==null||sheet.getRow(firstRow + 1).getCell(0).getStringCellValue().equals("")){
                              continue;
                        }
                        prefectPs.setString(1, sheet.getRow(firstRow + 1).getCell(0).getStringCellValue());
                        result = prefectPs.executeQuery();
                        if (result.next()) {
                              System.out.println(result);
                                row = out.createRow(firstRow);
                                row.createCell(0).setCellValue(sheet.getRow(firstRow+1).getCell(0).getStringCellValue());  
                                row.createCell(1).setCellValue(sheet.getRow(firstRow+1).getCell(1).getStringCellValue());
                                row.createCell(2).setCellValue(result.getString("CORPORATENAME"));
                                row.createCell(3).setCellValue(result.getString("CORPORATEMOBILE"));
                                row.createCell(4).setCellValue(result.getString("CORPORATEPHONE"));
                                row.createCell(5).setCellValue(result.getString("LINKMAN"));
                                row.createCell(6).setCellValue(result.getString("LINKMOBILE"));
                                row.createCell(7).setCellValue(result.getString("LINKPHONE"));
                                row.createCell(8).setCellValue("ByNum");
                        } else {
                              ps.setString(1, sheet.getRow(firstRow + 1).getCell(1).getStringCellValue());
                              result = ps.executeQuery();
                              if (result.next()) {
                                      row = out.createRow(firstRow);
                                      row.createCell(0).setCellValue(sheet.getRow(firstRow+1).getCell(0).getStringCellValue());  
                                      row.createCell(1).setCellValue(sheet.getRow(firstRow+1).getCell(1).getStringCellValue());
                                      row.createCell(2).setCellValue(result.getString("CORPORATENAME"));
                                      row.createCell(3).setCellValue(result.getString("CORPORATEMOBILE"));
                                      row.createCell(4).setCellValue(result.getString("CORPORATEPHONE"));
                                      row.createCell(5).setCellValue(result.getString("LINKMAN"));
                                      row.createCell(6).setCellValue(result.getString("LINKMOBILE"));
                                      row.createCell(7).setCellValue(result.getString("LINKPHONE"));
                              }
                        }
                  }
                  workbook.write(new FileOutputStream(output));
                  
                  conn.setAutoCommit(false);
            } catch (SQLException e) {
                  e.printStackTrace();
                  try {
                        conn.rollback();
                  } catch (SQLException e1) {
                        e1.printStackTrace();
                  }
            } catch (FileNotFoundException e) {

                  e.printStackTrace();
            } catch (IOException e) {

                  e.printStackTrace();
            } finally {
                  try {
                        result.close();
                        ps.close();
                        conn.close();
                  } catch (SQLException e) {
                        e.printStackTrace();
                  }
            }
      }
}
