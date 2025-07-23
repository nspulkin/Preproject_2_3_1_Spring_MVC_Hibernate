<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New User</title>
</head>
<body>

<h2>Add New User</h2>

<form:form method="post" modelAttribute="user">
    <div>
        <label for="name">Name:</label>
        <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>

    <div>
        <label for="age">Age:</label>
        <form:input path="age"/>
        <form:errors path="age" cssClass="error"/>
    </div>

    <div>
        <label for="email">Email:</label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Submit"/>
    </div>
</form:form>

</body>
</html>
</html>
