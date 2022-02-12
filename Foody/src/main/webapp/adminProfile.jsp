<%@page import="entites.orderlist"%>
<%@page import="daos.OrderDao"%>
<%@page import="daos.coverDao"%>
<%@page import="entites.cover"%>
<%@page import="entites.Food"%>
<%@page import="daos.FoodDao"%>
<%@page import="helper.Massage"%>
<%@page import="entites.user"%>
<%@page errorPage="ErrorPage.jsp" %>

<% user user =(user)session.getAttribute("user");

if(user==null){

	Massage massage = new Massage("Login First.","exclamation-triangle", "Red");
	
	
	HttpSession session1=request.getSession();
	session1.setAttribute("msg", massage);
		 response.sendRedirect("homepage.jsp");
	
}

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- font awsome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<title><%=user.getName() %></title>
</head>

<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="mediaStyle.css">
<style>
<!--
input{
border: none;
padding-left:20px;
}

input:focus{
  
 outline: none;
  
}
.AdminNav{
font-size: 20px;
padding: 10px;
}
-->
</style>

<body>


<!-- navbar -->


<nav class="navbar justify-content-between align-content-center shadow-s">


  <a style="cursor: pointer;" onclick="openNav()" class="navbar-brand fa fa-pizza-slice mr-2">Profile</a>
 

  <form autocomplete="off" action="SearchFood" method="post" class="form-inline autocomplete">
  <div class="serach-btn">
    <input id="myInput" name="search"  style="padding-left:20px; " class="ser mr-5 autocomplete" placeholder="Search Food..." aria-label="Search">
   <button  type="submit" style="color:black; background: transparent; border: none;outline-focus: none;" class="fas fa-search"></button>
 </div>
  </form>
 
</nav>

<!-- massage -->
<% Massage msg = (Massage)session.getAttribute("msg"); %>

 <% if(msg!=null){
%>
	<div class="alert <%= msg.getCss() %>" role="alert">
	<i class="fa fa-<%=msg.getIcon()%>"></i> <%= msg.getType() %>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
	

		</div>
		<%
		session.removeAttribute("msg");
}
		%>

<!-- sidebar bar  -->


<div id="mySidenav" class="sidenav shadow-L">
  <span style="cursor: pointer;" class="closebtn" onclick="closeNav()">&times;</span>

 <a  data-toggle="modal" data-target="#profile" ><i class="fa fa-user-circle mr-1"></i><%=user.getName() %></a>
 <a  href="homepage.jsp" ><i class="fa fa-plus-home mr-1"></i>Home</a>
 <a  data-toggle="modal" data-target="#orderList" >Orders</a>
 <a data-toggle="modal" data-target="#cover" ><i class="fas fa-image mr-1"></i>cover</a>
 <a data-toggle="modal" data-target="#foods" ><i class="fas fa-utensils mr-1"></i>Foods</a>
 <a data-toggle="modal" data-target="#services" ><i class="fab fa-stripe-s mr-1"></i>Services</a>
 
 
 <a  data-toggle="modal" data-target="#addpo" ><i class="fa fa-plus-circle mr-1"></i>Add Cover</a>
<a data-toggle="modal" data-target="#addser"><i class="fa fa-plus-circle mr-1"></i>Add Services</a>
<a data-toggle="modal" data-target="#addfo" ><i class="fa fa-plus-circle mr-1"></i>Add Foods</a>

<a href="Logout" ><i class="fa fa-sign-in-alt mr-1"></i>Logout</a>
 
</div>

<!-- order list -->


<div class="modal fade" id="orderList" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document"><div class="row">
  <div style="background: #1164ff;" class="container col-2">
  
  </div>
    <div style="border:none;border-radius: 0px;" class="col modal-content ">
      <div style="border: none;" class="modal-header">
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    
   <div class="container">
   
   <% OrderDao orderDao = new OrderDao(ConPro.gFactory());
   
  List<orderlist> order = orderDao.AllOrder();
   
   %>
   
   <%for(orderlist orl:order) {%>
   
   <div class="container d-flex justify-content-center">
   <h5><%=orl.getName() %> - </h5>
    <p>Status <i class="Green"> <%=orl.getOrderStatus() %></i></p>
  
   
   </div>
   <div class="container text-right">
   
   <a href="Orderdel?id=<%=orl.getUserId() %>" class="btn">Cancel</a>
     <a href="OrderRes?id=<%=orl.getUserId() %>" class="btn">Reseved</a>
   </div>
   <%} %>
   </div>
    
      </div>
     </div>
   
    </div>
  </div>
