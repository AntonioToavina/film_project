<%--
  Created by IntelliJ IDEA.
  User: randretsa
  Date: 2023-03-16
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header/Header.jsp" />
<jsp:include page="../Header/HeaderAdmin.jsp" />
<%@page import="com.antonio.spring_mvc.Service.Utility" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<section>
  <div class="container">
    <div class="row">
      <div class="col-lg-8 mx-auto d-flex justify-content-center flex-column">
          <h1 class="text-center">Liste des plateaux</h1>

          <div class="table-responsive">
            <table class="table align-items-center mb-0">
              <thead>
              <tr>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">localisation</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">description</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">prix</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">categorie</th>
              </tr>
              </thead>
              <tbody>

              <c:forEach items="${plateaux}" var="plateau">
                <tr>
                  <td>${plateau.location}</td>
                  <td>${plateau.description}</td>
                  <td>${plateau.price}</td>
                  <td>${plateau.plateauctg.ctgname}</td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>


      </div>
    </div>
  </div>

</section>
</body>
<jsp:include page="../Footer.jsp" />
