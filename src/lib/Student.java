package lib;
import java.sql.*;

public class Student extends User{
    String major;
    String status;
    String userName;
    String userPasswd;
    String dbName;
    public Student(String name, int id, String gender,  String major, String status) {
        setName(name);
        setID(id);
        setGender(gender);
        setMajor(major);
        setStatus(status);
        userName="root";
        userPasswd="123456";
        dbName="INFO5100";
    }

    void setMajor(String major) {
        this.major = major;
    }

    String getMajor() {
        return this.major;
    }

    void setStatus(String country) {
        this.status = country;
    }

    String getStatus() {
        return this.status;
    }

    public void addCourse(String stu_id, String course_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn= DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "update courses Set now_num = now_num + 1 where course_id=" + Integer.parseInt(course_id);
            stmt.executeUpdate(sql);
            sql="SELECT * FROM courses WHERE course_id = " + Integer.parseInt(course_id);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                sql="insert into `"+Integer.parseInt(stu_id)+"` values ('"+rs.getString(1)+"','"+rs.getString(2)+ "'," +
                        "'"+rs.getString(3)+"','"+rs.getString(7)+"', '"+rs.getString(8)+"')";
                stmt.executeUpdate(sql);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(String stu_id, String course_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn= DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "update courses Set now_num = now_num - 1 where course_id=" + Integer.parseInt(course_id);
            stmt.executeUpdate(sql);
            sql="DELETE FROM `" + Integer.parseInt(stu_id) +"` WHERE course_id = " + Integer.parseInt(course_id);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void submitAssignment(int stu_id, String assignment_name, String content){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String grade = "Not Graded";
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn= DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "insert into `"+ assignment_name +"` values ('"+stu_id+"', '"+content+"', '"+grade+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkAssignmentGrade(int stu_id, String assignment_name){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn= DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "select * from`" + assignment_name + "`where student_id = " + stu_id;
            rs = stmt.executeQuery(sql);

            if(rs.next()){
                String ans = rs.getString(3);
                rs.close();
                stmt.close();
                conn.close();
                return ans;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";

    }
}