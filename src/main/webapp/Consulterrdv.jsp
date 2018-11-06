<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${sessionScope.login == null}">
    <jsp:forward page = "login.jsp" />
</c:if>
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css"
   integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
   crossorigin=""/>

<script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js"
   integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA=="
   crossorigin=""></script>
  
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,900" rel="stylesheet">
    <!-- Simple line Icon -->
    <link rel="stylesheet" href="css/simple-line-icons.css">
    <!-- Themify Icon -->
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- Hover Effects -->
   <!--  <link rel="stylesheet" href="css/set1.css">  -->
    <!-- Main CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/rendezvous.css">
   
</head>
<body>
 <c:import url="header1.jsp"></c:import>
    <section class="main-block">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Eatogether</h2>
            <h3 class="section-subheading text-muted">Partagez vos repas préférés dans un cadre conviviale..</h3>
            <br>
          </div>
        </div>
        <div class="row text-center">
          <div class="col-md-4">
            <span class="fa-stack fa-4x">
              <img class="img-rounded" src="images/view-list.png" alt="">
            </span>
            <h4 class="service-heading">Consulter vos rendez-vous</h4>
            <p class="text-muted">Graçe à Eatogether , vous pouvez consulter vos rendez-vous </p>
          </div>
          <div class="col-md-4">
            <span class="fa-stack fa-4x">
             <img class="img-rounded" src="images/edit-document.png" alt="">
            </span>
            <h4 class="service-heading">Modifier votre rendez-vous</h4>
            <p class="text-muted">Vous pouvez à travers notre application , modifier la date de tes rendez-vous </p>
          </div>
          <div class="col-md-4">
            <span class="fa-stack fa-4x">
              <img class="img-rounded" src="images/delete-button.png" alt="">
            </span>
            <h4 class="service-heading">Supprimer un rendez-vous</h4>
            <p class="text-muted">Eatogether offre à ses utilisateurs la possiblité de supprimer ton propre Rendez-vous </p>
          </div>
        </div>
      </div>
         
    </section>
    
      <section class="main-block light-bg">
        <div class="container">
              <div class="row justify-content-center">
            
                <div class="col-md-5">
                
                    <div class="styled-heading">
                           <h3>Mes Rendez-vous</h3>
                         
                    </div>
                    
                </div>
            </div>
           
                <div class="row" id="row1">
                   
                </div>
           
            <div class="row justify-content-center">
                <div class="col-md-4">
                </div>
            </div>
        </div>
    </section>

    

    
    <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Détails sur le lieu </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal" id="close2">Close</button>
      </div>
    </div>
  </div>
</div>
    
    
 <div class="modal fade bd-example-modal-lg" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Détails sur le lieu </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form method="post" action="UpdateRendezVousServlet">
      <div class="modal-body">
 	<div class="form-group" id="form-group1">
	<label for="recipient-name" class="col-form-label">Date</label>
	<input type="date" class="form-control" id="date" name="date">
	 </div>
	 
	  </div>
     <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="close1">Close</button>
        <button type="submit" class="btn btn-danger">Confirmer la modification</button>    
      </div>
      </form>
    </div>
  </div>
</div>   
 <c:import url="footer.jsp"></c:import>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/consulterrdv.js"></script>


</body>
</html>