<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Collab-Todo</title>
    <style type="text/css" media="screen">
    </style>
</head>

<body>
<div id="page-body" role="main">
    <h1>Welcome to Collab-Todo</h1>

    <p>Welcome to the CollabTodo application.  This application was built as part of the Apress
    Book, "Beginning Groovy, Grails and Griffon." Functionally, the application is a collaborative
    "To-Do" list that allows users and their buddies to jointly manage "To-Do" tasks.</p><br/>

    <p>Building the Collab-Todo application is used to walk the user through using Grails 3 to
    build an application.  Below is a list of controllers that are currently deployed in this
    application. Click on each to execute its default action:</p>

    <div id="controller-list" role="navigation">
        <h2>Available Controllers:</h2>
        <ul>
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                <li class="controller"><g:link
                        controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
            </g:each>
        </ul>
    </div>
</div>
</body>
</html>
