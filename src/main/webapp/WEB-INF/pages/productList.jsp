<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:master pageTitle="Books" email="${email}">

  <div style="background-color: #3F014C; height: 50px">
    <div id="messageContainer" class="float-left"></div>
      <div class="float-right">
        <form>
          <input type="text" name="queryProduct" value="${param.queryProduct}" placeholder="Search..." style="height: 40px">
          <button style="color: white; background-color: #652270; border: #652270; width: 100px; height: 40px">Search</button>
        </form>
      </div>
      <br>
  </div>
    <br>
<p>
  <table id="booksTableId" class="table table-bordered table-striped">
    <thead>
      <tr>
        <th><b>Image</b></th>
        <th><b>Title</b></th>
        <th><b>Author</b></th>
        <th><b>Price</b></th>
        <th><b>Action</b></th>
      </tr>
    </thead>
    <c:forEach var="book" items="${books}" varStatus="status">
        <tr>
            <form:form action="${pageContext.servletContext.contextPath}/ajaxCart" method="post" id="bookForm${book.id}" modelAttribute="addToCartForm">
              <td>
                  <img src="${bookCoverList[status.index]}" height="230" width="170">

              </td>
              <td>
                  <a href="${pageContext.servletContext.contextPath}/productDetails/${book.id}" style="color: #1E0340">
                      ${book.title}
                  </a>
              </td>
              <td style="color: #1E0340">${book.author}</td>
              <td style="color: #1E0340">${book.price}$</td>
              <td>
                  <form:hidden path="bookId" value="${book.id}" id="bookId${book.id}" />
                  <form:input path="quantity" id="quantity${book.id}" cssStyle="height: 40px" />
                  <div id="error${book.id}"></div>
              </td>
              <td>
                <input type="submit" value="Add to cart" class="button" id="${book.id}" style="color: white; background-color: #652270; border: #652270; width: 100px; height: 40px" />
              </td>
            </form:form>
        </tr>
    </c:forEach>
  </table>
</p>
</tags:master>
