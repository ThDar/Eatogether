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

<script>

 
  function statusChangeCallback(response) {
  
    if (response.status === 'connected') {
    	console.log('Logged in and authenticated');
   
    //	 window.location.href="Connexion?acces_token="+ response.authResponse.accessToken;
    
    //	setElements(true);
  
    } else {
    	console.log('NOT Logged');
    //	setElements(false);
    //	FB.login();
    	
   //   document.getElementById('status').innerHTML = 'Please log ' +
    //    'into this app.';
    }
    
  }
  
/*  function setElements(isLoggedIn){
	  
	  if(isLoggedIn){
          document.getElementById('fb_btn').style.display = 'none';
          document.getElementById('profile').style.display = 'block';
          document.getElementById('logout').style.display = 'block';
         
        } else {
          document.getElementById('fb_btn').style.display = 'block';
          document.getElementById('profile').style.display = 'none';
       document.getElementById('logout').style.display = 'none';
         
        }
	  
  }*/
  
  function test(){	
	  FB.getLoginStatus(function(response) {
	     
		  if (response.status === 'connected') {
			  window.location.href="Connexion?acces_token="+ response.authResponse.accessToken;}
		  
	    });
	  

  }

 
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '717842305245487',
      cookie     : true,    
      xfbml      : true, 
      version    : 'v3.1' 
    });

    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
  
  
  function logout(){
	  FB.logout();
  }
  
  
</script>
	 
 	<script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/recherche.js"></script>
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
                        <form class="form-wrap mt-4" method="post" action="Connexion" id="cnx">
                        <br>
    							
    							<div class="row d-flex justify-content-center">
    							<div class="col-md-10">
    								    <input type="text" id="pseudo" name="pseudo" placeholder="E-mail" required="true" class="btn-group1"/>
    								</div>
    							</div>     
      							<br>
     								
   									 <div class="row d-flex justify-content-center">
    							<div class="col-md-10">
      								<input type="password" id="password" name="password" placeholder="Mot de Passe" class="btn-group1" required="true"/>
      								</div></div><br>
      							
      							
      									<div class="row d-flex justify-content-center">
    							<div class="col-md-10">
    				
      									 <p class="message"><label>Not registered?</label> <a href="inscription.jsp">Create an account</a></p>
                                  
                                        <button type="submit" class="btn-form">Connexion<i class="pe-7s-angle-right"></i></button>
                                  <div id="profile">

    <div  class="fb-login-button" scope="public_profile,email,user_birthday,user_gender" data-onlogin="test();" data-max-rows="1" data-size="large" data-button-type="continue_with" data-show-faces="false" data-auto-logout-link="true" data-use-continue-as="true"></div> 

			</div>  
			
			  
                                        </div></div>
                                         </form><br><br><br>
                                         <img class="img-responsive" src="images/foursquare1.png"><br>
                                    </div>
                            </div>
                       </div>
                </div>
    </section>
</body>
</html>