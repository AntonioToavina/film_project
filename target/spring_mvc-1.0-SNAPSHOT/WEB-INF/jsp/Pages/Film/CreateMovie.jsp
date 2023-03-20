
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../Header/Header.jsp" />
<jsp:include page="../../Header/HeaderAdmin.jsp" />

<body>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <h3 class="text-center">Creation film</h3>
                <c:if test="${error!=null}">
                    <h5 style="color: red" class="text-center" >${error}</h5>
                </c:if>
                <form role="form" action="${pageContext.request.contextPath}/films" id="contact-form" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <label class="form-label">Title</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="text" name="title"  />
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Description</label>
                            <div class="input-group input-group-dynamic">
                                <textarea name="description" class="form-control" id="message" rows="4"></textarea>
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Catégorie du film</label>
                            <div class="input-group input-group-dynamic">
                                <select name="filmctg_id" class="form-control">
                                    <c:forEach items="${movieCategs}" var="filmctg">
                                        <option value="${filmctg.id}">${filmctg.ctgname}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Fond</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="number" name="fond" step="any"  />
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label">Date de production</label>
                            <div class="input-group input-group-dynamic">
                                <input class="form-control" type="date" name="production_date" />
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
<jsp:include page="../../Footer.jsp" />