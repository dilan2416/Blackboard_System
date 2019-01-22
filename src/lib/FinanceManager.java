package lib;
import java.sql.*;
public class FinanceManager {
    String userName;
    String userPasswd;
    String dbName;
    public FinanceManager(){
        userName="root";
        userPasswd="123456";
        dbName="INFO5100";
    }
    public void addStatusScholar(String name, String status ,String content){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn=DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql="insert into StatusBasedScholarship values ('"+name+"','"+status+"','"+content+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMeritScholar(String name, double gpa ,String content){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn=DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql="insert into MeritBasedScholarship values ('"+name+"','"+gpa+"','"+content+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteScholar(String scholarship_type, String name){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn=DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql="DELETE FROM `" + scholarship_type +"` WHERE scholarship_name = '"+name+"'" ;
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void attachScholarship(int id, String scholarship_type){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn= DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "update students set scholarship = `" +scholarship_type +"`where id= '"+id+"'";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
