
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<body>
<meta charset="UTF-8">
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
<center>
<h1 align="center"><strong><spring:message code="label.title"/></strong> </h1>
<form action="/controller/player" method="get" name="player">
<table align="center", border="2", cellspacing="2", cellpadding="10", width="50">
    <tr>
        <td><input type="text" name="0"></td>
        <td><input type="text" name="1"></td>
        <td><input type="text" name="2"></td>
    </tr>
    <tr>
        <td><input type="text" name="3"></td>
        <td><input type="text" name="4"></td>
        <td><input type="text" name="5"></td>
    </tr>
    <tr>
        <td><input type="text" name="6"></td>
        <td><input type="text" name="7"></td>
        <td><input type="text" name="8"></td>
    </tr>

</table>
    <br>
    <spring:message code="${win}"/>
    <br>
    <input type="submit" align="center" value="<spring:message code="label.submit"/>" >
</form>
</center>
</body>
</html>
