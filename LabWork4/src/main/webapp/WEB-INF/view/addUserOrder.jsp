<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>Add order | Hotel</title>
    <jsp:include page="fragments/headerLinks.jsp"/>
</head>
<body class="d-flex flex-column h-100">
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<fmt:setBundle basename="information" var="info"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col"></div>
        <div class="col-6 my-sm-3">
            <c:if test="${sessionScope.user == null}">
                <div class="alert alert-danger fade show " role="alert">
                    <fmt:message bundle="${loc}" key="language.noRights"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.user != null}">
            <c:if test="${errorMessage=='true'}">
                <div class="alert alert-danger fade show" role="alert">
                    <fmt:message bundle="${loc}" key="language.addOrderError"/>
                </div>
            </c:if>

                <h4 class="mt-5 fw-bold"><fmt:message bundle="${loc}" key="language.enterOrderDetails"/></h4>

                <form action="${pageContext.request.contextPath}/hotel?command=confirmUserOrder&apartment_id=<%= request.getParameter("apartment_id") %>" method="post">


                    <div >
                        <label for="lease_duration" class="form-label"><fmt:message bundle="${loc}"
                                                                                   key="language.leaseDuration"/></label>
                        <input type="text" class="form-control" name="lease_duration" id="lease_duration"
                               placeholder="8 hour" pattern="^(([1-9][0-9]*)|([1-9]))$" maxlength="10" required>
                    </div>


                    <div class=>

                        <div >
                            <label for="year" class="form-label"><fmt:message bundle="${loc}" key="language.year"/></label>
                            <div class="input-group w-50">
                                <input type="text" class="form-control" id="year" name="year"
                                       placeholder="2022" pattern="^[0-9]{4}$" maxlength="4" required></div>
                        </div>

                        <div >
                            <label for="month" class="form-label"><fmt:message bundle="${loc}" key="language.month"/></label>
                            <div class="input-group w-50">
                                <input type="text" class="form-control" id="month" name="month"
                                       placeholder="12"  maxlength="2" pattern="^([1-9]|1[012])$" required></div>
                        </div>

                        <div >
                            <label for="day" class="form-label"><fmt:message bundle="${loc}"
                                                                              key="language.day"/></label>

                            <div class="input-group w-100">
                                <input type="text"    class="form-control" id="day" name="day" placeholder="day" pattern="^(([1-9])|(1[0-9])|(2[0-9])|(3[0-1]))$" required></div>
                        </div>

                        <div >
                            <label for="hour" class="form-label"><fmt:message bundle="${loc}"
                                                                              key="language.hour"/></label>

                            <div class="input-group w-100">
                                <input type="text"    class="form-control" id="hour" name="hour" placeholder="hour" pattern="^(([1-5]?([0-9])))$" maxlength="2" required></div>
                        </div>


                        <div >
                            <label for="minute" class="form-label"><fmt:message bundle="${loc}"
                                                                              key="language.minute"/></label>

                            <div class="input-group w-100">
                                <input type="text"  class="form-control" id="minute" name="minute" placeholder="minute" maxlength="2" pattern="^(([1-5]?([0-9])))$" required></div>
                        </div>

                    </div>






                    <button class="btn btn-primary" type="submit" name="command" value="confirmOrder"><fmt:message bundle="${loc}"
                                                                               key="language.confirm"/></button>

                </form>
                <hr class="dropdown-divider">
                <a href="/hotel?command=main"><fmt:message bundle="${loc}" key="language.home"/></a>
        </div>
        </c:if>
        <div class="col-sm"></div>
    </div>
</div>
</body>
</html>
