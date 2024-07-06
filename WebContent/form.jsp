<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/TPJSTL2/user" method="post">
<label>Nom</label>
<input type="text" name="nom"> <br>
<label>Prenom</label>
<input type="text" name="prenom"> <br>
<label>Login</label>
<input type="text" name="login"> <br>
<label>Passord</label>
<input type="password" name="password"> <br>
<label>Role</label>
<select name="role" >
  <option value="admin">Admin</option>
  <option value="user"> User </option>
</select>

<input type="submit" value="Enregistrer">

</form>
</body>
</html>