</div>



<!-- ------------admin profile ---------->



<div class="modal fade" id="profile" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document"><div class="row">
  <div style="background: #1164ff;" class="container col-2">
  
  </div>
    <div style="border:none;border-radius: 0px;" class="col modal-content ">
      <div style="border: none;" class="modal-header">
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    
     <div class="container">
    <form action="updateProfile" method="post">
    <input name="id" type="hidden" value="<%=user.getId()%>">
    
    <label>Name</label>
    <input name="name" type="text" class="form-control" value="<%=user.getName()%>">
    
    <label>Email</label>
    <input name="email" type="text" class="form-control" value="<%=user.getEmail()%>">
    
    <label>Phone</label>
    <input name="phone" type="text" class="form-control" value="<%=user.getPhone()%>">
    
    <label>Password</label>
    <input name="password" type="password" class="form-control" value="<%=user.getPassword()%>">
    <button type="submit" class="btn">Save And Update</button>
    </form>
     </div>
    
      </div>
     </div>
   
    </div>
  </div>
</div>


<!--  all lists -->

<!-- covers model list -->

<div class="modal fade" id="cover" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document"><div class="row">
  <div style="background: #1164ff;" class="container col-2">
  
  </div>
    <div style="border:none;border-radius: 0px;" class="col modal-content ">
      <div style="border: none;" class="modal-header">
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    
    <% coverDao cd = new coverDao(ConPro.gFactory());
    
   List<cover> co= cd.covers();
   
    %>
    
    <h5 class="m-4">Total PHotos : <%=co.size() %></h5>
    <%for(cover c : co){ %>
    
    <img class="m-4" style="width: 200px;object-fit:cover;" alt="" src="cover/<%=c.getImage()%>">
    
    <form action="UpdateCover" method="post" enctype="multipart/from-data">
    
    <input name="id" type="hidden" value="<%=c.getId() %>>">
    
    <label>Photo</label>
    <input name="image" type="file" class="form-control">
    
    <label>Caption Small</label>
    <input name="caps" class="form-control" value="<%=c.getCaptionS() %>">
    
     <label>Caption Large</label>
     <input name="capl" class="form-control" value="<%=c.getCaptionL() %>">
    
  
   <a href="DeleteCover?id=<%=c.getId() %>" class="btn">
   <i class="fas fa-trash-alt mr-1"></i>Delete</a>
   
     <button type="submit" class="btn Green">
     <i class="fas fa-edit mr-1"></i>Update</button>
    </form>
    <%} %>
      </div>
     </div>
   
    </div>
  </div>
</div>


<!-- foods model list -->

<div class="modal fade" id="foods" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document"><div class="row">
  <div style="background: #1164ff;" class="container col-2">
  
  </div>
    <div style="border:none;border-radius: 0px;" class="col modal-content ">
      <div style="border: none;" class="modal-header">
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    
    
    <% FoodDao fd = new FoodDao(ConPro.gFactory());
    
    List<Food> Fo =  fd.Listfood();
    
    %>
    
    <h5 class="m-2">TOTAL FOODS <%=Fo.size() %></h5>
    
   
    <%for(Food fdd: Fo){ %>
   
   <div class="container-fluid mt-4">
   
    <label>ID - <%=fdd.getId()%></label>
   
   <form action="UpdateFood" method="post" enctype="multipart/form-data">
   
    <input type="hidden" name="Services" value="ServicesUpdate">
   <input type="hidden" name="id" value="<%=fdd.getId()%>">
   
   <label>Image</label>
    <input name="image" class="form-control" type="file" value="<%=fdd.getImage() %>">
   
   <label>Name</label>
    <input name="name" type="text" class="form-control" value="<%=fdd.getName()%>">
    
     <label>About</label>
    <input  name="about" type="text" class="form-control" value="<%=fdd.getAbout()%>">
    
    <div class="text-right mt-4">

   <a href="DeleteFood?id=<%=fdd.getId() %>" class="btn">
   <i class="fas fa-trash-alt mr-1"></i>Delete</a>
   
     <button type="submit" class="btn Green">
     <i class="fas fa-edit mr-1"></i>Update</button>
    
    </div>
   </form>
   
   </div>
    <%} %>
      </div>
     </div>
   
    </div>
  </div>
