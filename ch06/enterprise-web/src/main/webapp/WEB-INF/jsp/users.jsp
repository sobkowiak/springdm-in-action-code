<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach items="${users}" var="user">
	<p>${user.firstname} ${user.lastname}</p>
</c:forEach>