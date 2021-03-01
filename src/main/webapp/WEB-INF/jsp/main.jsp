<%@ page import="data.Car" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
    </head>
<body>

<h1>Car Dealer Shop</h1>
<table><tr><th>NAME</th><th>TYPE</th><th>PRICE</th><th>DESCRIPTION</th><th>PICTURE</th></tr>
    <c:forEach items="cars" var="c">
        <tr>
            <td>${c.name}</td>
            <td>
                <c:if test="${c.type == 1}">
                    SEDAN
                </c:if>
                <c:if test="${c.getType() == 2}">
                    HATCHBACK
                </c:if>
                <c:if test="${c.getType() == 3}">
                    CROSSOVER
                </c:if>
            </td>
            <td><h2>${c.getPrice()}</h2> <h4>USD</h4></td>
            <td>${c.getDescription()}</td>
            <td><a href='/demo_war_exploded/detail?id=${c.getId()}'><img style='width: 100px;' src='${c.getPicture()}' alt='No Picture'/></a></td>
            <td><h1>Options:</h1>
                <form action='/demo_war_exploded/option' method='GET'>
                    <input type='hidden' name='carId' value='${c.getId()}'/>
                    <input type='submit' value='Edit options'/>
                </form>
                <c:forEach var="o" items="${c.getOptions()}">
                    ${o.toString()}&nbsp;
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>");
<form action='/demo_war_exploded/add' method='GET'>
    <input type='submit' value='Add New Car'/>
</form>
<form action='/demo_war_exploded/index.jsp' method='GET'>
    <input type='submit' value='To First Page'/>
</form>
</body>
</html>