<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<center>
<meta charset="UTF-8">
<h1 align="center"><strong>Крестики нолики</strong> </h1>
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
    ${win}
    <br>
    <input type="submit" align="center" value="Походить" >
</form>
</center>
</body>
</html>
