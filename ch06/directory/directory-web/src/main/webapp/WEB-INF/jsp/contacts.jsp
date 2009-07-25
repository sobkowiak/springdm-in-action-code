<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach items="${contacts}" var="contact">
	<p>${contact.firstname} ${contact.lastname}</p>
</c:forEach>