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
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,900" rel="stylesheet">
    <link rel="stylesheet" href="css/simple-line-icons.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/rendezvous.css">
   
</head>
<body>
 <c:import url="header.jsp"></c:import>
 
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
              <img class="img-rounded" src="images/speech.png" alt="">
            </span>
            <h4 class="service-heading">Messagerie instantanée</h4>
            <p class="text-muted">Graçe à Eatogether , vous pouvez échanger vos messages </p>
          </div>
          <div class="col-md-4">
            <span class="fa-stack fa-4x">
             <img class="img-rounded" src="images/couple.png" alt="">
            </span>
            <h4 class="service-heading">Gestion Rendez-vous</h4>
            <p class="text-muted">Vous pouvez à travers notre application , créer,joindre,annuler et modifier un rendez-vous de votre choix </p>
          </div>
          <div class="col-md-4">
            <span class="fa-stack fa-4x">
              <img class="img-rounded" src="images/resto.png" alt="">
            </span>
            <h4 class="service-heading">Recherche de lieu</h4>
            <p class="text-muted">Eatogether offre à ses utilisateurs la possiblité d'effectuer des recherches sur des lieux à fin de partager ses repas préférés </p>
          </div>
        </div>
      </div>
    </section>
   
   
   
       
    <section class="main-block light-bg">
        <div class="container">
            <div class="row justify-content-center">
            
                <div class="col-md-5">
                
                    <div class="styled-heading">
                        <img class="img-responsive" src="images/magnifier.png">
                         <br><br>
                          
                          <h4 class="service-heading">Notre Service</h4>
            			 <p class="text-muted">Notre site propose à ses utilisateurs une liste des meilleurs restaurants selon leurs localisations, et ce n’est pas tout ! Le plus important, c’est qu’il vous permettra de faire des rencontres avec d’autres utilisateurs en partageant vos repas préférés</p>
                         <a href="#" class="btn btn-secondary"><span class="ti-plus"></span> Lancer vos recherches ! </a><br><br>
                         <h3>Résultat de recherche</h3>
                         
                    </div>
                    
                </div>
            </div>
           
               <c:set var="count" value="0" scope="page" />
                <div class="row">
                <c:forEach items="${venue}" var="value">
                    <div class="col-md-4 featured-responsive">
                    <div class="featured-place-wrap">
							<div id="mapid${count}"></div>
							<script> var mymap${count} = L.map('mapid${count}').setView([${value.location.lat}, ${value.location.lng}], 20);
	    	    	 L.tileLayer('//{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
	    	    	     attribution: ' &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>',
	    	    	 }).addTo(mymap${count});
	    	    	 var marker${count} = L.marker([${value.location.lat}, ${value.location.lng}]).addTo(mymap${count});</script>
	    	    	 <style>
				#mapid${count} { height: 250px; }
					</style>
					<br>
					 <div class="featured-title-box">
					 <c:set var="count" value="${count + 1}" scope="page"/>
					 	<h6><c:out value="${value.name}" /></h6>
	    	    		<span class="icon-location-pin"></span><p> <c:out value="${value.location.country }" /> </p><br>
							<c:forEach items="${value.categories}" var="categorie">
						<span class="ti-bookmark"></span></span>	<p>	<c:out value="${categorie.name }" /> <p><br>
							</c:forEach>
							 <div class="bottom-icons">
							<a href="Recherche?id=${value.id}&name=${value.name}&lieu=${value.location.country}" class="btn btn-secondary" role="Plus de détails" id="btnid" value="<c:out value="${value.id}"/>">Plus de détails</a>
							<br> 
							
							</div>
                    </div>
                </div>
            </div>
           </c:forEach>
           </div> 
            <div class="row justify-content-center">
                <div class="col-md-4">
                    <div class="featured-btn-wrap">
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--//END FEATURED PLACES -->
   
   
   
    
    <section class="testimonials text-center bg-light">
      <div class="container">
        <h2 class="mb-5">Ce que les gens disent...</h2>
        <div class="row">
          <div class="col-lg-4">
            <div class="testimonial-item mx-auto mb-5 mb-lg-0">
              <img class="img-fluid rounded-circle mb-3" src="images/1.jpg" alt="">
              <h5>Zakaria </h5>
              <p class="font-weight-light mb-0">"Partagez vos repas"</p><br>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="testimonial-item mx-auto mb-5 mb-lg-0">
              <img class="img-fluid rounded-circle mb-3" src="images/3.jpg" alt="">
              <h5>Darine </h5>
              <p class="font-weight-light mb-0">"Rencontrez des nouvelles personnes"</p><br>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="testimonial-item mx-auto mb-5 mb-lg-0">
              <img class="img-fluid rounded-circle mb-3" src="images/3.jpg" alt="">
              <h5>Yassine</h5>
              <p class="font-weight-light mb-0">"Changez votre vie "</p><br>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--============================= ADD LISTING =============================-->
    <section class="main-block light-bg">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="add-listing-wrap">
                        <h2>Plusieurs personnes vous attend</h2>
                        <p>Trouvez la bonne personne !</p>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-4">
                    <div class="featured-btn-wrap">
                        <a href="rendezvous.jsp" class="btn btn-secondary"><span class="ti-plus"></span> Consulter </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/recherche.js"></script>
</body>

</html>
<div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Détails</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

 <c:import url="footer.jsp"></c:import>	
</body>
</html>