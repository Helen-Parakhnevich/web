 <%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  <div class="filters">
     <div>
        <form method="post" action="${pageContext.request.contextPath}/controller?command=direct_lot_by_category">
           <input  name="categoryId" value="0" type="hidden">
            <button class="button-ref" type="submit">All categories</button>
        </form>
     </div>
     <div>${currentFilter}</div>
         <c:forEach items="${sessionScope.categories}" var="category" varStatus="loop">
             <div>
                 <form method="post" action="${pageContext.request.contextPath}/controller?command=direct_lot_by_category">
                     <input  name="categoryId" value="${category.id}" type="hidden">
                     <button class="button-ref" id="button${loop.index}" type="submit">${category.name}</button>
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

//     document.addEventListener('DOMContentLoaded', () => {
//      for (let i=0; i<"${sessionScope.categories.size()}"; i++) {
//
//        document.getElementById("button"+ i).onclick=function(e){ e.target.style.background="red";};
//
//      }
//    });
   </script>