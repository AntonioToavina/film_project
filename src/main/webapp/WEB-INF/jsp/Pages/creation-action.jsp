<%--
  Created by IntelliJ IDEA.
  User: randretsa
  Date: 2023-03-15
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../Header/Header.jsp" />
<jsp:include page="../Header/HeaderAdmin.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <h3 class="text-center">Creation action</h3>
                <form role="form" action="action" id="contact-form" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <label class="form-label">type action</label>
                            <div class="input-group input-group-dynamic">
                                <select name="acttype" class="form-control" >
                                    <c:forEach items="${acttype}" var="type">
                                        <option value="${type.id}">${type.typename}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">scene</label>
                            <div class="input-group input-group-dynamic">
                                <select name="scene" class="form-control" >
                                    <c:forEach items="${scenes}" var="scene">
                                        <option value="${scene.id}">${scene.description}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">acteur</label>
                            <div class="input-group input-group-dynamic">
                                <select name="acteur" class="form-control" >
                                    <c:forEach items="${acteurs}" var="acteur">
                                        <option value="${acteur.id}">${acteur.nom_acteur}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">emotion</label>
                            <div class="input-group input-group-dynamic">
                                <select name="emotion" class="form-control" >
                                    <c:forEach items="${emotions}" var="emotion">
                                        <option value="${emotion.id}">${emotion.emotionname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>


                        <div style="margin: 5px;">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-6" style="padding-left: 0px;"><label class="form-label">debut</label><input class="form-control" type="time" name="debut"></div>
                                    <div class="col-md-6"><label class="form-label">fin</label><input class="form-control" type="time" name="fin" style="padding-left: 0px;padding-right: 0PX;"></div>
                                </div>
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">duree</label>
                            <div class="input-group input-group-dynamic">
                                <input name="duree" class="form-control" type="number">
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">action</label>
                            <div class="input-group input-group-dynamic">
                                <textarea name="action" class="form-control" id="message" rows="4"></textarea>
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
<jsp:include page="../Footer.jsp" />