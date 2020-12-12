<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:master1 pageTitle="Sign in form">
    <div>
        <table>
            <tr>
            <form:form method="post" modelAttribute="signInForm">
                <div>
                    <div><form:label path="login">Login&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</form:label><form:input path="login" /></div>
                    <br>
                    <div><form:label path="password">Password&nbsp&nbsp</form:label><form:input path="password" /></div>
                    <br>
                <div>
                    <button style="color: white; background-color: #652270; border: #652270; width: 100px; height: 40px">
                        Sign in
                    </button>
                    <button form="toSignUpForm" formaction="${pageContext.servletContext.contextPath}/signUp" style="color: white; background-color: #652270; border: #652270; width: 100px; height: 40px">
<%--                    <button form="toSignUpForm" formaction="${pageContext.servletContext.contextPath}/signUp" class="button_first">--%>
                        To Sign up
                    </button>
                </div>
                    <br>
                </div>
            </form:form>
        </table>
    </div>
    <form:form method="get" id="toSignUpForm" />
</tags:master1>
