<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../Header/Header.jsp" />
<jsp:include page="../../Header/HeaderAdmin.jsp" />
<%@page import="com.antonio.spring_mvc.Service.Utility" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<section>

    <div class="container py-4">


        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <h3 class="text-center">Planning</h3>
                <form role="form" action="/planning" id="contact-form" method="get" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <label class="form-label">Debut</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="date" placeholder="debut" value="${debut}" name="debut" />
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Fin</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="date" placeholder="fin" value="${fin}" name="fin" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn bg-gradient-dark w-100">Filtrer</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>






        <div class="row">
            <div class="col-lg-8 mx-auto d-flex justify-content-center flex-column">

                <c:forEach items="${planning}" var="list">

                    <div class="card" style="margin: 20px">
                        <h5 class="card-header">${list.date}</h5>
                        <div class="card-body">


                            <div class="table-responsive">
                                <table class="table align-items-center mb-0">
                                    <thead>
                                    <tr>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Debut</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Fin</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Plateau</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Catégorie d'action</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Action</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Personnage</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Emotion</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Scène</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Film</th>
                                    </tr>
                                    </thead>
                                    <tbody>


                    <c:forEach items="${list.planningDetails}" var="act">
                        <tr>
                            <td>${act.firstHour}</td>
                            <td>${act.lastHour}</td>
                            <td>${act.act.scene_id.plateau.location}</td>
                            <td>${act.act.acttype_id.typename}</td>
                            <td>${act.act.action}</td>
                            <td>${act.act.acteur_id.nom_acteur}</td>
                            <td>${act.act.emotion_id.emotionname}</td>
                            <td>${act.act.scene_id.description}</td>
                            <td>${act.act.scene_id.film.description}</td>
                        </tr>
                    </c:forEach>


                                    </tbody>
                                </table>


                            </div>
                        </div>
                    </div>

                </c:forEach>



            </div>
            <div class="col-lg-2">


                <div class="card" style="margin: 20px">
                    <h5 class="card-header">Acteurs</h5>
                    <div class="card-body">


                        <div class="table-responsive">
                            <table class="table align-items-center mb-0">
                                <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Acteur</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${acteurs}" var="a">
                                    <tr>
                                        <td>${a.nom_acteur}</td>
                                    </tr>
                                </c:forEach>


                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>





            </div>
            <div class="col-lg-2">



                <div class="card" style="margin: 20px">
                    <h5 class="card-header">Plateaux</h5>
                    <div class="card-body">


                        <div class="table-responsive">
                            <table class="table align-items-center mb-0">
                                <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Acteur</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${plateaux}" var="p">
                                    <tr>
                                        <td>${p.location}</td>
                                    </tr>
                                </c:forEach>


                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>



            </div>


        </div>
        <div class="row">
            <div class="col-lg-12 mx-auto d-flex justify-content-center flex-column">
                <button type="button" class="btn bg-gradient-info w-10">Générer PDF</button>
            </div>




        </div>
    </div>

</section>
</body>

<jsp:include page="../../Footer.jsp" />
