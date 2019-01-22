<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<html>
<head>
    <title>Student</title>
</head>
<body>
<h1>Hello, Huskies!!!</h1>
<form action = index.jsp>
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Home</button>
</form>
<%
    String userName="root";
    String userPasswd="123456";
    String dbName="INFO5100";
    String tableName="courses";
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
    Connection conn=DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();

    String sql="SELECT * FROM "+tableName;
    ResultSet rs = stmt.executeQuery(sql);

%>
<h3>Course List</h3>
<table border="1" width="100%">
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Teacher</th>
        <th>Max Number</th>
        <th>Now Number</th>
        <th>Course Type</th>
        <th>Location/URL</th>
        <th>Time</th>
    </tr>
    <%
        while(rs.next()) {
    %>

    <tr>
        <td><%=rs.getString(1) %></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
        <td><%=rs.getString(4) %></td>
        <td><%=rs.getString(5) %></td>
        <td><%=rs.getString(6) %></td>
        <td><%=rs.getString(7) %></td>
        <td><%=rs.getString(8) %></td>
    </tr>

    <%}
        rs.close();
        stmt.close();
        conn.close();
    %>
</table>
<br>


<form action="AfterEditTeacher.jsp" method="get">
    <label style="font-size: 16px;">Please input your command:</label>
    <input style="width: 350px; height: 30px;font-size: 16px" name="pagecommand" type="text">
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Submit</button>
</form>
<p>To browse your assignment list, please input "browse 5100"</p>

<%out.print("OK! Database Query Success！");%>

</body>
</html>