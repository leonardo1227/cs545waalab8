<%--
  Created by IntelliJ IDEA.
  User: leona
  Date: 4/12/2019
  Time: 12:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
    <style type="text/css">@import url("<spring:url value="/resources/css.css"/>");</style>
    <script type="text/javascript" src="<spring:url value="/resources/js.js"/>"></script>
<head>
    <title>Employee Form</title>
</head>
<body>
    <h1>Add Employee</h1>
    <form id="employeeForm" method="post">
        <table cellpadding="0" cellspacing="0" border="1" class="GridOne">
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName" id="firstName" value=""></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName" id="lastName" value=""></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email" value=""></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="button" value="Ajax Submit" onclick="submitEmployeeForm();"></td>
            </tr>
        </table>
    </form>

    <div id="errors" style="display:none" >
    </div>

    <div id="formInput" style="display:none" > </div>

</body>
</html>
