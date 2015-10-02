<%--
  Created by IntelliJ IDEA.
  User: Eduard Luhtonen
  Date: 02/10/15
--%>

<html>
<head>
    <title>Login Page</title>
    <meta name="layout" content="main">
</head>
<body>
    <div class="body">
        <g:if test="${flash.message}">
            <div class="message">
                ${flash.message}
            </div>
        </g:if>
        <p>Welcome to Your ToDo List. Login below</p>
        <g:form action="handleLogin" method="post">
            <span class="nameClear"><label for="login">Sign In:</label></span>
            <g:textField id="login" name="userName" value="${user?.userName}"/><br/>
            <div class="buttons">
                <span class="button">
                    <g:actionSubmit value="Login" action="handleLogin"/>
                </span>
            </div>
        </g:form>
    </div>
</body>
</html>