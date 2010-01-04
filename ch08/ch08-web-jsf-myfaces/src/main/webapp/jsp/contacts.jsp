<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- JSF taglibs --%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%-- @ taglib uri="/WEB-INF/html_basic.tld" prefix="h"%>
<%@ taglib uri="/WEB-INF/jsf_core.tld" prefix="f" --%>

<f:view>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

	</head>

	<body lang="fr">

		<h:form>
			<h:dataTable value="#{contactManagerBean.contacts}"  var="contact">
    		<h:column>
      			<f:facet name="header">
      				<h:outputText value="Id" />
      			</f:facet>
      			<h:outputText value="#{contact.id}" />
    		</h:column>
    		<h:column>
      			<f:facet name="header">
      				<h:outputText value="First Name" />
      			</f:facet>
      			<h:outputText value="#{contact.firstname}" />
    		</h:column>
    		<h:column>
      			<f:facet name="header">
      				<h:outputText value="Last Name" />
      			</f:facet>
      			<h:outputText value="#{contact.lastname}" />
    		</h:column>
  			</h:dataTable>
		</h:form>
	</body>
	</html>
</f:view>