<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header/Header.jsp" />
<jsp:include page="../Header/HeaderAdmin.jsp" />
<body>
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
                                        <hr/>
                                        <p class="card-text"><strong>Film title</strong> : ${scene.film.title} </p>
                                        <form method="POST" action="/scenes/changeAuthor/${scene.film.id}/${scene.id}" >
                                           <select name="idAuthor" >
                                               <c:forEach items="${allAuteurs}" var="auteur">
                                                   <c:if test="${auteur.id==scene.auteur.id}">
                                                       <option selected value="${auteur.id}" >${auteur.nom} ${auteur.prenom}</option>
                                                   </c:if>

                                                   <c:if test="${auteur.id!=scene.auteur.id}">
                                                       <option value="${auteur.id}" >${auteur.nom} ${auteur.prenom}</option>
                                                   </c:if>
                                               </c:forEach>
                                           </select>
                                            <button type="submit" class="btn bg-gradient-dark w-100">Change author</button>
                                        </form>
                                        <form method="POST" action="/scenes/updateStatus/${scene.film.id}/${scene.id}" >
                                            <c:if test="${scene.scenestatus.id!=maxStatusId}">
                                                <button type="submit" class="btn bg-gradient-dark w-100">Faire passer l'etat suivant</button>
                                            </c:if>
                                        </form>
                                    </div>
                                </div>
                    </div>
                </c:forEach>
        </div>
    </div>
</section>
</body>
<jsp:include page="../Footer.jsp" />
