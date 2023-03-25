<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../Header/Header.jsp" />
<jsp:include page="../../Header/HeaderAdmin.jsp" />
<%@page import="com.antonio.spring_mvc.Service.Utility" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<section>

    <div class="container py-4">
        <form method="post" action="/planning/save">
        <div class="row">
            <div class="col-md-12 col-lg-4 col-xl-4">
                <div class="d-flex flex-column justify-content-center align-items-start h-100">
                    <div class="d-flex align-items-center p-3">
                        <div class="bs-icon-md bs-icon-rounded bs-icon-primary d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block bs-icon">
                            <i class="material-icons opacity-6 me-2 text-md ">schedule</i>
                        </div>
                        <div class="px-2">
                            <h6 class="mb-0">Debut</h6>
                            <p class="mb-0">${debut}</p>
                        </div>
                    </div>
                    <div class="d-flex align-items-center p-3">
                        <div class="bs-icon-md bs-icon-rounded bs-icon-primary d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block bs-icon">
                            <i class="material-icons opacity-6 me-2 text-md ">schedule</i>
                        </div>
                        <div class="px-2">
                            <h6 class="mb-0">Fin</h6>
                            <p class="mb-0">${fin}</p>
                        </div>
                    </div>
                    <div class="d-flex align-items-center p-3">
                        <div class="bs-icon-md bs-icon-rounded bs-icon-primary d-flex flex-shrink-0 justify-content-center align-items-center d-inline-block bs-icon">
                            <i class="material-icons opacity-6 me-2 text-md ">star</i>
                        </div>
                        <div class="px-2">
                            <h6 class="mb-0">Scènes</h6>
                            <p class="mb-0">${scenes}</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 mx-auto d-flex justify-content-center flex-column">

                <c:forEach items="${planning}" var="list">

                    <div class="card" style="margin: 20px">
                        <h5 class="card-header">${list.date}<input type="checkbox" class="form-check date-checkbox" onclick="toggleDateCheckboxes(this)" checked/></h5>
                        <div class="card-body">


                            <div class="table-responsive">
                                <table class="table align-items-center mb-0">
                                    <thead>
                                    <tr>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">

                                        </th>
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
                            <td>
                                <input type="checkbox" onchange="toggleHiddenInputs(this)" name="act_id" value="${act.act.id}" class="form-check checkbox" data-date="${list.date}" checked/>
                                <input type="hidden" name="date" value="${list.date}"/>
                                <input type="hidden" name="debut" value="${act.firstHour}"/>
<%--                                <input type="hidden" name="fin" value="${act.lastHour}"/>--%>
                            </td>
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


            <div class="col-lg-12 mx-auto d-flex justify-content-center flex-column">
                <button type="submit" class="btn bg-gradient-success w-100">Enregistrer</button>
                <button type="reset" class="btn bg-gradient-warning w-100">annuler</button>
            </div>




        </div>
        </form>
    </div>

</section>
</body>

<script>
    function toggleDateCheckboxes(checkbox) {
        const isChecked = checkbox.checked;
        const date = checkbox.parentElement.textContent.trim();
        const checkboxes = document.querySelectorAll('.checkbox[data-date="'+date+'"]');
        // checkboxes.forEach(cb =>
        //     cb.checked = isChecked
        // );
        checkboxes.forEach(cb => {
            cb.checked = isChecked;
            toggleHiddenInputs(cb)
        });

    }

    function toggleHiddenInputs(cb){
        const isChecked = cb.checked;

        const row = cb.closest('tr');
        const inputs = row.querySelectorAll('input[type="hidden"]');
        console.log(inputs)
        inputs.forEach(input => input.disabled = !isChecked);
    }

</script>
<jsp:include page="../../Footer.jsp" />
