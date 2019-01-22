<%--
  Created by IntelliJ IDEA.
  User: randy
  Date: 2018/12/6
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="lib.Student" %>
<html>
<head>
    <title>Your Grade</title>
</head>
<%


    if(!request.getParameter("pagecommand").equals("")) {
        String inputcommand = request.getParameter("pagecommand");
        String[] command = inputcommand.split(" ");
        Student assignmentEditor = new Student("CourseEditor", 0000, "Female", "NULL", "USA");
        String ans = assignmentEditor.checkAssignmentGrade(Integer.parseInt(command[0]), command[1]);


%>
<body>
<h1>Hello, Huskies!!!</h1>
<form action = index.jsp>
    <button style="width: 200px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" value="submit">Home</button>
</form>
<h3>Your grade is :</h3>
<%=ans%>
<%}%>







</body>
</html>
