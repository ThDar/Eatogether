package com.eatogether.Controller;

import com.eatogether.Buisness.IRendezVousBusiness;
import com.eatogether.Buisness.Implementation.IRendezVousBusinessImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateRendezVousServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IRendezVousBusiness iRendezVousBusiness = new IRendezVousBusinessImplementation();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null ;
        try {
			date = formatter.parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int idrdv = Integer.valueOf(request.getParameter("idrdv"));
        iRendezVousBusiness.updateRDV(idrdv,date);
        this.getServletContext()
                .getRequestDispatcher("/Consulterrdv.jsp")
                .forward(request, response);


    }


}

