<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create product</title
</head
<body>
<%--@elvariable id="product" type="ru.gb.spring1.entity"--%>
<form:form action="create" modelAttribute="product">
Product Name: <form:input path="name"/>
<br>
Cost: <form:input path="cost"/>
<br>
<input type="submit" value="Save"/>
</form:form>

</body>
</html>