<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		label{

			color: white;
		}

	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<script >

    function check(){
        var date_input = document.getElementById("date_naiss").value;

        var today = new Date();
        var century=new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1;
        var yyyy = today.getFullYear();
        var yyyy_century=today.getFullYear()-100;
        if(dd<10) { dd = '0'+dd }
        if(mm<10) { mm = '0'+mm }

        today = yyyy + '-' + mm + '-' + dd;
        century= yyyy_century + '-' + mm + '-' + dd;
        if (today < date_input || century > date_input ) {

            alert("Date de naissance doit etre inférieur à celle d'aujourd'hui et supérieur à celle d'il y a 100 ans");

        }else{
            var form = document.getElementById("form1");
            form.submit();
        }
    }
</script>git

<section class="slider d-flex align-items-center">
	<!-- <img src="images/slider.jpg" class="img-fluid" alt="#"> -->
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-md-12">
				<div class="slider-title_box">
					<div class="row">
						<div class="col-md-12">
							<div class="slider-content_wrap">
								<img class="img-responsive" src="images/logo1.png"><br>
								<h1>Eatogether</h1>
								<h5>Partagez vos repas préférés dans un cadre conviviale..</h5>
							</div>
						</div>
					</div>
					<form class="form-wrap mt-4"method="post" action="Inscription">
						<br>

						<div class="row d-flex justify-content-center">
							<div class="col-md-10">
								<input id="email" name="email" class="btn-group1" type="text" placeholder="Email" required="true"/>
							</div>
						</div>
						<div style="color:red !important" >

							<c:if test="${err == 'true'}">
								<c:out value="  L'utilisateur existe dèja"/>
							</c:if>

						</div><br>
						<div class="row d-flex justify-content-center">
							<div class="col-md-10">
								<input id="pseudo" name="pseudo" type="text" placeholder="Pseudo" class="btn-group1" required="true"/>
							</div></div><br>
						<div class="row d-flex justify-content-center">
							<div class="col-md-10">
								<input id="nom" name="nom" type="text" class="btn-group1" placeholder="Nom"/>
							</div></div><br>
						<div class="row d-flex justify-content-center">
							<div class="col-md-10">
								<input id="prenom" name="prenom" type="text"  class="btn-group1" placeholder="Prénom" required="true"/>
							</div></div><br>
						<div class="row d-flex justify-content-center">
							<div class="col-md-10">
								<input id="date_naiss" name="date_naiss" class="btn-group1" type="date" required="true"/>
							</div></div><br>

						<div class="row d-flex justify-content-center">
							<div class="col-md-10">

								<input id="homme" class="form-check-input" name="gender" class="btn-group1" value="homme" type="radio" checked /><label>&nbsp;Homme&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
								<input id="femme" class="form-check-input" name="gender" class="btn-group1" value="femme" type="radio" /><label>&nbsp;Femme&nbsp;</label><br/>

							</div>
						</div><br>


						<div class="row d-flex justify-content-center">
							<div class="col-md-10">
								<input id="password" name="password" class="btn-group1" type="password" placeholder="Mot de passe" required="true"/>
							</div></div><br>
						<div class="row d-flex justify-content-center">
							<div class="col-md-10">

								<p class="message"><label>Already registered?</label> <a href="login.jsp">Sign In</a></p>


							</div></div>
					</form><br>
					<button onClick="check()" class="btn-form">Inscription<i class="pe-7s-angle-right"></i></button>
					<br><br>
					<img class="img-responsive" src="images/foursquare1.png"><br>
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