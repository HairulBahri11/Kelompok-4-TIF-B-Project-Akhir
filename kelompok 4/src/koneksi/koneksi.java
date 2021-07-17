package koneksi;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class koneksi {   
   public static Connection koneksi;
   public static Connection GetConnection() throws SQLException{
        if (koneksi==null) {
        new Driver();
        
    koneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/puskesmas","root","");

        }
    return koneksi;
    }
 
}
