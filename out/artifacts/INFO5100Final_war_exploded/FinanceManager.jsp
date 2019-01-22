<%--
  Created by IntelliJ IDEA.
  User: randy
  Date: 2018/12/7
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<html>
<head>
    <title>Finance Manager</title>
</head>
<body>
<%
    String userName="root";
    String userPasswd="123456";
    String dbName="INFO5100";
    String tableName="students";
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
<h1>Hello, Huskies!!!</h1>
<form action = index.jsp>
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Home</button>
</form>
<h3>Student List</h3>
<table border="1" width="100%">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>gender</th>
        <th>major</th>
        <th>Country</th>
        <th>GPA</th>
        <th>Scholarship</th>

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
        <td><%=rs.getString(6)%></td>
        <td><%=rs.getString(7)%></td>    </tr>
    <%}
        sql="SELECT * FROM StatusBasedScholarship";
        rs = stmt.executeQuery(sql);
    %>
</table>
<h3>Status Based Scholarship List</h3>
<table border="1" width="100%">
    <tr>
        <th>Scholarship Name</th>
        <th>status</th>
        <th>Content</th>

    </tr>
    <%
        while(rs.next()) {
    %>

    <tr>
        <td><%=rs.getString(1) %></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
    </tr>

    <%}
        sql="SELECT * FROM MeritBasedScholarship";
        rs = stmt.executeQuery(sql);
    %>
</table>
<h3>Merit Based Scholarship List</h3>
<table border="1" width="100%">
    <tr>
        <th>Scholarship Name</th>
        <th>GPA requirement</th>
        <th>Content</th>

    </tr>
    <%
        while(rs.next()) {
    %>

    <tr>
        <td><%=rs.getString(1) %></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
    </tr>

    <%}
        rs.close();
        stmt.close();
        conn.close();
    %>
</table>
<form action="AfterEditScholarship.jsp" method="get">
    <label style="font-size: 16px;">Please input your command:</label>
    <input style="width: 350px; height: 30px;font-size: 16px" name="pagecommand" type="text">
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Submit</button>
</form>
<p>To add scholarship, please input "add MeritBasedScholarship Goodgrade 3.5 15%tuitiondiscount"</p>
<p>To delete scholarship, please input "delete MeritBasedScholarship Goodgrade"</p>
</body>
</html>
