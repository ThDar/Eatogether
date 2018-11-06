$(document).ready(function(){
	$("#row1").on("click","#match",function(){
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
	    document.location.reload();
	});
});



$(document).ready(function(){
	    $.ajax({
	       url : 'AllRendezVousServlet',
	       type : 'POST', 
	       dataType : 'json',
	    	     success : function(data){
	    	    	 $.each(data, function(i, obj) {
	    	    		 $("#row1").append("<div class=\"col-md-4 featured-responsive\"><div class=\"featured-place-wrap\"><div class=\"featured-title-box\"><h6> Rejoindre son rendez-vous ! </h6><p><b>Nom :</b> "+obj.idLiker.nom+"</p><br><p><b>Prénom :</b>"+obj.idLiker.prenom+"</p><br><p><b>Date de naissance :</b>"+obj.idLiker.datenaissance+"<p><br><p><b>Email :</b>"+obj.idLiker.mail+"<p><br><p><b>Date de Rendez-vous :</b>"+obj.dateRdv+"</p><p><b>Description :</b>"+obj.note+"</p><div class=\"bottom-icons\"> <a href=\"#\" class=\"btn btn-danger\" role=\"Plus de détails\" id=\"btnid\" data-toggle=\"modal\" data-target=\"#exampleModal\" value=\""+obj.idRestraunt+"\" >Plus de détails</a><br><a class=\"btn btn-secondary\" id=\"match\" value=\""+obj.id+"\" role=\"Match\">Match</a></div></div></div></div></div>");

	    	    	 }); 
	    	    	 },

	    	       error : function(resultat, statut, erreur){

	    	       },

	    	       complete : function(resultat, statut){

	    	       }

	    });
	});
$(document).ready(function(){
$("#row1").on("click","#btnid",function(){
	 var id = $("#btnid").attr('value');
    $.ajax({
       url : 'DetailsServlet',
       type : 'POST', // Le type de la requête HTTP, ici devenu POST
       data : 'id='+id, // On fait passer nos variables, exactement comme en GET, au script more_com.php
       dataType : 'json',
    	     success : function(data){
    	    	 try{
	    	    	 $(".modal-body").append("<img src=\""+data.venue.photos.groups[1].items[0].prefix+"470x470"+data.venue.photos.groups[1].items[0].suffix+"\" class=\"rounded\" /><br><br>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 
	    	    	 try{
	    	    	 if(data.venue.contact.facebookName!=null)$(".modal-body").append("<b><label> Facebook : </label></b>"+data.venue.contact.facebookName+"<br>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 try{
	    	    	 if(data.venue.contact.instagram!=null)$(".modal-body").append("<b><label> Instagram : </label><b>"+data.venue.contact.instagram+"<br>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 try{
	    	    	 if(data.venue.url!=null)$(".modal-body").append("<b><label> Website : </label></b>"+data.venue.url+"<br>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 try{
	    	    	 if(data.venue.likes.summary!=null)$(".modal-body").append("<b><label> Likes : </label></b>"+data.venue.likes.summary+"<br>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 try{
	    	    	 if(data.venue.rating!=null)$(".modal-body").append("<b><label> Rating : </label></b>"+data.venue.rating+"<br>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 try{
	    	    	 if(data.venue.menu.url!=null)$(".modal-body").append("<b><label> Menu : </label></b>"+data.venue.menu.url+"<br>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
	    	    	 try{
	    	    	 if(data.venue.menu.url!=null)$(".modal-body").append("<b><label> Hours : </label></b>"+data.venue.hours.status+"<br>");
	    	    	 }catch(error){
	    	    		 
	    	    	 }
    	       },
    	       error : function(resultat, statut, erreur){
    	       },
    	       complete : function(resultat, statut){
    	       }
    });
});
});

    $(window).scroll(function() {
        // 100 = The point you would like to fade the nav in.

        if ($(window).scrollTop() > 100) {

            $('.fixed').addClass('is-sticky');

        } else {

            $('.fixed').removeClass('is-sticky');

        };
    });

