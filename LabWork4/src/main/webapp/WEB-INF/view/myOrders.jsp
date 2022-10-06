<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>My Orders | Hotel</title>
    <jsp:include page="fragments/headerLinks.jsp"/>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<fmt:setBundle basename="information" var="info"/>
<div class="p-3">
    <div class="row justify-content-center">
        <c:if test="${sessionScope.user == null}">
            <div class="alert alert-danger fade show " role="alert">
                <fmt:message bundle="${loc}" key="language.noRights"/>
            </div>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.dateTime"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.numberOfBeds"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.numberOfRooms"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.apartmentNumber"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.price"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.type"/></th>
                    <th scope="col"><fmt:message bundle="${loc}" key="language.status"/></th>
                </tr>
                </thead>

                <c:set var="continueExecuting" scope="request" value="true"/>

                <c:forEach var="userOrder" items="${userOrders}">
                    <tr>
                        <td class="text-primary">
                               <p> <c:out value="${userOrder.startTime}"/></p>

                        </td>

                        <td class="text-primary">
                            <c:forEach var="apartment" items="${apartments}">
                                <c:if test="${userOrder.apartmentId == apartment.id}">
                                    <c:if test="${continueExecuting}">
                                    <p><c:out value="${apartment.numberOfBeds}"/></p>
                                        <c:set var="continueExecuting" scope="request" value="false"/>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                        <c:set var="continueExecuting" scope="request" value="true"/>
                        <td class="text-primary">
                            <c:forEach var="apartment" items="${apartments}">
                                <c:if test="${userOrder.apartmentId == apartment.id}">
                                <c:if test="${continueExecuting}">
                                    <p><c:out value="${apartment.numberOfRooms}"/></p>
                                    <c:set var="continueExecuting" scope="request" value="false"/>
                                </c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                        <c:set var="continueExecuting" scope="request" value="true"/>
                        <td class="text-primary">
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
                        <td class="text-primary">
                            <c:forEach var="apartment" items="${apartments}">
                                <c:if test="${userOrder.apartmentId == apartment.id}">
                                <c:if test="${continueExecuting}">
                                    <p><c:out value="${apartment.price} "/><fmt:message bundle="${info}" key="information.price"/></p>
                                    <c:set var="continueExecuting" scope="request" value="false"/>
                                </c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                        <c:set var="continueExecuting" scope="request" value="true"/>
                        <td class="text-primary">
                            <c:forEach var="apartment" items="${apartments}">
                                <c:if test="${userOrder.apartmentId == apartment.id}">
                                <c:if test="${continueExecuting}">
                                    <p><c:out value="${apartment.type}"/></p>
                                    <c:set var="continueExecuting" scope="request" value="false"/>
                                </c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                        <c:set var="continueExecuting" scope="request" value="true"/>


                        <c:if test="${userOrder.status == 'confirmed'}">
                            <td class="text-success"><c:out value="${userOrder.status}"/></td>
                        </c:if>
                        <c:if test="${userOrder.status == 'booked'}">
                            <td class="text-active"><c:out value="${userOrder.status}"/></td>
                        </c:if>
                        <c:if test="${userOrder.status == 'canceled'}">
                            <td class="text-danger"><c:out value="${userOrder.status}"/></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>
