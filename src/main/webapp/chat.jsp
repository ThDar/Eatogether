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
    
        <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <link rel="stylesheet" href="css/chat.css">
     <link rel="stylesheet" href="css/rendezvous.css">
 	<script>var photo ='${sessionScope.picture_user}'</script>
</head>
<body>
<script src="js/chat.js"></script>
<div id="websocket">

</div>
<c:import url="header1.jsp"></c:import>    
<div class="container">
  <div class="row justify-content-center">
            
                <div class="col-md-5">
                
                    <div class="styled-heading">
                        <img class="img-responsive" src="images/chat.png">
                         <br><br>
                          
                          <h4 class="service-heading">Partagez vos messages instantanement !</h4>
            			 <p class="text-muted">Eatogether offre à ses utilisateurs un messenger qui permet d'échanger les messages et s'orginser pour un rendez-vous</p>
                         <h3>Lancez vos discussion !</h3>
                         
                    </div>
                    
                </div>
            </div>
<br><br>
<div class="messaging">
      <div class="inbox_msg">
     
        <div class="inbox_people">
          <div class="headind_srch">
            <div class="recent_heading">
              <h4>Recent</h4>
            </div>
          </div>
          <div class="inbox_chat" id="inbox_chat">
          </div>
        </div>
        <div class="mesgs">
          <div class="msg_history" id="msg_history">
            
          </div>
          <div class="type_msg">
            <div class="input_msg_write">
              <input type="text" class="write_msg" placeholder="Type a message" id="messageText" name="messageText" />
              <button class="msg_send_btn" type="button" id="send" value="Send"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
            </div>
          </div>
        </div>
      </div>
      
    </div>
    </div>
  
  
     
  
        <div class="container">
            <div class="row justify-content-right">
                <div class="col-md-5">
                <div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Liste d'amis
        </button>
      </h5>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body">
         <ul class="list-group"></ul>
      </div>
    </div>
  </div>
                   
						
                    </div>                    
                </div>
            </div>
            </div>
           
    
<c:import url="footer.jsp"></c:import>
</body>
</html>