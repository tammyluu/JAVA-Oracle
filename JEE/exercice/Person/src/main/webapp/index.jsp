<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Liste des personnes</title>
</head>
<body>
<div >
  <h1 >Liste des personnes</h1>
  <table >
    <thead >
    <tr>
      <th>#</th>
      <th>Nom</th>
      <th>Prénom</th>
      <th>Âge</th>
    </tr>
    </thead>
    <tbody>
    <!-- Parcours de la liste des personnes -->
    <c:forEach var="person" items="${persons}">
      <tr>
        <td>${personIndex + 1}</td>
        <td>${person.lastName}</td>
        <td>${person.firstName}</td>
        <td>${person.age}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>