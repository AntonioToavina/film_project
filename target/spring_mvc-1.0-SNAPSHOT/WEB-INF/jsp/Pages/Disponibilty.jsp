<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header/Header.jsp" />
<jsp:include page="../Header/HeaderAdmin.jsp" />
<body>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <h3 class="text-center">Jour d'indisponiblilite</h3>
                <form role="form" action="/acteurs/${idacteur}/newIndisponibilite" id="contact-form" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <label class="form-label">Date</label>
                            <div class="input-group input-group-dynamic">
                                <input type="date" class="form-control" name="notavailabledate">
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Observation</label>
                            <div class="input-group input-group-dynamic">
                                <input type="text" class="form-control" name="observation">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn bg-gradient-dark w-100">Valider</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <div class="card">
                    <h3 class="text-center">Listes jours d'indisponibilite</h3>
                    <div class="table-responsive">
                        <table class="table align-items-center mb-0">
                            <thead>
                            <tr>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Id</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Date</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Observation</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${dispos}" var="dispo">
                                <tr>
                                    <td><a href="">${dispo.id}</a></td>
                                    <td>${dispo.notavailabledate}</td>
                                    <td>${dispo.observation}</td>
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