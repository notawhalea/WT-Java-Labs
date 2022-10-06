<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>View orders | Online-shop</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>

<c:if test="${sessionScope.role.name != 'admin'}">
    <div class="container">
        <div class="row justify-content-center">
            <div class="alert alert-danger fade show " role="alert">
                <fmt:message bundle="${loc}" key="language.noRights"/>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${sessionScope.role.name == 'admin'}">
    <form action=${pageContext.request.contextPath}/hotel method="post">
        <div class="p-3">
            <div class="row justify-content-center">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.orderId"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.fullName"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.mobilePhone"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.dateTime"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.leaseDuration"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.apartmentNumber"/></th>
                        <th scope="col"><fmt:message bundle="${loc}" key="language.status"/></th>
                    </tr>
                    </thead>
                    <c:forEach var="userOrder" items="${userOrders}">
                        <tr>
                            <th width="50" scope="row">#<c:out value="${userOrder.id}"/></th>
                            <td width="150" class="text-primary">
                                <c:set scope="request" var="informationNumberFlag" value="0"/>
                                    <c:forEach var="user" items="${users}">
                                        <c:forEach var="information" items="${userInformation}">

                                            <c:if test="${information.id == user.userInformationId && userOrder.userId==user.id
                                            &&  informationNumberFlag == 0}">
                                                <p><c:out value="${information.surname}"/>
                                                    <c:out value="${information.name}"/>
                                                </p>
                                                <c:set scope="request" var="informationNumberFlag" value="1"/>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>

                            </td>
                            <td class="text-primary">
                                <c:set scope="request" var="informationNumberFlag" value="0"/>
                                <c:forEach var="user" items="${users}">
                                    <c:forEach var="information" items="${userInformation}">

                                        <c:if test="${information.id == user.userInformationId && userOrder.userId==user.id
                                            &&  informationNumberFlag == 0}">
                                            <p><c:out value="${information.phone}"/>
                                            </p>
                                            <c:set scope="request" var="informationNumberFlag" value="1"/>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </td>
                            <td><c:out value="${userOrder.startTime}"/></td>
                            <td><c:out value="${userOrder.leaseDuration}"/></td>

                            <c:set var="continueExecuting" scope="request" value="true"/>
                            <td >
                                <c:forEach var="apartment" items="${apartments}">
                                    <c:if test="${userOrder.apartmentId == apartment.id}">
                                        <c:if test="${continueExecuting}">
                                            <p><c:out value="${apartment.apartmentNumber}"/></p>
                                            <c:set var="continueExecuting" scope="request" value="false"/>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </td>
                            <c:set var="continueExecuting" scope="request" value="true"/>

                            <td >
                                <c:forEach var="apartment" items="${apartments}">
                                    <c:if test="${userOrder.apartmentId == apartment.id}">
                                        <c:if test="${continueExecuting}">
                                            <p><c:out value="${apartment.status}"/></p>
                                            <c:set var="continueExecuting" scope="request" value="false"/>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </td>
                            <c:set var="continueExecuting" scope="request" value="true"/>


                            <td class="text-active"><c:out value="${userOrder.status}"/></td>
                            <td>
                                <button onclick="location.href = '${pageContext.request.contextPath}/hotel?command=completeUserOrder&userOrderId=${userOrder.id}'"
                                        type="button" class="btn btn-outline-success">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-check2" viewBox="0 0 16 16">
                                        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
                                    </svg>
                                </button>
                            </td>
                            <td>
                                <button onclick="location.href = '${pageContext.request.contextPath}/hotel?command=deleteUserOrder&userOrderId=${userOrder.id}'"
                                        class="btn btn-outline-danger" type="button">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                         fill="currentColor"
                                         class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
                                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"></path>
                                    </svg>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </form>
</c:if>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>
