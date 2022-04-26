 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <c:set var="currentCategoryId" value="0" scope="page"/>

  <div class="filters">
     <div>
        <form method="post" action="${pageContext.request.contextPath}/controller?command=direct_lot_by_category">
           <input  name="categoryId" value="0" type="hidden">
            <button class="button-ref" id="button0" onclick="sessionStorage.setItem('currentCategoryId', 0)" type="submit">All categories</button>
        </form>
     </div>
     <c:forEach items="${sessionScope.categories}" var="category" varStatus="loop">
        <div>
           <form method="post" action="${pageContext.request.contextPath}/controller?command=direct_lot_by_category">
             <input  name="categoryId" value="${category.id}" type="hidden">
             <button class="button-ref" id="button${category.id}" onclick="sessionStorage.setItem('currentCategoryId', ${category.id})" type="submit">${category.name}</button>
             </form>
           </div>
     </c:forEach>

  </div>

     <style>
         .button-ref {
             border: none;
             text-decoration: underline;
             background-color: white;
             font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
             text-transform: uppercase;
             font-size: 12px;
         }

         .button-ref:hover {
             color: grey;
             cursor: pointer;

         }

         .filters {
             display: grid;
             position: relative;
             margin: 2% 7% 1%;
             justify-content: center;
             grid-template-columns: repeat(auto-fill, minmax(10rem, 10rem));
             gap: 1rem;
             grid-gap: 1rem;
         }
     </style>

    <script>

    document.addEventListener('DOMContentLoaded', () => {
      const currentCategoryId =sessionStorage.getItem("currentCategoryId");
      if (currentCategoryId == null) {
      document.getElementById("button0").style.fontWeight="bold";
        } else {
        document.getElementById("button"+ currentCategoryId).style.fontWeight="bold";
        }

//      for (let i=0; i<"${sessionScope.categories.size()}"; i++) {

//       document.getElementById("button"+ i).onclick=function(e){sessionStorage.setItem("currentCategoryId", 1)};

//      }
    });
   </script>