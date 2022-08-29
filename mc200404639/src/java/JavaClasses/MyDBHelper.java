
package JavaClasses;
import java.sql.*;

public class MyDBHelper {
    public static String PATH = "C:\\Users\\Aziz\\Desktop\\cs506\\mc200404639\\web\\assets\\";
    public static String FILE = "mc200404639.accdb";

    public MyDBHelper() {
    }
    
    public static Connection getConnection()throws ClassNotFoundException, SQLException 
    {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");   
        String url = "jdbc:ucanaccess://" + PATH + "" + FILE;
        Connection con = DriverManager.getConnection(url);
        return con;
    }
    
    public static boolean inserVoterRecord(String id, String vote)
    {
        int count = 0;
        try{
            Connection con = getConnection();
            String sql = "INSERT INTO MyDB (StdId, Party) VALUES(?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, vote);
            count = st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(count >= 1)
            return true;
        else
            return false;
    }
    
    public static boolean retriveVoterRecord(String id)
    {
        boolean isSubmitted = false;
        Voter std = new Voter();
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM MyTable WHERE StdId = '" + id + "'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
                String sId = rs.getString("StdId");
                String Party = rs.getString("Party");
                std.setStdID(sId);
                std.setCandidate(Party);
                isSubmitted = true;
            }
            rs.close();
            st.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return isSubmitted;
    }
    
    public static Voter retriveData(String id)
    {
        Voter std = new Voter();
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM MyTable WHERE StdId = '" + id + "'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
                String sId = rs.getString("StdId");
                String Party = rs.getString("Party");
                std.setStdID(sId);
                std.setCandidate(Party);
            }
            rs.close();
            st.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return std;
    }
}
