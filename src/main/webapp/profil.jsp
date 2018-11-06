<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${sessionScope.login == null}">
    <jsp:forward page = "login.jsp" />
</c:if>

<!DOCTYPE html>
<html>
<head>
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
  </style>

  <title>Mon profil</title>  
  
</head>

<body>


<script>

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
</script>

<div class="login-page">
  <div class="form">
    <form class="register-form" id="form1" method="post" action="Profil" >
    
    <input id="homme" name="gender" type="radio" value="homme" ${gender=='homme'?'checked':''}  /> Homme <br/>
     <input id="femme" name="gender" type="radio" value="femme" ${gender=='femme'?'checked':''}/> Femme <br/>
     
      <input id="pseudo" name="pseudo" type="text" value="${pseudo}" required="true"/>
      <input id="nom" name="nom" type="text" value="${nom}"/>
      <input id="prenom" name="prenom" type="text" value="${prenom}" required="true"/>
      <input id="date_naiss" name="date_naiss" type="date" value="${date_naiss}" required="true"/>    
   
    </form>
    
     <button onclick="check();" >Enregistrer</button>
     
  </div>
</div>


</body>
</html>