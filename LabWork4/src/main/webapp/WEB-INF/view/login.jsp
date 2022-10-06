<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Log In | Hotel</title>
    <jsp:include page="fragments/headerLinks.jsp"/>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<fmt:setBundle basename="information" var="info"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col"></div>
        <div class="col-6 my-sm-3">
            <c:if test="${sessionScope.user != null}">
                <div class="alert alert-danger fade show " role="alert">
                    <fmt:message bundle="${loc}" key="language.alreadyLoggedIn"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.user == null}">

                <h1 class="mt-5 fw-bold"><fmt:message bundle="${loc}" key="language.signIn"/></h1>

                <c:if test="${errorMessage=='true'}">
                    <div class="alert alert-danger fade show" role="alert">
                        <fmt:message bundle="${loc}" key="language.loginError"/>
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/hotel?command=checkLogin" method="post">

                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label"><fmt:message bundle="${loc}"
                                                                                        key="language.emailAddress"/></label>
                        <div class="input-group w-100">
                            <span class="input-group-text" id="basic-addon1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-person" viewBox="0 0 16 16">
                                    <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
                                </svg>
                                    </span>
                            <input name="email" type="email" class="form-control" id="exampleInputEmail1"
                                   aria-describedby="emailHelp" pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$" placeholder="name@example.com">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="passwordInput" class="form-label"><fmt:message bundle="${loc}"
                                                                                   key="language.password"/></label>
                        <div class="input-group w-100">
                            <span class="input-group-text">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-key" viewBox="0 0 16 16">
                                    <path d="M0 8a4 4 0 0 1 7.465-2H14a.5.5 0 0 1 .354.146l1.5 1.5a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0L13 9.207l-.646.647a.5.5 0 0 1-.708 0L11 9.207l-.646.647a.5.5 0 0 1-.708 0L9 9.207l-.646.647A.5.5 0 0 1 8 10h-.535A4 4 0 0 1 0 8zm4-3a3 3 0 1 0 2.712 4.285A.5.5 0 0 1 7.163 9h.63l.853-.854a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.646-.647a.5.5 0 0 1 .708 0l.646.647.793-.793-1-1h-6.63a.5.5 0 0 1-.451-.285A3 3 0 0 0 4 5z"></path>
                                    <path d="M4 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"></path>
                                </svg>
                            </span>
                            <input name="password" type="password" class="form-control" id="passwordInput" minlength="8"
                                   placeholder="password">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary"><fmt:message bundle="${loc}"
                                                                               key="language.signIn"/></button>
                </form>
                <hr class="dropdown-divider">
                <p class="text-muted"><fmt:message bundle="${loc}" key="language.noAccount"/> <a
                        href="/hotel?command=logUp"><fmt:message bundle="${loc}" key="language.logUp"/></a></p>
                <a href="/hotel?command=main"><fmt:message bundle="${loc}" key="language.home"/></a>
            </c:if>
        </div>
        <div class="col"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>

