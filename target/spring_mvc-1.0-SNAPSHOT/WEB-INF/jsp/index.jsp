<jsp:include page="Header/Header.jsp" />
<jsp:include page="Header/HeaderAdmin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <h3 class="text-center">Creation scene</h3>
                <form role="form" action="/scenes" id="contact-form" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <label class="form-label">Film</label>
                            <div class="input-group input-group-dynamic">
                                <select name="film_id" class="form-control" >
                                    <c:forEach items="${films}" var="film">
                                        <option value="${film.id}">${film.title}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Plateau</label>
                            <div class="input-group input-group-dynamic">
                                <select name="plateau_id" class="form-control" >
                                    <c:forEach items="${plateaux}" var="plateau">
                                        <option value="${plateau.id}">${plateau.location}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-4">
                            <div class="input-group input-group-dynamic">
                                <label class="form-label">Description</label>
                                <textarea name="description" class="form-control" id="message" rows="4"></textarea>
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
</body>
<jsp:include page="Footer.jsp" />