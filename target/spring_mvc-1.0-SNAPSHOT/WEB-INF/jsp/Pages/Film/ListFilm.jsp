<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../Header/Header.jsp" />
<jsp:include page="../../Header/HeaderAdmin.jsp" />
<body>
<section>
  <div class="container py-4">
    <div class="row">
      <h1 class="text-center">Liste Film</h1>


      <c:forEach items="${allMovies}" var="movie">
        <div class="col-lg-4"style="margin-top: 5px" >
          <div class="card" style="max-width: 300px">
            <div class="card-body">
              <h5 class="card-title"><a href="/scenes/${movie.id}" >${movie.title}</a></h5>
              <p class="card-text">${movie.description}</p>
              <p class="card-text"><strong>Categorie</strong> : ${movie.filmctg_id.ctgname}</p>
              <p class="card-text"><strong>Fond</strong> : 2022-12-12 </p>
              <p class="card-text"><strong>Date de production</strong> : ${movie.production_date}</p>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>
</body>
<jsp:include page="../../Footer.jsp" />
