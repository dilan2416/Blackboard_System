<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="lib.Student" %>
<html>
<head>
    <title>Assignment</title>
</head>
<body>
<%
    String userName="root";
    String userPasswd="123456";
    String dbName="INFO5100";
    String tableName="";
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
    Connection conn=DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();
    String sql="SELECT * FROM "+tableName;
    ResultSet rs = null;
    if(!request.getParameter("pagecommand").equals("")){
        String inputcommand = request.getParameter("pagecommand");
        String [] command = inputcommand.split(" ");
        if(command[0].equals("enter")){
            sql="SELECT * FROM "+command[1] + "_assignmentlist";
            rs = stmt.executeQuery(sql);
        }
        else if(command[0].equals("submit")){
            Student assignmentEditor = new Student("assignmentEditor", 0000,"Female", "NULL","USA");
            assignmentEditor.submitAssignment(Integer.parseInt(command[2]),command[3],command[4]);
            sql = "SELECT * FROM "+ command[1] + "_assignmentlist";
            rs = stmt.executeQuery(sql);
        }

    }
    else if(request.getParameter("pagecommand").equals("")){
        tableName = "";
    }
%>
<h1>Hello, Huskies!!!</h1>
<form action = index.jsp>
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Home</button>
</form>
<h3>Assignment List</h3>
<table border="1" width="100%">
    <tr>
        <th>Assignment ID</th>
        <th>Assignment Name</th>
        <th>Assignment Content</th>
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
<br>

<br>
<form action="Assignment.jsp" method="get">
    <label style="font-size: 16px;">Please input your command:</label>
    <input style="width: 350px; height: 30px;font-size: 16px" name="pagecommand" type="text">
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Submit</button>
</form>
<p>To submit assignment of this course, please input "submit 5100 2014160075 zooandanimal YourAnswerHere"</p>
<form action="Assignment.jsp" method="get">
    <label style="font-size: 16px;">Please input your course ID:</label>
    <input style="width: 350px; height: 30px;font-size: 16px" name="pagecommand" type="text">
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Enter the Assignment</button>
</form>
<p>To view assignment of othere course,please input "enter 5100"</p>
<form action="Grade.jsp" method="get">
    <label style="font-size: 16px;">Please input your Assignment name:</label>
    <input style="width: 350px; height: 30px;font-size: 16px" name="pagecommand" type="text">
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Check your grade</button>
</form>
<p>To check your assignment grade,please input "2014160075 zooandanimal"</p>
<%out.print("OK! Database Query Success！");%>

</body>
</html>