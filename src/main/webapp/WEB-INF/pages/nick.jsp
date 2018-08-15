
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
<center>
<meta charset="UTF-8">
<h1 align="center"><strong><spring:message code="label.title"/></strong> </h1>
<form action="/controller/player" method="get" name="player">
    <table align="center", border="2", cellspacing="2", cellpadding="10", width="50">
        <tr>
            <td><input type="text" name="0" value="${p0}"></td>
            <td><input type="text" name="1" value="${p1}"></td>
            <td><input type="text" name="2" value="${p2}"></td>
        </tr>
        <tr>
            <td><input type="text" name="3" value="${p3}"></td>
            <td><input type="text" name="4" value="${p4}"></td>
            <td><input type="text" name="5" value="${p5}"></td>
        </tr>
        <tr>
            <td><input type="text" name="6" value="${p6}"></td>
            <td><input type="text" name="7" value="${p7}"></td>
            <td><input type="text" name="8" value="${p8}"></td>
        </tr>

    </table>
    <br>
    <spring:message code="${win}"/>
    <br>
    <input type="submit" align="center" value="Походить" >
</form>
    <a href="/index.jsp"><spring:message code="label.restart"/></a>
</center>
</body>
</html>