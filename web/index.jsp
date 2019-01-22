<%--
  Created by IntelliJ IDEA.
  User: randy
  Date: 2018/11/22
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  import= "java.util.*" language="java"  %>
<link rel="stylesheet" href="commons.css" />
<html>
<head>
  <title>BlackBoard</title>
</head>
<body style="background-image:url('pic01.jpg');">
  <div align = "center" style="background-color: #000000;opacity:0.5;margin: 20px auto; width: 80%; height: 80%; border-radius: 5px">
    <div  style=" margin-top: 100; height: 60px;margin: 100px auto;">
      <label style="color: cornsilk; font-size: 60px;" >Hello, Huskies!!!</label>
    </div>
      <div align="center">
          <button style="text-align: center;width: 160px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" onclick = "window.location.href = 'student.jsp'" >Student</button>
          <br>
          <button style="text-align: center;width: 160px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" onclick = "window.location.href = 'teacher.jsp'" >Teacher</button>
          <br>
          <button style="text-align: center;width: 160px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" onclick="window.location.href = 'FinanceManager.jsp'" >Finance Manager</button>
          <br>
          <button style="text-align: center;width: 160px;height: 30px;font-size: 16px;border-radius: 5px;margin: 10px;" onclick="window.location.href = 'CourseManager.jsp'" >Course Manager</button>
          <br>
      </div>
  </div>
</body>
</html>
