<%@page import="db.QuickDbTest"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.tomcat.dbcp.dbcp2.BasicDataSource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style> body{font-family:  sans-serif;}
    </style>
  </head>
  <body>
    <%
      List<String> names = QuickDbTest.getNames();
    %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h1>Dream Team</h1>
  <ul>
    <c:forEach var="name" items="<%=names%>">
      <li><c:out value="${name}"/></li>
    </c:forEach>
  </ul>
</body>

</html>
