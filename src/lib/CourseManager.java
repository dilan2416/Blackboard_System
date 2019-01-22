package lib;
import java.sql.*;
import java.sql.SQLException;

public class CourseManager extends User {
    String userName;
    String userPasswd;
    String dbName;
    public CourseManager() {
        userName="root";
        userPasswd="123456";
        dbName="INFO5100";
    }

    public void addCourse(int id, String name, String teacher, int max_num, int now_num, String course_type, String location, String time) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn=DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql="insert into courses values ('"+id+"','"+name+"','"+teacher+"','"+max_num+"', '"+now_num+"','"+course_type+"','"+location+"','"+time+"')";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS " + id + "_assignmentlist" +"(\n" +
                    "   `student_id` INT UNSIGNED AUTO_INCREMENT,\n" +
                    "   `content`VARCHAR(100) NOT NULL,\n" +
                    "   `grade` VARCHAR(100) NOT NULL,\n" +
                    "   PRIMARY KEY (  `student_id`  )\n" +
                    "   )ENGINE=InnoDB DEFAULT CHARSET=utf8;";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
            Connection conn=DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql="delete from courses where course_id = " + id;
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(int id, int newid, String name, String teacher, int max_num, int now_num,String course_type, String location, String time){
        deleteCourse(id);
        addCourse(newid,name,teacher,max_num,now_num,course_type,location,time);
    }



}
