<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>${pageTitle}</title>
  <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/main.css" type='text/css'>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Roboto+Mono&display=swap" rel="stylesheet">
  <link href="<c:url value="/resources/styles/main.css" />" rel="stylesheet">
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
        <br>
        <h1>
          <a href="${pageContext.servletContext.contextPath}" class="title">
            <b style="color: #FEF0A5; font-size: 24px; font-family: 'Roboto Mono', monospace; padding-top: 40px; margin-left: 20px; ">Book Store&nbsp&nbsp&nbsp</b>
          </a>
        </h1>
      </div>
      <br>
      <br>
      <br>
    </div>
      <hr />
  </header>
  <main>
    <jsp:doBody/>
  </main>
<footer>
</footer>
</body>
</html>