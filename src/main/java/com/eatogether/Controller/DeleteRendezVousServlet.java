package com.eatogether.Controller;

import com.eatogether.Buisness.IRendezVousBusiness;
import com.eatogether.Buisness.Implementation.IRendezVousBusinessImplementation;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteRendezVousServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IRendezVousBusiness iRendezVousBusiness = new IRendezVousBusinessImplementation();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        int idrdv = Integer.valueOf(request.getParameter("id").toString());
       
        iRendezVousBusiness.DeleteRDV(idrdv);
        this.getServletContext()
                .getRequestDispatcher("/Consulterrdv.jsp")
                .forward(request, response);


    }


}

