<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Add product | Hotel</title>
</head>
<body class="d-flex flex-column h-100">
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-6 my-sm-3">
            <c:if test="${sessionScope.role.name != 'admin'}">
                <div class="alert alert-danger fade show " role="alert">
                    <fmt:message bundle="${loc}" key="language.noRights"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.role.name == 'admin'}">

                <c:if test="${param.message == 'error'}">
                    <div class="alert alert-danger fade show " role="alert">
                        <fmt:message bundle="${loc}" key="language.apartmentAddingError"/>
                    </div>
                </c:if>
                <c:if test="${param.message == 'ok'}">
                    <div class="alert alert-success fade show " role="alert">
                        <fmt:message bundle="${loc}" key="language.apartmentAddedSuccessfully"/>
                    </div>
                </c:if>


                <form action="${pageContext.request.contextPath}/hotel?command=confirmAddingApartment"
                      method="post">
                    <h4><fmt:message bundle="${loc}" key="language.enterApartmentDetails"/></h4>

                    <div class="col-sm mb-3">
                        <label for="photo" class="form-label"><fmt:message bundle="${loc}"
                                                                           key="language.apartmentPhoto"/></label>
                        <input type="text" id="photo" name="photo" class="form-control"
                               placeholder="<fmt:message bundle="${loc}" key="language.apartmentPhoto"/>" required>
                    </div>

                    <div class="row mb-3">
                        <div class="col-sm">
                            <label for="price" class="form-label"><fmt:message bundle="${loc}"
                                                                               key="language.price"/></label>
                            <input type="text" id="price" name="price" class="form-control"
                                   placeholder="13.82" pattern="^(([1-9]\d*\.\d+)|(0[1-9]*\.\d+)|(\d\.\d+)|(0)|([1-9]\d*))$" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-sm mb-3">
                            <label for="type" class="form-label"><fmt:message bundle="${loc}" key="language.type"/></label>
                            <input type="text" name="type" id="type" class="form-control"
                                   maxlength="15" placeholder="standart" required>
                        </div>

                    </div>

                    <div class="mb-3">
                        <label for="status" class="form-label"><fmt:message bundle="${loc}"
                                                                                 key="language.status"/></label>
                        <input type="text" class="form-control" name="status" id="status"
                               placeholder="доступно" maxlength="15" required>
                    </div>


                    <div class="mb-3">
                        <label for="numberOfRooms" class="form-label"><fmt:message bundle="${loc}"
                                                                            key="language.numberOfRooms"/></label>
                        <input type="text" class="form-control" name="numberOfRooms" id="numberOfRooms"
                               placeholder="2" pattern="^(([1-9][0-9]*)|([1-9]))$" maxlength="15"  required>
                    </div>


                    <div class="mb-3">
                        <label for="apartmentNumber" class="form-label"><fmt:message bundle="${loc}"
                                                                            key="language.apartmentNumber"/></label>
                        <input type="text" class="form-control" name="apartmentNumber" id="apartmentNumber"
                               placeholder="73"pattern="^(([1-9][0-9]*)|([1-9]))$" maxlength="15" required>
                    </div>


                    <div class="mb-3">
                        <label for="numberOfBeds" class="form-label"><fmt:message bundle="${loc}"
                                                                            key="language.numberOfBeds"/></label>
                        <input type="text" class="form-control" name="numberOfBeds" id="numberOfBeds"
                               placeholder="3" pattern="^(([1-9][0-9]*)|([1-9]))$" maxlength="15" required>
                    </div>

                    <button class="btn btn-primary" type="submit"><fmt:message bundle="${loc}"
                                                                               key="language.add"/></button>
                </form>
                <hr class="dropdown-divider">
                <a href="/hotel?command=main"><fmt:message bundle="${loc}" key="language.home"/></a>
            </c:if>
        </div>
    </div>
</div>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>