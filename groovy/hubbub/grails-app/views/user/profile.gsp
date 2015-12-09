<%--
  Created by IntelliJ IDEA.
  User: luhtonen
  Date: 09/12/15
  Time: 12:12
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Profile</title>
    <meta name="layout" content="main">
</head>
<body>
    <div class="profilePic">
        <g:if test="${profile.photo}">
            <img src="${createLink(controller: 'image', action: 'renderImage', id: profile.user.loginId)}"
        </g:if>
        <br/>
        <p>Profile for <strong>${profile.fullName}</strong></p>
        <p>Bio: ${profile.bio}</p>
    </div>
</body>
</html>