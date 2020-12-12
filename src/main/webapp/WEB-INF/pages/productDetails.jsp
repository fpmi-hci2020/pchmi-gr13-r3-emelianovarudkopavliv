<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<tags:master pageTitle="Book Details" email="${email}">

    <div class="float-left" style="background-color: #BF7F8E; height: 30px; width: 1500px">
        <button style="background-color: #BF7F8E; border: #BF7F8E"><a href="${pageContext.request.contextPath}/productList" style="color: #1E0340"><b>Back to catalog</b></a></button>
        &nbsp
        <div class="float-right" id="messageContainer"></div>
    </div>
    <br>
    <br>
        <div class="col-xs-6">
            <div class="table-responsive">
                <table id="booksTableId">
                    <tbody>
                    <tr>
                        <td style="width:50%">
                            <img src="${bookCover}" height="230" width="170">
                        </td>
                        <td>
                            <form:form action="${pageContext.servletContext.contextPath}/ajaxCart" method="post" id="phoneForm${book.id}" modelAttribute="addToCartForm">
                                <div>
                                    <form:hidden path="bookId" value="${book.id}" id="bookId${book.id}" />
                                    <form:input path="quantity" id="quantity${book.id}" cssStyle="height: 40px" />
                                    <input type="submit" value="Add to cart" class="button" id="${book.id}" style="color: white; background-color: #652270; border: #652270; width: 100px; height: 40px" />
                                    <div id="error${book.id}"></div>
                                </div>
                            </form:form>
                            <h1 style="color: #1E0340"><div>${book.title}</div></h1>
                            <h3 style="color: #1E0340"><div>${book.author}</div></h3>
                            <div style="color: #1E0340">${book.description}</div>
                        </td>
                    </tr>
                    <tr><td><br></td></tr>
                        <tr>
                            <td><h3 style="color: #1E0340">Price: ${book.price}$</h3></td>
                        </tr>

                    </tbody>
                </table>
            </div>
        </div>
</tags:master>