</div>


<!-- services model list -->

<div class="modal fade" id="services" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document"><div class="row">
  <div style="background: #1164ff;" class="container col-2">
  
  </div>
    <div style="border:none;border-radius: 0px;" class="col modal-content ">
      <div style="border: none;" class="modal-header">
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
 
    <% sevicesDao se = new sevicesDao(ConPro.gFactory());
    List<Services>  si=  se.listService();
    %>
    
      <h5 class="m-2">TOTAL SERVICES <%=si.size() %></h5>
    
   
    <%for(Services serr: si){ %>
   
   <div class="container-fluid mt-4">
   
    <label>ID - <%=serr.getIdd() %></label>
   
   <form action="UpdateServices" method="post">
   
  
   <input type="hidden" name="id" value="<%=serr.getIdd() %>">
   
   <label>ICon</label>
    <input name="Icon" class="form-control" type="text" value="<%=serr.getLogo() %>">
   
   <label>Name</label>
    <input name="name" type="text" class="form-control" value="<%=serr.getName() %>">
    
     <label>About</label>
    <input  name="about" type="text" class="form-control" value="<%=serr.getAbout() %>">
    
    <div class="text-right mt-4">

   <a href="DeleteServices?id=<%=serr.getIdd() %>" class="btn">
   <i class="fas fa-trash-alt mr-1"></i>Delete</a>
   
     <button type="submit" class="btn Green">
     <i class="fas fa-edit mr-1"></i>Update</button>
    
    </div>
   </form>
   
          </div>
          <%} %>
        </div>
     </div>
   
    </div>
  </div>
</div>




<!--------------- add photos Modal----------- -->


<div class="modal fade" id="addpo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document"><div class="row">
  <div style="background: #1164ff;" class="container col-2">
  
  </div>
    <div style="border:none;border-radius: 0px;" class="col modal-content ">
      <div style="border: none;" class="modal-header">
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <h3 class="text-center m-4">Add Cover Photos</h3>
    <!-- add photos forms -->
    <form action="saveCover" method="post" enctype="multipart/form-data">
    <label>ADD PHOTOS</label>
   <input name="image" type="file" class="form-control" >
    <label>ADD Captions Large</label>
   <input name="captionL" type="text" class="form-control" placeholder="Enter here....">
    <label>ADD Small</label>
   <input name="captionS" type="text" class="form-control" placeholder="Enter here....">
    <label>ADD button name</label>
   <input type="text" class="form-control" placeholder="Enter here....">
   <button type="submit" class="btn">Save</button>
   </form>
    
    
      </div>
     </div>
   
    </div>
  </div>
</div>

<!-- -------------add services model--------------- -->

<div class="modal fade" id="addser" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document"><div class="row">
  <div style="background: #1164ff;" class="container col-2">
  
  </div>
    <div style="border:none;border-radius: 0px;" class="col modal-content ">
      <div style="border: none;" class="modal-header">
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    <!-- add services forms -->
    <form action="Services" method="post">
       <label>ADD Logo</label>
    <input type="text" class="form-control" name="Logo" placeholder="Enter Here...">
    <label>ADD Name</label>
    <input type="text" class="form-control" name="Name" placeholder="Enter Here...">
     <label>ADD About</label>
    <input type="text" class="form-control" name="About" placeholder="Enter Here...">
    <button class="btn" type="submit">Add</button>
    </form>
      </div>
     </div>
   
    </div>
  </div>
</div>


<!-- -------------add foods model--------------- -->

<div class="modal fade" id="addfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document"><div class="row">
  <div style="background: #1164ff;" class="container col-2">
  
  </div>
    <div style="border:none;border-radius: 0px;" class="col modal-content ">
      <div style="border: none;" class="modal-header">
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
    <!-- add foods forms -->
     <form action="Food" method="post" enctype="multipart/form-data">
       <label>ADD Photo</label>
    <input type="file" class="form-control" name="image" placeholder="Enter Here...">
    <label>ADD Name</label>
    <input type="text" class="form-control" name="Name" placeholder="Enter Here...">
     <label>ADD About</label>
    <input type="text" class="form-control" name="About" placeholder="Enter Here...">
      <label>ADD Price</label>
    <input type="number" class="form-control" name="price" placeholder="Enter Here...">
    <button class="btn" type="submit">Add</button>
    </form>
    
      </div>
     </div>
   
    </div>
  </div>
