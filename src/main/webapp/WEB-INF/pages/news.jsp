<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:master pageTitle="News" email="${email}">

    <div class="float-left" style="background-color: #BF7F8E; height: 30px; width: 1500px">
        <button style="background-color: #BF7F8E; border: #BF7F8E"><a href="${pageContext.request.contextPath}/productList" class="text18"><b>
            <img src="${pageContext.servletContext.contextPath}/resources/images/icons8-go-back-64%201.png" height="20" width="20">
            Back to catalog</b></a></button>
        &nbsp
        <div class="float-right" id="messageContainer"></div>
    </div>
    <br>
    <br>
    <div class="layer1" style="background-color: white; width: 400px">
        <c:forEach var="new" items="${news}" varStatus="status" step="2" begin="0">
            <div class="row">
                <div class="col-sm-4">
                    <c:set var="b" value="${news[status.index]}" />
                    <c:if test="${not empty b}">
                        <div style="color: #1E0340; font-size: 30px">
                                ${b.title}
                        </div>
                        <div style="color: #1E0340; font-size: 18px">
                                ${b.content}
                        </div>
                        <div style="color: #1E0340; font-size: 25px; font-style: italic">
                                ${b.publisher}
                        </div>
                    </c:if>
                </div>
                <div class="col-sm-4">
                    <c:set var="b" value="${news[status.index + 1]}" />
                    <c:if test="${not empty b}">
                        <div style="color: #1E0340; font-size: 25px">
                                ${b.title}
                        </div>
                        <div style="color: #1E0340; font-size: 18px">
                                ${b.content}$
                        </div>
                        <div style="color: #1E0340; font-size: 20px">
                                ${b.publisher}$
                        </div>
                    </c:if>
                </div>
            </div>
            <br>
        </c:forEach>
    </div>

</tags:master>
