package model.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Articolo;
import model.DAO.ArticoloDAO;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticoloDAO aDao = new ArticoloDAO();
		
		String descrizione = request.getParameter("descrizione");
		String q = request.getParameter("quantita");
		int quantita= Integer.parseInt(q);
		
		Articolo a = new Articolo();
		
		a.setDescrizione(descrizione);
		a.setQuantita(quantita);
		
		try {
			aDao.insert(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
