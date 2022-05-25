<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <div>
        <label for="isbn">ISBN</label>
        <form:input path="isbn" id="isbn" type="text"/>
        <form:errors path="isbn"/>
    </div>
    <div>
        <label for="title">Title</label>
        <form:input path="title" id="title" type="text"/>
        <form:errors path="title"/>
    </div>
    <div>
        <label for="author">Author</label>
        <form:input path="author" id="author" type="text"/>
        <form:errors path="author"/>
    </div>
    <div>
        <label for="publisher">Publisher</label>
        <form:input path="publisher" id="publisher" type="text"/>
        <form:errors path="publisher"/>
    </div>
    <div>
        <label for="type">Type</label>
        <form:input path="type" id="type" type="text"/>
        <form:errors path="type"/>
    </div>
    <div>
        <input type="submit">
    </div>
    <form:errors path="*"/>
</form:form>
</body>
</html>
