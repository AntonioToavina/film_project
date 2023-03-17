<%--
  Created by IntelliJ IDEA.
  User: randretsa
  Date: 2023-03-16
  Time: 19:51
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
                <h3 class="text-center">invalidite plateau</h3>
                <form role="form" action="action" id="contact-form" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="mb-4">
                            <label class="form-label">le plateau</label>
                            <div class="input-group input-group-dynamic">
                                <select name="plateau" class="form-control" onchange="load_plateau()" id="plato">
                                    <c:forEach items="${plateaux}" var="plateau">
                                        <option value="${plateau.id}">${plateau.location}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">date d'indisponibilite</label>
                            <div class="input-group input-group-dynamic">
                                <input name="date" class="form-control" type="date">
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label">observation</label>
                            <div class="input-group input-group-dynamic">
                                <textarea name="observation" class="form-control" id="message" rows="4"></textarea>
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
    <table class="table align-items-center mb-0">
        <thead>
        <tr>
            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">localisation</th>
            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">observation</th>
            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">date invalide</th>
        </tr>
        </thead>

        <tbody id="t_body">

        </tbody>

    </table>

</section>


<script>

    function load_plateau(){
    const plateau = document.getElementById("plato");
    const tbody = document.getElementById("t_body");
    tbody.innerHTML = "";
    console.log(plateau.value);
    // First create an XMLHttprequest object
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "${pageContext.request.contextPath}/invalid-plateau-list/"+plateau.value, true);
    xhr.getResponseHeader("Content-type", "application/json");

    xhr.onload = function() {
        const obj = JSON.parse(this.responseText);
            obj.map((element)=>{

                const tr = document.createElement("tr");

                const localisation = document.createElement("td");
                localisation.innerHTML = element.plateau.location;
                const description = document.createElement("td");
                description.innerHTML= element.observation;
                const prix = document.createElement("td");
                prix.innerHTML= element.notavailabledate;

                tr.appendChild(localisation);
                tr.appendChild(description);
                tr.appendChild(prix);

                tbody.appendChild(tr);
            })

    }

    xhr.send();

    }
</script>

</body>
<jsp:include page="../Footer.jsp" />