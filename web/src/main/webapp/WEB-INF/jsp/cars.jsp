<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Cars</title>
    </head>
    <body>
        <h1>Page with cars:</h1>

        <table>
            <tr>
                <th>id: </th>
                <th>model: </th>
            </tr>
            <c:forEach var="car" items="${carsList}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.model}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
