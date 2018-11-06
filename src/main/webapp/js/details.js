$(document).ready(function(){
	    $.ajax({
	       url : 'DetailsServlet',
	       type : 'POST', // Le type de la requête HTTP, ici devenu POST
	       data : 'id='+id, // On fait passer nos variables, exactement comme en GET, au script more_com.php
	       dataType : 'json',
	    	     success : function(data){
	    	    	 try {
	    	  		$(".contact-info").prepend("<img src=\""+data.venue.photos.groups[1].items[0].prefix+data.venue.photos.groups[1].items[0].height+"x"+data.venue.photos.groups[1].items[0].width+data.venue.photos.groups[1].items[0].suffix+"\" class=\"img-fluid\" /><br>");
	    	    	 }
	    	    	 catch(error) {
	    	    	   
	    	    	 }
	    	    	 
	    	    	 try{
	    	   		 if(data.venue.contact.facebookName!=null)$("#address-link").append("<span class=\"icon-link\" id=\"icon-link1\"></span><p>Facebook : "+data.venue.contact.facebookName+"</p>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 try{
	    	    	 if(data.venue.contact.instagram!=null)$("#address-link").append("<span class=\"icon-link\" id=\"icon-link1\"></span><p> Instagram :"+data.venue.contact.instagram+"</p>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 try{
	    	    	 if(data.venue.url!=null) $("#address-link").append(" <span class=\"icon-link\" id=\"icon-link1\"></span><p> Website : "+data.venue.url+"</p>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	   		try{
	    	   		if(data.venue.likes.summary!=null) $(".review-btn").append("<span> "+data.venue.likes.summary+"</span>");
	    	   		}catch(error){
	    	   			
	    	   		}
	    	   		try{
	    	   		if(data.venue.contact.formattedPhone!=null) $("#address-tel").append(" <span class=\"icon-screen-smartphone\"></span><p>"+data.venue.contact.formattedPhone+"</p>");
	    	   		}catch(error){
	    	   			
	    	   		}
	    	   		try{
	    	   	   if(data.venue.rating!=null) $(".reserve-seat-block").append("<div class=\"reserve-rating\"><span>"+data.venue.rating+"</span></div>");
	    	   		}catch(error){
	    	   			
	    	   		}
	    	   		try{
	    	   		if(data.venue.hours.status!=null) $("#address-clock").append("<span class=\"icon-clock\"></span><p>"+data.venue.hours.status+"</p><br>");
	    	   		}catch(error){
	    	   			
	    	   		}
	    	   		 try{
	    	   		if(data.venue.hours.timeframes[0].days!=null) $("#address-clock").append("<span class=\"icon-clock\"></span><p>"+data.venue.hours.timeframes[0].days+"</p><br>"); 
	    	   		 }
	    	   		 catch(error){
	    	   			 
	    	   		 }
	    	   		 try{
	    	   		if(data.venue.hours.timeframes[0].open[0].renderedTime!=null) $("#address-clock").append("<span class=\"icon-clock\"></span><p>"+data.venue.hours.timeframes[0].open[0].renderedTime+"</p><br>");
	    	   		 }
	    	   		 catch(error){
	    	   			 
	    	   		 }
	    	   		 try{
	    	    	 if(data.venue.description!=null){
	    	    		 $(".booking-checkbox").append("<p>"+data.venue.description+"</p>");
	    	    	 }else {
	    	    		 $(".booking-checkbox").append("<p><div class=\"container\"> <div class=\"row justify-content-center\"><div class=\"col-md-5\"><div class=\"styled-heading\"><img class=\"img-responsive\" src=\"images/newspaper.png\"><br><br> <h4 class=\"service-heading\">Pas de description </h4></div></div></div></p>");
	    	    	 }
	    	   		 }
	    	   		 catch(error){
	    	   			 console.error(error);
	    	   		 }
	    	    	
	    	    	
	    	    	 $(".modal-body").append("<div class=\"form-group\">");
					 $(".modal-body").append("<input type=\"hidden\" class=\"form-control\" id=\"resto-id\" name=\"resto-id\" value=\""+id+"\">");
	    	         $(".modal-body").append("</div>");
	    	          
	    	         $(".modal-body").append("<div class=\"form-group\">")
	    	         $(".modal-body").append("<input type=\"hidden\" class=\"form-control\" id=\"recipient-name\" value=\"${name}\" disabled>");
	    	         $(".modal-body").append("</div>") ;
	    	         
	    	         $(".modal-body").append("<div class=\"form-group\">");
	    	         $(".modal-body").append("<label for=\"recipient-name\" class=\"col-form-label\">Date</label>");
	    	         $(".modal-body").append("<input type=\"date\" class=\"form-control\" id=\"date\" name=\"date\">");
	    	         $(".modal-body").append("</div>");
	    	          
	    	         $(".modal-body").append("<div class=\"form-group\">");
	    	         $(".modal-body").append("<label for=\"message-text\" class=\"col-form-label\">Description :</label>");
	    	         $(".modal-body").append("<textarea class=\"form-control\" id=\"message-text\" name=\"message-text\"></textarea>");
	    	         $(".modal-body").append("</div>");
	    	      
	    	         
	    	         $.each(data.info, function(i, obj) {
	    	         $("#annonces").append("<div class=\"customer-review_wrap\"><div class=\"customer-img\"><img src=\"images/customer-img1.jpg\" class=\"img-fluid\" alt=\"#\"><p>"+obj.idLiker.prenom+" "+obj.idLiker.nom+"</p></div><div class=\"customer-content-wrap\"><p class=\"customer-text\"><b><label> Pseudo : </label></b>"+obj.idLiker.pseudo+"</p><p class=\"customer-text\"><b><label> Date de naissance : </label></b>"+obj.idLiker.datenaissance+"</p><p class=\"customer-text\"><b><label> Email : </label></b>"+obj.idLiker.mail+"</p><p class=\"customer-text\"><b><label> Description : </label></b>"+obj.note+"</p><button type=\"button\" id=\"match\" class=\"btn btn-secondary\" value=\""+obj.id+"\">Match</button></div>");
	    	         });	  
	    	         if(data.info.length==0){
	    	        	 $("#annonces").append("<div class=\"container\"> <div class=\"row justify-content-center\"><div class=\"col-md-5\"><div class=\"styled-heading\"><img class=\"img-responsive\" src=\"images/restaurant-date-calendar-page.png\"><br><br> <h4 class=\"service-heading\">Soyez le premier a Creer un Rendez-vous !</h4><p class=\"text-muted\">Eatogether offre a ses utilisateurs la possiblite de creer un rendez-vous et rencontrez des personnes interessantes</p><h3>Lancez un rendez-vous!</h3></div></div></div>");
	    	       }
	    	     },
	    	       error : function(resultat, statut, erreur){

	    	       },

	    	       complete : function(resultat, statut){

	    	       }

	    });
	   
	});


$(document).ready(function(){
	$("#annonces").on("click","#match",function(){
		 var id = $("#match").attr('value');
	    $.ajax({
	       url : 'RendezVousAddTargetServlet',
	       type : 'POST', // Le type de la requête HTTP, ici devenu POST
	       data : 'Idrdv='+id, // On fait passer nos variables, exactement comme en GET, au script more_com.php
	       dataType : 'json',
	    	     success : function(data){
	
	    	       },
	    	       error : function(resultat, statut, erreur){
	    	       },
	    	       complete : function(resultat, statut){
	    	       }
	    });
	});
});

var swiper = new Swiper('.swiper-container', {
    slidesPerView: 3,
    slidesPerGroup: 3,
    loop: true,
    loopFillGroupWithBlank: true,
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
});

if ($('.image-link').length) {
    $('.image-link').magnificPopup({
        type: 'image',
        gallery: {
            enabled: true
        }
    });
}
if ($('.image-link2').length) {
    $('.image-link2').magnificPopup({
        type: 'image',
        gallery: {
            enabled: true
        }
    });
}

