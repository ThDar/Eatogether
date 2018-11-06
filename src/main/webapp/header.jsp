<div class="nav-menu">
        <div class="bg transition">
            <div class="container-fluid fixed">
                <div class="row">
                    <div class="col-md-12">
                        <nav class="navbar navbar-expand-lg navbar-light">
                      	  <img class="img-responsive" src="images/logo2.png">
                            <a class="navbar-brand" href="recherche.jsp">&nbsp;&nbsp;Eatogether</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
               
              </button>
                            <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
                                <ul class="navbar-nav">
                                    <li class="nav-item dropdown">
                                        <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     					<img src="https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-1/p40x40/38528653_1819079501515690_2328069988956504064_n.jpg?_nc_cat=101&oh=d5e99a20f3d7c2b46e5898f890e64f90&oe=5C45E7A0" class="rounded-circle" > <c:out value="${sessionScope.login}"></c:out></a>
                                         <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                            <a class="dropdown-item" href="Profil">Gérer Profil</a>
                                            <a class="dropdown-item" href="compte.jsp">Gérer Compte</a>
                                                                                  </div>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link" href="#" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Rendez-vous
                    <span class="icon-arrow-down"></span>
                  </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                        	<a class="dropdown-item" href="rendezvous.jsp">Tout les Rendez-vous</a>
                                            <a class="dropdown-item" href="Consulterrdv.jsp">Mes Rendez-vous</a>
                                        
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Amis et messages
                    <span class="icon-arrow-down"></span>
                  </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                            <a class="dropdown-item" href="chat.jsp">Messagerie</a>
                                        </div>
                                    </li>
                                    
                                    
                                     <li class="nav-item dropdown">
                                        <a class="nav-link" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Recherche des lieux
                    <span class="icon-arrow-down"></span>
                  </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                            <a class="dropdown-item" href="recherche.jsp">Recherche</a>
                                        </div>
                                    </li>
                                   
                                    
                                    <li><a href="DeconnexionServlet?deconnexion=true" class="btn btn-outline-light top-btn"><span class="ti-plus"></span> Déconnexion</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
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
                        <div class="row d-flex justify-content-center">
                            <div class="col-md-10">
                                <form class="form-wrap mt-4" method="post" action="Recherche">
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <input type="text" id="place" name="place" placeholder="Lieu" class="btn-group1" required>
                                        <input type="text" id="query" name="query" placeholder="Mot-clé" class="btn-group2"required>
                                        <input type="number" id="rayon" name="rayon" placeholder="Rayon" class="btn-group2"required min="10000" max="100000">
                                        <input type="number" id="limit" name="limit" placeholder="Résultats" class="btn-group1"required min="1" max="10">
                                        <button type="submit" class="btn-form"><span class="icon-magnifier search-icon"></span>Recherche<i class="pe-7s-angle-right"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

