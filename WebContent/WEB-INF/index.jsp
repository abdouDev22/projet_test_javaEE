<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
 <tr>
 <th>Nom</th>
 <th>Prenom</th>
 <th>Login</th>
 <th>Role</th>
 <th>Action</th>
  </tr>
  
  <c:forEach items="${users }" var="user">
  
  <tr>
    <td>${user.nom }</td>
    <td>${user.prenom }</td>
    <td>${user.login } </td>
    <td>${user.role } </td>
    <td> 
    <a  href="/TPJSTL2/user?page=edit&id=${user.id }">Edit</a>
    <a  href="/TPJSTL2/user?page=update&id=${user.id }">Update</a>
    <a  href="/TPJSTL2/user?page=delete&id=${user.id }">Supprimer</a>
    
    </td>
  </tr>
  
  </c:forEach>



</table>


</body>
</html>