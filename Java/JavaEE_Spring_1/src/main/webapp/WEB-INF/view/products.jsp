<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product List</title
</head
<body>
<%--@elvariable id="productList" type="ru.gb.spring1.controller"--%>
<h1>Product list: </h1>
<ul>
    <c:forEach var="product" items="${productList}">
        <%--<c:url var="viewUrl" value="/products/ + ${product.id}"/>--%>
    <li>
        <a href="${viewUrl}"value=View</a>
        <br>
        Product name: ${product.name}
        <br>
        Cost: ${product.cost}
        <br>
    </li>
    </c:forEach>
</ul>

</body>
</html>