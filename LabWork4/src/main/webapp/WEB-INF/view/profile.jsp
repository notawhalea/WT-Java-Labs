
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Profile | Online-shop</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>

<div class="container">
    <c:if test="${sessionScope.user == null}">
        <div class="row justify-content-center">
            <div class="alert alert-danger fade show " role="alert">
                <fmt:message bundle="${loc}" key="language.noRights"/>
            </div>
        </div>
    </c:if>
    <c:if test="${sessionScope.user != null}">
        <div class="p-3 p-md-4 border rounded-3 my-sm-3">
            <div class="col"></div>
            <div class="col-6">
                <h2><fmt:message bundle="${loc}" key="language.profile"/></h2>
            </div>
            <table class="table">
                <tr>
                    <td width="25px">
                        <h4 class="text-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                                 class="bi bi-person-circle" viewBox="0 0 16 16">
                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path fill-rule="evenodd"
                                      d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                            </svg>
                        </h4>
                    </td>
                    <td width="300px">
                        <h4 class="text-primary">
                            <fmt:message bundle="${loc}" key="language.name"/>:
                        </h4>
                        <h4 class="text-primary">
                            <fmt:message bundle="${loc}" key="language.surname"/>:
                        </h4>

                    </td>
                    <td><h4><c:out value="${userInformation.name}"/></h4>
                        <h4><c:out value="${userInformation.surname}"/></h4>
                    </td>
                </tr>
                <tr>
                    <td width="25px">
                        <h4 class="text-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                                 class="bi bi-telephone-fill" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                      d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                            </svg>
                        </h4>
                    </td>
                    <td width="300px"><h4 class="text-primary"><fmt:message bundle="${loc}"
                                                                            key="language.mobilePhone"/>:</h4></td>
                    <td><h4><c:out value="${userInformation.phone}"/></h4></td>
                </tr>
                <tr>
                    <td width="25px">
                        <h4 class="text-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                                 class="bi bi-envelope" viewBox="0 0 16 16">
                                <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2zm13 2.383-4.758 2.855L15 11.114v-5.73zm-.034 6.878L9.271 8.82 8 9.583 6.728 8.82l-5.694 3.44A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.739zM1 11.114l4.758-2.876L1 5.383v5.73z"/>
                            </svg>
                        </h4>
                    </td>
                    <td width="300px"><h4 class="text-primary"><fmt:message bundle="${loc}"
                                                                            key="language.emailAddress"/>:</h4></td>
                    <td><h4>${sessionScope.user.email}</h4></td>
                </tr>
            </table>
        </div>
    </c:if>
</div>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>