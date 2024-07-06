<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/TPJSTL2/user?page=update" method="post">
<label>Nom</label>
<input type="text" name="nom" value="${user.nom }"> <br>
<label>Prenom</label>
<input type="text" name="prenom" value="${user.prenom }"> <br>
<label>Login</label>
<input type="text" name="login" value="${user.login }"> <br>
<label>Passord</label>
<input type="password" name="password"> <br>

<input type="submit" value="Enregistrer">

</form>
</body>
</html>