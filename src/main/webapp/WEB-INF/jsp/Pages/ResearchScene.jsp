<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header/Header.jsp" />
<jsp:include page="../Header/HeaderAdmin.jsp" />

<body>
<%--barre de recherche--%>
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

<%--résultat de recherche--%>
<c:if test="${allMatchScenes!=null}" >
    <section>
        <div class="container py-4">
            <div class="row">
                <h1 class="text-center">Liste scene</h1>
                <c:forEach items="${allMatchScenes}" var="scene">
                    <div class="col-lg-4"style="margin-top: 5px" >
                        <div class="card" style="max-width: 300px">
                            <div class="card-body">
                                <h3 class="card-title">${scene.description}</h3>
                                <p class="card-text"><strong>Plateau</strong> : ${scene.plateau.location}</p>
                                <p class="card-text"><strong>Status</strong> : ${scene.scenestatus.status} </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</c:if>

</body>

<jsp:include page="../Footer.jsp" />