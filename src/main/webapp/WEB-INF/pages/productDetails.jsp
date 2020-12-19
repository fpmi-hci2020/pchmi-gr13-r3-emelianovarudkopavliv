<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<tags:master pageTitle="Book Details" email="${email}">

    <div class="float-left" style="background-color: #BF7F8E; height: 30px; width: 1500px">
        <button style="background-color: #BF7F8E; border: #BF7F8E"><a href="${pageContext.request.contextPath}/productList" class="text18"><b>
            <img src="${pageContext.servletContext.contextPath}/resources/images/icons8-go-back-64%201.png" height="20" width="20">
            Back to catalog</b></a></button>
        &nbsp
        <div class="float-right" id="messageContainer"></div>
    </div>
    <br>
    <br>
    <div class="d-flex align-items-center" style="margin-top: 20px">
            <div class="d-inline-block" style="margin-left: 40px">
                <div>
                    <img src="${bookCover}" height="360" width="270">
                </div>
                <div class="price72">${book.price}$</div>
            </div>
            <div class="d-inline-block" style="margin-left: 40px">

                    <form:form action="${pageContext.servletContext.contextPath}/productDetails/${book.id}/toCart" method="post"  modelAttribute="addToCartForm" style=" display:inline!important;">
                        <form:hidden path="bookId" value="${book.id}" id="bookId${book.id}" />
                        <form:hidden path="quantity" value="1" id="bookId${book.id}" />
                        <input type="submit" value="Add to cart" class="button" id="${book.id}" style="font-family: 'Roboto Mono', monospace; font-size:18px; color: white; background-color: #652270; border: #652270; width: 150px; height: 40px" />
                    </form:form>
                    <form:form action="${pageContext.servletContext.contextPath}/productDetails/${book.id}/toFavorites" method="post"  modelAttribute="addToCartForm" style=" display:inline!important;">
                            <form:hidden path="bookId" value="${book.id}" id="bookId${book.id}" />
                            <form:hidden path="quantity" value="1" id="bookId${book.id}" />
                            <input type="submit" value="Add to favorites" class="button" id="${book.id}" style="font-family: 'Roboto Mono', monospace; font-size:18px; color: white; background-color: #652270; border: #652270; width: 200px; height: 40px" />
                    </form:form>

                <div class="text72">${book.title}</div>
                <div class="text50">${book.author}</div>
                <div class="text20">${book.description}</div>
            </div>
    </div>
</tags:master>