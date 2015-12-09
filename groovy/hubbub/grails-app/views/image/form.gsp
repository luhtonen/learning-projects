<%--
  Created by IntelliJ IDEA.
  User: luhtonen
  Date: 09/12/15
  Time: 12:03
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload Image</title>
    <meta name="layout" content="main">
</head>
<body>
    <h1>Upload an image</h1>
    <g:uploadForm action="upload">
        User id:
        <g:select name="loginId" from="${userList}" optionKey="loginId" optionValue="loginId"/>
        <p/>
        Photo: <input name="photo" type="file"/>
        <g:submitButton name="upload" value="Upload"/>
    </g:uploadForm>
</body>
</html>