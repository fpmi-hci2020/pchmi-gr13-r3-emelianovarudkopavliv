<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:master pageTitle="Favorites" email="${email}">
    <div class="float-left" style="background-color: #BF7F8E; height: 30px; width: 1500px">
        <button style="background-color: #BF7F8E; border: #BF7F8E"><a href="${pageContext.request.contextPath}/productList" class="text18"><b>
            <img src="${pageContext.servletContext.contextPath}/resources/images/icons8-go-back-64%201.png" height="20" width="20">
            Back to catalog</b></a></button>
        &nbsp
        <div class="float-right" id="messageContainer"></div>
    </div>
    <br>
    <br>

<div class="row justify-content-center">
  <table>
      <c:forEach var="book" items="${favorites}" varStatus="status">
        <tr>
            <form:form action="${pageContext.servletContext.contextPath}/favorites/${book.id}" method="post">
              <td>
                  <img src="${bookCoverList[status.index]}" height="130" width="100">
              </td>
              <td>
                  <div class="text30" style="margin-left: 20px">
                      ${book.title}
                  </div>
                  <div class="text20" style="margin-left: 20px">
                      ${book.author}
                  </div>
              </td>

              <td>
                  <div style="margin-left: 300px">
                      <input type="submit" value="Remove" class="button" id="${book.id}" style="font-family: 'Roboto Mono', monospace; font-size:18px; color: white; background-color: #652270; border: #652270; width: 200px; height: 40px" />
                  </div>
              </td>
            </form:form>
        </tr>
    </c:forEach>
  </table>
</div>
</tags:master>
