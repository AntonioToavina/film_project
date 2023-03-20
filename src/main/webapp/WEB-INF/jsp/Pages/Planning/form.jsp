<jsp:include page="../../Header/Header.jsp" />
<jsp:include page="../../Header/HeaderAdmin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <h3 class="text-center">Suggestion de planning</h3>
                <form role="form" action="/scenes" id="contact-form" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <label class="form-label">Debut</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="date" placeholder="debut" name="debut" />
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Fin</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="date" placeholder="fin" name="fin" />
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">Choisir scènes</label>
                            <div class="input-group input-group-dynamic">
<<<<<<< Updated upstream
                                <textarea name="description" class="form-control" id="message" rows="4"></textarea>
                <h3 class="text-center">Suggestion de planning</h3>
                <form role="form" action="/scenes" id="contact-form" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <label class="form-label">Debut</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="date" placeholder="debut" name="debut" />
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Fin</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="date" placeholder="fin" name="fin" />
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">Choisir scènes</label>
                            <div class="input-group input-group-dynamic">
                                <select name="scene_id[]" class="form-select" multiple>
=======
                                <select name="scene_id[]" type="multiple" class="form-control">
>>>>>>> Stashed changes
                                    <option value="1">Scène 1</option>
                                    <option value="2">Scène 2</option>
                                    <option value="3">Scène 3</option>
                                    <option value="4">Scène 4</option>
                                    <option value="5">Scène 5</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
<<<<<<< Updated upstream
                                <button type="submit" class="btn bg-gradient-dark w-100">Valider</button>
=======
>>>>>>> Stashed changes
                                <button type="submit" class="btn bg-gradient-dark w-100">Voir suggestion</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
<<<<<<< Updated upstream
<jsp:include page="../../Footer.jsp" />
=======
<jsp:include page="../../Footer.jsp" />
>>>>>>> Stashed changes
