<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="true" %>
<%@ attribute name="email" required="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>${pageTitle}</title>
    <link href='http://fonts.googleapis.com/css?family=Lobster+Two' rel='stylesheet' type='text/css'>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Mono&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/styles/main.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
</head>

<body style="background-color: #F5E1FF">
  <header >
      <div>
    <div style="display: inline">
      <div class="float-left" style="display: inline">
            <nav>
                <ul style="display: inline">
                    <li style="display: inline; font-size: 40px">
                            <a href="${pageContext.servletContext.contextPath}" class="title">
                                <b style="color: #FEF0A5; font-size: 24px; font-family: 'Roboto Mono', monospace;">Book Store&nbsp&nbsp&nbsp</b>
                            </a>
                    </li>
                    <li class="li_menu">
                        <a href="${pageContext.servletContext.contextPath}/news" style="color: white; font-size: 18px; font-family: 'Roboto Mono', monospace;">News</a>
                    </li>
                    <li class="li_menu">
                        <a href="${pageContext.servletContext.contextPath}/orders" style="color: white; font-size: 18px; font-family: 'Roboto Mono', monospace;">Orders</a>
                    </li>
                    <li class="li_menu">
                        <a href="${pageContext.servletContext.contextPath}/favorites" style="color: white; font-size: 18px; font-family: 'Roboto Mono', monospace;">Favorites</a>
                    </li>
                </ul>
            </nav>

      </div>
    </div>
    <div style="display: inline">
        <div class="float-right" style="display: inline">
            <nav>
                <ul style="display: inline">
                    <li style="display: inline; font-size: 30px">
                        <b style="color: white; font-size: 18px; font-family: 'Roboto Mono', monospace;">User ${email}&nbsp</b>
                    </li>
                    <li style="display: inline; font-size: 30px">
                        <a href="${pageContext.servletContext.contextPath}/cart" style="color: white; font-size: 18px; font-family: 'Roboto Mono', monospace;">
                            Cart
                            <img src="${pageContext.servletContext.contextPath}/resources/images/icons8-shopping-cart-64%201.png" height="30" width="30">
                            &nbsp
                        </a>
                    </li>
                    <li style="display: inline;">
                        <form method="get" id="toSignInForm" action="${pageContext.servletContext.contextPath}/signIn" style="display: inline">
                            <input type="submit" value="Sign out" class="button" style="margin-top: 18px; color: white; margin-right: 45px; background-color: #652270; border: #652270; width: 100px; height: 40px; font-size: 18px; font-family: 'Roboto Mono', monospace;" />
                        </form>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

      <br>
      <br>
      <br>
      <br>
      <br>
      </div>
  </header>
  <main>
    <jsp:doBody/>
  </main>
<footer>
</footer>
</body>
</html>