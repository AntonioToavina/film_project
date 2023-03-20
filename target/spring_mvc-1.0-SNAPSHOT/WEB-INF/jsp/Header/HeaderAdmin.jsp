<jsp:include page="Header.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-white py-3">
  <div class="container">
    <a class="navbar-brand" href="https://demos.creative-tim.com/material-kit/presentation" rel="tooltip" title="Designed and Coded by Creative Tim" data-placement="bottom" target="_blank">
      Spring MVC
    </a>
    <button class="navbar-toggler shadow-none ms-2" type="button" data-bs-toggle="collapse" data-bs-target="#navigation" aria-controls="navigation" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon mt-2">
          <span class="navbar-toggler-bar bar1"></span>
          <span class="navbar-toggler-bar bar2"></span>
          <span class="navbar-toggler-bar bar3"></span>
        </span>
    </button>
    <div class="collapse navbar-collapse w-100 pt-3 pb-2 py-lg-0 ms-lg-12 ps-lg-5" id="navigation">
      <ul class="navbar-nav navbar-nav-hover ms-auto">

        <li class="nav-item dropdown dropdown-hover mx-2 ms-lg-5">
          <a class="nav-link ps-2 d-flex justify-content-between cursor-pointer align-items-center" id="dropdownMenuPages1" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="material-icons opacity-6 me-2 text-md">dashboard</i>
            Planning
            <img src="${pageContext.request.contextPath}/resources/theme/assets/img/down-arrow-dark.svg" alt="down-arrow" class="arrow ms-auto ms-md-2">
          </a>
          <div class="dropdown-menu ms-n3 dropdown-menu-animation dropdown-md p-3 border-radius-lg mt-0 mt-lg-3" aria-labelledby="dropdownMenuPages1">
            <div class="d-none d-lg-block">
              <h6 class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1">
                Planning
              </h6>
              <a href="/planning/suggest_form" class="dropdown-item border-radius-md">
                <span>Suggestion</span>
              </a>
              <a href="/planning/suggest_list" class="dropdown-item border-radius-md">
                <span>Planning</span>
              </a>

            </div>
          </div>
        </li>

        <li class="nav-item dropdown dropdown-hover mx-2 ms-lg-5">
          <a class="nav-link ps-2 d-flex justify-content-between cursor-pointer align-items-center" id="dropdownMenuPages2" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="material-icons opacity-6 me-2 text-md">list</i>
            Listes
            <img src="${pageContext.request.contextPath}/resources/theme/assets/img/down-arrow-dark.svg" alt="down-arrow" class="arrow ms-auto ms-md-2">
          </a>
          <div class="dropdown-menu ms-n3 dropdown-menu-animation dropdown-md p-3 border-radius-lg mt-0 mt-lg-3" aria-labelledby="dropdownMenuPages2">
            <div class="d-none d-lg-block">
              <h6 class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1">
                Listes
              </h6>
              <a href="/to_listesActeurs" class="dropdown-item border-radius-md">
                <span>Acteurs</span>
              </a>

            </div>
          </div>
        </li>
        <li class="nav-item dropdown dropdown-hover mx-2 ms-lg-5">
          <a class="nav-link ps-2 d-flex justify-content-between cursor-pointer align-items-center" id="dropdownMenuPages3" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="material-icons opacity-6 me-2 text-md">add</i>
            Création
            <img src="${pageContext.request.contextPath}/resources/theme/assets/img/down-arrow-dark.svg" alt="down-arrow" class="arrow ms-auto ms-md-2">
          </a>
          <div class="dropdown-menu ms-n3 dropdown-menu-animation dropdown-md p-3 border-radius-lg mt-0 mt-lg-3" aria-labelledby="dropdownMenuPages3">
            <div class="d-none d-lg-block">
              <h6 class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1">
                Création
              </h6>
              <a href="/index" class="dropdown-item border-radius-md">
                <span>Scene</span>
              </a>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</nav>