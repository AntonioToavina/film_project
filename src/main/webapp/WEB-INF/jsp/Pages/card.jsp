<div class="col col-md-2 col-1">
            <div class="card" style="max-width: 300px">
                <img src="${pub.photo}" class="card-img-top" alt="...">
                <div class="card-body">
                    <c:if test="${pub.categorie.idcategorie==1}" >
                        <c:set var = "color" scope = "session" value = "blue"/>
                    </c:if>
                    <c:if test="${pub.categorie.idcategorie==2}">
                        <c:set var = "color" scope = "session" value = "red"/>
                    </c:if>

                    <div style="background-color: ${color}">
                       <h3 style="color: white">${pub.categorie.categorie}</h3>
                    </div>
                    <h5 class="card-title">${pub.titre}</h5>
                    <p class="card-text">${pub.resumer}</p>
                    <p class="card-text">Creation :  ${Utility.formatDate(pub.datecreation)}</p>
                    <p class="card-text">Publication : ${Utility.formatTimestamp(pub.datepublication)} </p>
                </div>
            </div>
        </div>
