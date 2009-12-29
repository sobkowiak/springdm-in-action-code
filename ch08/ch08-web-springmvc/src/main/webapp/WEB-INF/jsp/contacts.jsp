<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>

	<c:forEach items="${contacts}" var="contact">
		- <c:out value="${contact.id}"/>: <c:out value="${contact.firstname}"/> <c:out value="${contact.lastname}"/><br/>
	</c:forEach> 
</body>
</html>