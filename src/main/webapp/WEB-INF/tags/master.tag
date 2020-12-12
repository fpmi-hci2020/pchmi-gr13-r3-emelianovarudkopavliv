<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="true" %>
<%@ attribute name="email" required="false" %>

<html>
<head>
  <title>${pageTitle}</title>
<%--    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/WEB-INF/tags/main.css" type='text/css'>--%>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/WEB-INF/tags/main.css" type='text/css'>
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
  <header style="background-color: #3F014C">
    <div>
      <div class="float-left">
            <nav>
                <ul style="display: inline">
                    <li style="display: inline; font-size: 40px">
                            <a href="${pageContext.servletContext.contextPath}" class="title">
                                <em style="color: #FFFFAC">Book Store&nbsp&nbsp&nbsp</em>
                            </a>
                    </li>
                    <li style="display: inline; font-size: 30px">
                        <a href="${pageContext.servletContext.contextPath}" style="color: white">News</a>
                    </li>
                    <li style="display: inline; font-size: 30px">
                        <a href="${pageContext.servletContext.contextPath}" style="color: white">Orders</a>
                    </li>
                    <li style="display: inline; font-size: 30px">
                        <a href="${pageContext.servletContext.contextPath}" style="color: white">Favorites</a>
                    </li>
                </ul>
            </nav>

      </div>
        <div class="float-right">
            <h5>
                    <em style="color: white">User: ${email}</em>
            </h5>
            <div class="float-right">
                <form method="get" id="toSignInForm" action="${pageContext.servletContext.contextPath}/signIn">
                    <input type="submit" value="Sign out" class="button" style="color: white; background-color: #652270; border: #652270; width: 100px; height: 40px" />
                </form>
            </div>
        </div>
      <div id="resultContainer" class="float-right">
        <h1></h1>
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