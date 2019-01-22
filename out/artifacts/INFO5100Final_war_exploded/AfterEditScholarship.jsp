<%--
  Created by IntelliJ IDEA.
  User: randy
  Date: 2018/12/7
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="lib.FinanceManager" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(!request.getParameter("pagecommand").equals("")){
        String inputcommand = request.getParameter("pagecommand");
        String [] command = inputcommand.split(" ");
        FinanceManager fm = new FinanceManager();
        if (command[0].equals("add") && command[1].equals("StatusBasedScholarship")){
            fm.addStatusScholar(command[2], command[3], command[4]);
        }
        else if(command[0].equals("add")&& command[1].equals("MeritBasedScholarship")){
            fm.addMeritScholar(command[2], Double.parseDouble(command[3]), command[4]);
        }
        else if(command[0].equals("delete")){
            fm.deleteScholar(command[1],command[2]);
        }
        else if(command[0].equals("attach")){
            fm.attachScholarship(Integer.parseInt(command[1]),command[2]);
        }
    }

%>
<h1>Hello, Huskies!!!</h1>
<form action = index.jsp>
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Home</button>
</form>
<h3>Status Based Scholarship List</h3>
<table border="1" width="100%">
    <tr>
        <th>Scholarship Name</th>
        <th>status</th>
        <th>Content</th>


    </tr>
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
        String sql="SELECT * FROM StatusBasedScholarship";
        ResultSet rs = stmt.executeQuery(sql);
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
</body>
</html>
