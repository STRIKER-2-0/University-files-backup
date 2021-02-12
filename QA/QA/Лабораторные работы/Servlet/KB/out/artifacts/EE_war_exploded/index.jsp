<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Anna--%>
<%--  Date: 21.04.2019--%>
<%--  Time: 12:06--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <title>Calculator</title>
  <style>
    div {
      margin: 20% 30%;
      height: 150px;
      width: 400px;
      padding: 4%;
    }
  </style>
</head>
<body>
<form name="Calculator" action="answer">
  <div>
    <b>Enter the first number:</b>
    <input type = "text" name="n1"/><br><br>
    <b> Select operator:</b>
    <b> <select name="operator">
      <option>+</option>
      <option>-</option>
      <option>*</option>
      <option>/</option>
    </select>
    </b><br><br>
    <b>Enter the second number:</b>
    <input type = "text" name="n2"/><br><br>

    <input type="submit" name="ok" value="CALCULATE"/>
    <input type="reset" name="neOk" value="RESET"/><br><br>

    <b>The result of the operation is <span id="result">${result}</span></b>
  </div>
</form>
</body>
