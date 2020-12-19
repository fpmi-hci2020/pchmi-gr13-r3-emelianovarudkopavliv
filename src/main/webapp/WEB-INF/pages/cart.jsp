<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<tags:master pageTitle="Cart">
  <br>
  <div class="d-flex align-items-center" style="margin-top: 20px">
    <div class="d-inline-block" style="margin-left: 40px">
      <c:forEach var="cartItem" items="${cartItems}" varStatus="status">
        <div class="d-flex align-items-center">
          <div class="d-inline-block">
            <img src="${bookCoverList[status.index]}" height="130" width="100">
          </div>
          <div class="d-inline-block" style="margin-left: 20px">
            <div class="text40">${cartItem.book.title}</div>
            <div class="text30">${cartItem.book.author}</div>
              <form:form action="${pageContext.servletContext.contextPath}/cart" method="post"  modelAttribute="addToCartForm">
                <form:hidden path="bookId" value="${cartItem.book.id}" id="bookId${cartItem.book.id}" />
      <%--          <form:hidden path="quantity" value="1" id="bookId${book.id}" />--%>
                <form:input path="quantity" id="quantity${cartItem.book.id}" cssStyle="height: 40px" />
                <input type="submit" value=" + " class="button" id="${cartItem.book.id}" style="color: white; background-color: #652270; border: #652270; width: 100px; height: 40px" />
              </form:form>
          </div>
        </div>
      </c:forEach>
    </div>
    <div class="d-inline-block" style="background-color:white; margin-left: 150px; height: 350px; width: 400px;">
      <form:form action="${pageContext.servletContext.contextPath}/cart/placeOrder" method="post">
        <div class="row justify-content-center" >
            <div class="price100">${totalCost}</div>

                <div class="d-inline-block">
                    <div>
                        Choose payment method:&nbsp
                        <div style="background-color: #652270; color: white">
                            <div>
                                <input type="radio" id="card" name="payment" value="card"
                                       checked>
                                <label for="card">card</label>
                            </div>
                            <div>
                                <input type="radio" id="cash" name="payment" value="cash">
                                <label for="cash">cash</label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="d-inline-block">
                    <div>
                        Choose shipping method:&nbsp
                        <div style="background-color: #652270; color: white">
                            <div>
                                <input type="radio" id="deliver" name="shipping" value="deliver"
                                       checked>
                                <label for="deliver">deliver</label>
                            </div>
                            <div>
                                <input type="radio" id="collect" name="shipping" value="collect">
                                <label for="collect">collect</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <br>
        <div class="row justify-content-center">
            <input type="submit" value="Place order" style="align-self: center; font-family: 'Roboto Mono', monospace; font-size:18px; color: white; background-color: #652270; border: #652270; width: 200px; height: 40px">
        </div>

      </form:form>
    </div>
  </div>


</tags:master>
