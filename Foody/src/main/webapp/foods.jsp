<%@page import="entites.Food"%>
<%@page import="java.util.List"%>
<%@page import="helper.ConPro"%>
<%@page import="daos.FoodDao"%>
<link rel="stylesheet" type="text/css" href="style.css">
<div class="container">
<h3 class="text-center m-5 t-color-1">Our Poplular Foods</h3>
<div class="row">
<% FoodDao fo = new FoodDao(ConPro.gFactory());
 List<Food> foo= fo.Listfood();
%>

<% for(Food food:foo){ %>
<div style="display: flex;justify-content: center;" class="col-md-4 ">

<div class="card mt-4 cardHover" style="width: 18rem;">

<div  class="p-2 w-100 color-2" style="position: absolute; opacity: 30%;color: white;cursor: default;">
   <h5> <%=food.getName() %></h5>
   </div>
<img class="card-img-top" style="object-fit:cover;" alt="" src="cover/<%=food.getImage() %>">

  <div class="card-body text-right">
  
  <div><i class="fas fa-rupee-sign mr-1"></i><i class="mr-3" style="font-weight: bold;font-size: 20px;"><%=food.getPrice() %>/- </i><a href="checkout?id=<%=food.getId() %>" class="btn btn-primary ">ORDER NOW</a> </div>  
  </div>
</div>

</div>
<%} %>


</div>
</div>