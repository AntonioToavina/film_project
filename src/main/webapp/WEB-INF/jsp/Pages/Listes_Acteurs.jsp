<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header/Header.jsp" />
<jsp:include page="../Header/HeaderAdmin.jsp" />
<%@page import="com.antonio.spring_mvc.Service.Utility" %>
<body>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <div class="card">
                    <h1 class="text-center">Listes acteurs</h1>
                    <div class="table-responsive">
                        <table class="table align-items-center mb-0">
                            <thead>
                            <tr>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Id</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Name</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Gender</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Birthday</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${acteurs}" var="acteur">
                                <tr>
                                    <td><a href="/acteurs/${acteur.id}/to_addIndisponibilite">${acteur.id}</a></td>
                                    <td>${acteur.nom_acteur}</td>
                                    <td>${acteur.gender.gendername}</td>
                                    <td>${Utility.formatDate(acteur.birthday)}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div style="margin-top: 50px;margin-left: 300px">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a class="page-link" href="/to_listesActeurs/nextpage?increment=-1" aria-label="Previous">
                                        <span aria-hidden="true"><<</span>
                                    </a>
                                </li>
                                <li class="page-item active"><a class="page-link" href="/to_listesActeurs/nextpage?increment=0">${currPage}</a></li>
                                <li class="page-item active"><a class="page-link" href="/to_listesActeurs/nextpage?increment=1">${currPage+1}</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="/to_listesActeurs/nextpage?increment=1">
                                        <span aria-hidden="true">>></span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
</body>
<jsp:include page="../Footer.jsp" />
