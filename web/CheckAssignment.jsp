<%--
  Created by IntelliJ IDEA.
  User: randy
  Date: 2018/12/6
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="lib.Teacher" %>
<html>
<head>
    <title>Check Assignment</title>
</head>
<body>
<%
    String userName="root";
    String userPasswd="123456";
    String dbName="INFO5100";
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
    Connection conn=DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();

    String inputcommand = request.getParameter("pagecommand");
    String [] command = inputcommand.split(" ");
    ResultSet rs = null;
    if(command[0].equals("grade")){
        Teacher assignmentEditor = new Teacher();
        assignmentEditor.gradeAssignment(Integer.parseInt(command[1]),command[2],Integer.parseInt(command[3]));
        String sql = "select * from " + command[2];
        rs = stmt.executeQuery(sql);
    }
    else{
        String sql = "select * from " + command[0];
        rs = stmt.executeQuery(sql);
    }

%>
<h1>Hello, Huskies!!!</h1>
<form action = index.jsp>
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Home</button>
</form>
<h3>Assignment Submitted List</h3>
<table border="1" width="100%">
    <tr>
        <th>Student ID</th>
        <th>Content</th>
        <th>Grade</th>
    </tr>

<%
    while(rs.next()) {
%>
    <tr>
        <td><%=rs.getString(1) %></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
    </tr>
    <%
        }
        stmt.close();
        conn.close();
        rs.close();
    %>
</table>
<form action="CheckAssignment.jsp" method="get">
    <label style="font-size: 16px;">Please grade for assignment:</label>
    <input style="width: 350px; height: 30px;font-size: 16px" name="pagecommand" type="text">
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Submit</button>
</form>
<p>To grade assignment, please input "grade 2014160083 zooandanimal 90"</p>

</body>
</html>
