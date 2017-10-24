<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<table>
    <thead style="background-color: #b39b89;">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Author</th>
        <th width="120">Description</th>
        <th width="60">ISBN</th>
        <th width="10">Print Year</th>
        <th width="120">Read Already</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookTitle}</td>
            <td>${book.bookAuthor}</td>
            <td>${book.description}</td>
            <td>${book.isbn}</td>
            <td>${book.printYear}</td>
            <td>${book.readAlready}</td>
            <td><a href="<c:url value='/edit/${book.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${book.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
