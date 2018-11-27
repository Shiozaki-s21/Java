import java.sql.*;

public class Recommend {
    public static void main(String[] args) throws Exception {
      
        String servername = "localhost";
        String databasename   = "ebookshop";
        String user = "root";
        String password = "password"; //or mysql
        String serverencoding = "UTF-8";
        String url =  "jdbc:mysql://localhost/" + databasename;
        Connection con = null;
        try{
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            con = DriverManager.getConnection( url, user, password );
            System.out.println( "Connected...." );
            Statement st = con.createStatement();
            String sqlStr = "SELECT * FROM ebookshop";
            ResultSet result = st.executeQuery( sqlStr );
            while( result.next() ) {
                String str1 = result.getString("id");
                String str2 = result.getString("title");
                String str3 = result.getString("author");
                String str4 = result.getString("price");
                String str5 = result.getString("qty");
                System.out.println("id: " + str1 + "title: " + str2 + "author: " + str3 + "price: " + str4 + "qty" + str5);
    
            }
            result.close();
            st.close();

            con.close();
        } catch(SQLException e) {
            System.out.println("Connection Failed..." + e.toString());

        } catch(ClassNotFoundException e) {
            System.out.println("ドライバを読み込めませんでした " + e);
        } finally {
            try {
                if( con != null ){ 
                    con.close();
                }
            } catch(Exception e) {
                System.out.println("Exception2! :" + e.toString());                
                throw new Exception();
            }
        }   
    }
}