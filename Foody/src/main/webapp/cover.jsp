
<%@page import="entites.cover"%>
<%@page import="java.util.List"%>
<%@page import="helper.ConPro"%>
<%@page import="daos.coverDao"%>
<%

coverDao dao = new coverDao(ConPro.gFactory());
List<cover> list =dao.covers();

%>
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
  
  <div class="carousel-item active">
      <img src="cover/pexels-karolina-grabowska-4047213.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
      <div class=" text-left">
        <h5>First Hedden</h5>
        <p>Some representative placeholder content for the first slide.</p>
        <button data-toggle="modal" data-target="#login" class="btnOder">LOGIN NOW</button>
        </div>
      </div>
    </div>
  
  <%for(cover cover:list){ %>
    <div class="carousel-item">
      <img  src="cover/<%=cover.getImage() %>" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
       <div class=" text-left">
        <h5><%=cover.getCaptionL() %></h5>
        <p><%=cover.getCaptionS() %></p>
         <button data-toggle="modal" data-target="#login" class="btnOder">ORDER NOW</button>
      </div>
      </div>
    </div>
    <%} %>
  
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>