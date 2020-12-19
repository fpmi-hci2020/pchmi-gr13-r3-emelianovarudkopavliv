<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:master1 pageTitle="Sign in form">
    <div class="row justify-content-center">
        <table>
            <tr>
            <form:form method="post" modelAttribute="signInForm">
                <div>
                    <div class="row justify-content-center">
                        Sign in
                    </div>
                    <br>
                    <div>
                        <form:label path="login">Login&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</form:label>
                        <form:input path="login" />
                    </div>
                    <br>
                    <div>
                        <form:label path="password">Password&nbsp&nbsp&nbsp&nbsp&nbsp</form:label>
                        <form:input path="password" />
                    </div>
                    <br>
                <div class="row justify-content-center">
                    <div class="d-inline-block">
                        <button style="color: white; background-color: #652270; border: #652270; width: 100px; height: 40px">
                            Sign in
                        </button>
                    </div>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <div class="d-inline-block">
                        <button form="toSignUpForm" formaction="${pageContext.servletContext.contextPath}/signUp" style="color: white; background-color: #652270; border: #652270; width: 120px; height: 40px">
    <%--                    <button form="toSignUpForm" formaction="${pageContext.servletContext.contextPath}/signUp" class="button_first">--%>
                            To Sign up
                        </button>
                    </div>
                </div>
                    <br>
                </div>
            </form:form>
        </table>
    </div>
    <form:form method="get" id="toSignUpForm" />
</tags:master1>
