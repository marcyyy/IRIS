package iris;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class IRIS_Connection {
    public static Connection getConnection()
    {	
        Connection con = null;
            try
            {	Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/irisdbms","root", "");
            }
            catch (Exception ex)
            {	
                System.out.println(ex.getMessage());
            }
            return con;
    }
}
