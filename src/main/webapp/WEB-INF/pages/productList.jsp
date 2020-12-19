<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:master pageTitle="Books" email="${email}">
  <div style="background-color: #3F014C; height: 50px">
    <div id="messageContainer" class="float-left"></div>
      <div class="float-left">
          <select name="genre" style="background-color: #BF7F8E; color: #1E0340; height: 40px; width: 150px; margin-left: 40px; font-family: 'Roboto Mono', monospace;">
              <option>all genres</option>
          </select>
          <select name="publisher" style="background-color: #BF7F8E; color: #1E0340; height: 40px; width: 200px; margin-left: 20px; font-family: 'Roboto Mono', monospace;">
              <option>all publishers</option>
          </select>
      </div>
      <div class="float-right">
        <form>
          <input type="text" name="queryProduct" value="${param.queryProduct}" placeholder="Search..." style="height: 40px; width: 600px;">
          <button style="color: #1E0340; font-family: 'Roboto Mono', monospace; margin-left: 20px; background-color: #FEF0A5; border: #652270; width: 100px; height: 40px; margin-right: 45px; font-size: 18px">Search</button>
        </form>
      </div>
      <br>
  </div>
    <br>
<div class="layer1">
    <c:forEach var="book" items="${books}" varStatus="status" step="3" begin="0">
        <div class="row">
            <div class="col-sm-4">
                <c:set var="b" value="${books[status.index]}" />
                <c:if test="${not empty b}">
                    <img src="${bookCoverList[status.index]}" height="230" width="170">
                    <br>
                    <a href="${pageContext.servletContext.contextPath}/productDetails/${b.id}" style="color: #1E0340; font-size: 24px">
                            ${b.title}
                    </a>
                    <div style="color: #1E0340; font-size: 18px">
                            ${b.author}
                    </div>
                    <div style="color: #1E0340; font-size: 36px">
                            ${b.price}$
                    </div>
                </c:if>
            </div>
            <div class="col-sm-4">
                <c:set var="b" value="${books[status.index + 1]}" />
                <c:if test="${not empty b}">
                    <img src="${bookCoverList[status.index + 1]}" height="230" width="170">
                    <br>
                    <a href="${pageContext.servletContext.contextPath}/productDetails/${b.id}" style="color: #1E0340; font-size: 24px">
                        ${b.title}
                    </a>
                    <div style="color: #1E0340; font-size: 18px">
                            ${b.author}
                    </div>
                    <div style="color: #1E0340; font-size: 36px">
                            ${b.price}$
                    </div>
                </c:if>
            </div>
            <div class="col-sm-4">
                <c:set var="b" value="${books[status.index + 2]}" />
                <c:if test="${not empty b}">
                    <img src="${bookCoverList[status.index + 2]}" height="230" width="170">
                    <br>
                    <a href="${pageContext.servletContext.contextPath}/productDetails/${b.id}" style="color: #1E0340; font-size: 24px">
                            ${b.title}
                    </a>
                    <div style="color: #1E0340; font-size: 18px">
                        ${b.author}
                    </div>
                    <div style="color: #1E0340; font-size: 36px; font-style: italic">
                            ${b.price}$
                    </div>
                </c:if>
            </div>
        </div>
        <br>
    </c:forEach>
</div>
</tags:master>
