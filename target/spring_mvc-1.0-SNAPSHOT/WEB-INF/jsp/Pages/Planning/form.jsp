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
                <form role="form" action="/planning/suggest_list" id="contact-form" method="get" autocomplete="off">
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
                            <button type="button" class="btn bg-gradient-info" onclick="openSlideout()">Choisir Scènes</button>
                            <input type="hidden" name="selected-scenes" value="">
                            <input type="hidden" name="display-scenes" value="">
                            <div class="mb-4">
                                <label class="form-label">Scènes sélectionnées</label>
                                <div id="selected-scenes"></div>
                            </div>


                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn bg-gradient-dark w-100">Voir suggestion</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>



    <script>
        function openSlideout() {
            document.getElementById("slideout").classList.add("active");
        }

        function closeSlideout() {
            document.getElementById("slideout").classList.remove("active");
        }

        function updateSelectedScenes() {
            // récupérer toutes les cases à cocher cochées
            const checkboxes = document.querySelectorAll('#slideout input[type="checkbox"][name="scene_id[]"]:checked');

            // créer un tableau des ID de scènes sélectionnées
            const selectedScenes = [];
            const selectedScenesLabel = [];
            checkboxes.forEach((checkbox) => {
                selectedScenes.push(checkbox.value);
                selectedScenesLabel.push(checkbox.ariaLabel);
            });

            // mettre à jour la valeur de l'élément input caché
            const selectedScenesInput = document.querySelector('input[name="selected-scenes"]');
            selectedScenesInput.value = selectedScenes.join(',');

            const selectedScenesInputDisplay = document.querySelector('input[name="display-scenes"]');
            selectedScenesInputDisplay.value = selectedScenesLabel.join(', ');

            // afficher les scènes sélectionnées dans la div correspondante
            const selectedScenesDiv = document.querySelector('#selected-scenes');
            selectedScenesDiv.innerHTML = selectedScenesLabel.join(', ');
        }



        function handleCheckboxesClick(checkbox) {
            const checkboxes = document.querySelectorAll("tbody input[type='checkbox']");
            for (let i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = checkbox.checked;
            }
        }
    </script>







    <div id="slideout" class="slideout">
        <div class="slideout-header">
            <h5 class="slideout-title">Choisir Scènes</h5>
            <button type="button" class="close-btn" onclick="closeSlideout()">X</button>
        </div>
        <div class="slideout-body">
<%--            <div class="form-group">--%>
<%--                <label for="search-scenes">Rechercher une scène:</label>--%>
<%--                <input type="text" class="form-control" id="search-scenes" placeholder="Entrez le nom de la scène...">--%>
<%--            </div>--%>
            <div class="form-group">


                <div class="table-responsive">
                    <table class="table align-items-center mb-0">
                        <thead>
                        <tr>
                            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"><input onclick="handleCheckboxesClick(this)" type="checkbox"></th>
                            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Scène</th>
                            <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Film</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${scenes}" var="list">
                            <tr>
                                <td><input type="checkbox" name="scene_id[]" value="${list.id}" aria-label="${list.scene.description}"></td>
                                <td>${list.scene.description}</td>
                                <td>${list.scene.film.title}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="form-group">
                <button type="button" id="valider-btn" class="btn bg-gradient-info" onclick="updateSelectedScenes(); closeSlideout();">Valider</button>
            </div>
        </div>
    </div>





</section>
</body>
<jsp:include page="../../Footer.jsp" />