</div>

<%@include file="services.jsp" %>

<%@include file="foods.jsp" %>


<%@include file="Footer.jsp" %>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script type="text/javascript" src="javafile.js"></script>
 <script type="text/javascript">

 function autocomplete(inp, arr) {
   /*the autocomplete function takes two arguments,
   the text field element and an array of possible autocompleted values:*/
   var currentFocus;
   /*execute a function when someone writes in the text field:*/
   inp.addEventListener("input", function(e) {
       var a, b, i, val = this.value;
       /*close any already open lists of autocompleted values*/
       closeAllLists();
       if (!val) { return false;}
       currentFocus = -1;
       /*create a DIV element that will contain the items (values):*/
       a = document.createElement("DIV");
       a.setAttribute("id", this.id + "autocomplete-list");
       a.setAttribute("class", "autocomplete-items");
       /*append the DIV element as a child of the autocomplete container:*/
       this.parentNode.appendChild(a);
       /*for each item in the array...*/
       for (i = 0; i < arr.length; i++) {
         /*check if the item starts with the same letters as the text field value:*/
         if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
           /*create a DIV element for each matching element:*/
           b = document.createElement("DIV");
           /*make the matching letters bold:*/
           b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
           b.innerHTML += arr[i].substr(val.length);
           /*insert a input field that will hold the current array item's value:*/
           b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
           /*execute a function when someone clicks on the item value (DIV element):*/
           b.addEventListener("click", function(e) {
               /*insert the value for the autocomplete text field:*/
               inp.value = this.getElementsByTagName("input")[0].value;
               /*close the list of autocompleted values,
               (or any other open lists of autocompleted values:*/
               closeAllLists();
           });
           a.appendChild(b);
         }
       }
   });
   /*execute a function presses a key on the keyboard:*/
   inp.addEventListener("keydown", function(e) {
       var x = document.getElementById(this.id + "autocomplete-list");
       if (x) x = x.getElementsByTagName("div");
       if (e.keyCode == 40) {
         /*If the arrow DOWN key is pressed,
         increase the currentFocus variable:*/
         currentFocus++;
         /*and and make the current item more visible:*/
         addActive(x);
       } else if (e.keyCode == 38) { //up
       
         currentFocus--;
         /*and and make the current item more visible:*/
         addActive(x);
       } else if (e.keyCode == 13) {
         /*If the ENTER key is pressed, prevent the form from being submitted,*/
         e.preventDefault();
         if (currentFocus > -1) {
           /*and simulate a click on the "active" item:*/
           if (x) x[currentFocus].click();
         }
       }
   });
   function addActive(x) {
     /*a function to classify an item as "active":*/
     if (!x) return false;
     /*start by removing the "active" class on all items:*/
     removeActive(x);
     if (currentFocus >= x.length) currentFocus = 0;
     if (currentFocus < 0) currentFocus = (x.length - 1);
     /*add class "autocomplete-active":*/
     x[currentFocus].classList.add("autocomplete-active");
   }
   function removeActive(x) {
     /*a function to remove the "active" class from all autocomplete items:*/
     for (var i = 0; i < x.length; i++) {
       x[i].classList.remove("autocomplete-active");
     }
   }
   function closeAllLists(elmnt) {
     /*close all autocomplete lists in the document,
     except the one passed as an argument:*/
     var x = document.getElementsByClassName("autocomplete-items");
     for (var i = 0; i < x.length; i++) {
       if (elmnt != x[i] && elmnt != inp) {
         x[i].parentNode.removeChild(x[i]);
       }
     }
   }
   /*execute a function when someone clicks in the document:*/
   document.addEventListener("click", function (e) {
       closeAllLists(e.target);
   });
 }

 /*An array containing all the country names in the world:*/
 <%  FoodDao daoss = new FoodDao(ConPro.gFactory());

 List<Food> ctlist = daoss.Listfood();

 %>

 var countries = [

 <% for(Food cr4:  ctlist){%>

 "<%=cr4.getName()%>",

 <% } %>

 ];

 /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
 autocomplete(document.getElementById("myInput"), countries);

 console.log("hello");

 /* Set the width of the side navigation to 250px */
 function openNav() {
   document.getElementById("mySidenav").style.width = "250px";
 }

 /* Set the width of the side navigation to 0 */
 function closeNav() {
   document.getElementById("mySidenav").style.width = "0";
 }
 
 </script>
</body>
</html>