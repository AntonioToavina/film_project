<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header/Header.jsp" />
<jsp:include page="../Header/HeaderAdmin.jsp" />

<body>
<section>
  <div class="container py-4">
    <div class="row">
        <form action="/scenes/research" method="POST" >
          <input type="text" name="keyword" placeholder="Elastic search" />
          <input type="submit" value="Rechercher" />
        </form>
    </div>
  </div>
</section>
</body>

<jsp:include page="../Footer.jsp" />