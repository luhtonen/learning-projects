<%--
  Created by IntelliJ IDEA.
  User: luhtonen
  Date: 23/11/15
  Time: 23:12
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Results</title>
    <meta name="layout" content="main"/>
</head>
<body>
    <h1>Results</h1>
    <p>
        Searched ${totalUsers} records for items matching <em>${term}</em>.
        Found <strong>${users.size()}</strong> hits.
    </p>
    <ul>
        <g:each var="user" in="${users}">
            <li>${user.loginId}</li>
        </g:each>
    </ul>
    <g:link action="search">Search Again</g:link>
</body>
</html>