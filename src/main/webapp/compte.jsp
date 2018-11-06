<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${sessionScope.login == null}">
    <jsp:forward page = "login.jsp" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion de compte</title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style>
    @import url(https://fonts.googleapis.com/css?family=Roboto:300);

    .login-page {
      width: 500px;
      padding: 20% 0 0;
      margin: auto;
    }
    .form {
      position: relative;
      z-index: 1;
      background: #FFFFFF;
      max-width: 500px;
      margin: 0 auto 100px;
      padding: 45px;
      text-align: center;
      box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }
    .form input {
      font-family: "Roboto", sans-serif;
      outline: 0;
      background: #f2f2f2;
      width: 100%;
      border: 0;
      margin: 0 0 15px;
      padding: 15px;
      box-sizing: border-box;
      font-size: 14px;
    }
    .form button {
      font-family: "Roboto", sans-serif;
      text-transform: uppercase;
      outline: 0;
      background: #4CAF50;
      width: 100%;
      border: 0;
      padding: 15px;
      color: #FFFFFF;
      font-size: 14px;
      webkit-transition: all 0.3 ease;
      -transition: all 0.3 ease;
      cursor: pointer;
    }
    .form button:hover,.form button:active,.form button:focus {
      background: #43A047;
    }
    .form .message {
      margin: 15px 0 0;
      color: #b3b3b3;
      font-size: 12px;
    }
    .form .message a {
      color: #4CAF50;
      text-decoration: none;
    }
    .form .register-form {

    }
    .container {
      position: relative;
      z-index: 1;
      max-width: 300px;
      margin: 0 auto;
    }
    .container:before, .container:after {
      content: "";
      display: block;
      clear: both;
    }
    .container .info {
      margin: 50px auto;
      text-align: center;
    }
    .container .info h1 {
      margin: 0 0 15px;
      padding: 0;
      font-size: 36px;
      font-weight: 300;
      color: #1a1a1a;
    }
    .container .info span {
      color: #4d4d4d;
      font-size: 12px;
    }
    .container .info span a {
      color: #000000;
      text-decoration: none;
    }
    .container .info span .fa {
      color: #EF3B3A;
    }
    body {
      background-image: url("img.jpg"); /* fallback for old browsers */
      background-size: cover ;
      font-family: "Roboto", sans-serif;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
    }

    .gender  {
      display: inline;
      width : 10% ;
    }

    .logo {
      position: relative;
      top: 	150px;
      z-index: 1;
      background: #FFFFFF;
      max-width: 500px;
      margin: 0 auto 100px;
      padding: 45px;
      text-align: center;
      box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }
    
    .alert {
    
    padding: 20px;
    background-color: #f44336;
    color: white;
    opacity: 1;
    transition: opacity 0.6s;
    margin-bottom: 15px;
}
.alert.warning {background-color: #ff9800;}
  </style>
</head>
<body>
<script>

function check(){
	var fistInput = document.getElementById("password_nouveau").value;
	var secondInput = document.getElementById("password_nouveau2").value;

	
	
	if (fistInput > secondInput ) {
	
		alert("Les nouveaux mot de passe ne correspondent pas");		
		
	}else if(fistInput < secondInput) {
	      	alert("Les nouveaux mot de passe ne correspondent pas");
	    }else{
	
		  sub();		}
	
	 
}

function sub(){
	var form = document.getElementById("form1");
	form.submit();
	
}


</script>

<div class="login-page">
  <div class="form">
  
        <c:if test="${err != null}">
          <br>
          <div class="alert">  ${err}  </div>       
        </c:if>    
  
  
  
    <form id="form1" method="post" class="register-form" action="Compte" >
    
     
      <input id="password_ancien" name="password_ancien" type="password" placeholder="Tapez votre ancien mot de passe" required="true"/>
      <br/>
      <input id="password_nouveau" name="password_nouveau" type="password" placeholder="Tapez votre nouveau mot de passe"/>
      <input id="password_nouveau2" name="password_nouveau2" type="password" placeholder="Retapez votre nouveau mot de passe" />
     
       </form>
      <button id="btn" onclick="check();" >MODIFIER</button>
      
     
      
  
  </div>
</div>


</body>
</html>