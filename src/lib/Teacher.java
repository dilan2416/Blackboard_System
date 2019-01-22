package lib;
import java.sql.*;
public class Teacher extends User{
    String userName;
    String userPasswd;
    String dbName;
    String subject;
    public Teacher(){
        userName="root";
        userPasswd="123456";
        dbName="INFO5100";
    }
    void setSubject(String subject) {
        this.subject = subject;
    }

    String getSubject() {
        return this.subject;
    }
    public void addAssignment(int course_Id,int id, String assi_name, String content){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn= DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS `" + assi_name +"`(\n" +
                    "   `student_id` INT UNSIGNED AUTO_INCREMENT,\n" +
                    "   `content`VARCHAR(100) NOT NULL,\n" +
                    "   `grade` VARCHAR(100) NOT NULL,\n" +
                    "   PRIMARY KEY (  `student_id`  )\n" +
                    "   )ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            stmt.executeUpdate(sql);
            sql = "insert into `"+ course_Id +"_assignmentlist` values ('"+id+"', '"+assi_name+"', '"+content+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAssignment(int course_Id, int assignment_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn= DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "delete from `"+ course_Id +"_assignmentlist` where assignment_id = " + assignment_id;
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gradeAssignment(int stu_id, String assignment_name, int grade){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn= DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql = "update `"+ assignment_name +"`set grade ='"+ grade + "'where student_id = " + stu_id;
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
