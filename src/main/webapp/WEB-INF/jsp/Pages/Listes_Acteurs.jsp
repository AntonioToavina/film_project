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
                                    <td><a href="">${acteur.id}</a></td>
                                    <td>${acteur.nom_acteur}</td>
                                    <td>${acteur.gender.gendername}</td>
                                    <td>${Utility.formatDate(acteur.birthday)}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
</body>
<jsp:include page="../Footer.jsp" />
