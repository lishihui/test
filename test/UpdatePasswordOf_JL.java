package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.horizon.utils.DESEDE;

public class UpdatePasswordOf_JL {
      public static void main(String[] args)  {
            String dm_jdbcUrl ="jdbc:dm://10.1.5.12:5236";
            String dm_username = "DXYWSCGL";
            String dm_password = "HC886nc25y";
            String dm_driver ="dm.jdbc.driver.DmDriver";
            try {
                  Class.forName(dm_driver);
            } catch (ClassNotFoundException e2) {
                  e2.printStackTrace();
            }
            Connection conn = null;
            PreparedStatement selectLoginNameOfJL_ps = null;
            PreparedStatement updatePasswordOfJL_ps  =null;
            ResultSet selectLoginNameOfJL_result  = null;
           try {
                  conn = DriverManager.getConnection(dm_jdbcUrl, dm_username, dm_password);
                  String selectLoginNameOfJL_sql = "select * from   TO_HORIZON_USER where substr(id,0,2) =  'JL'";
                  selectLoginNameOfJL_ps = conn.prepareStatement(selectLoginNameOfJL_sql);
                  selectLoginNameOfJL_result = selectLoginNameOfJL_ps.executeQuery();
                  String updatePasswordOfJL_sql = "update TO_HORIZON_USER set password = ?,user_style = 'default' , register_time  = '2019-01-30 22:08:32' where login_name =? and id = ? ";
                  System.out.println(updatePasswordOfJL_ps==null);
                  updatePasswordOfJL_ps = conn.prepareStatement(updatePasswordOfJL_sql);
                  System.out.println(updatePasswordOfJL_ps==null);
                  conn.setAutoCommit(false);
                  while (selectLoginNameOfJL_result.next()) {
                        updatePasswordOfJL_ps.setString(1,DESEDE.encryptIt(selectLoginNameOfJL_result.getString("LOGIN_NAME")));
                        updatePasswordOfJL_ps.setString(2,selectLoginNameOfJL_result.getString("LOGIN_NAME"));
                        updatePasswordOfJL_ps.setString(3,selectLoginNameOfJL_result.getString("ID"));
                        updatePasswordOfJL_ps.addBatch();
                  }
                 int[]  resultCount =  updatePasswordOfJL_ps.executeBatch();
                 if(resultCount.length==230){
                       int count = 0;
                       for(int i=0,len=resultCount.length;i<len;i++){
                             count+=resultCount[i];
                             System.out.println(resultCount[i]);
                       }
                       if(count==230){
                             conn.commit();
                       }
                 }
           } catch (SQLException e) {
                 e.printStackTrace();
                 try {
                       conn.rollback();
                 } catch (SQLException e1) {
                       e1.printStackTrace();
                 }
           }finally{
                 try {
                       selectLoginNameOfJL_result.close();
                       selectLoginNameOfJL_ps.close();
                       updatePasswordOfJL_ps.close();
                       conn.close();
                 } catch (SQLException e) {
                       e.printStackTrace();
                 }
           }
     }
}
