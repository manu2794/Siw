package it.uniroma3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerDati")
public class ControllerDati extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
			throws ServletException, IOException {
		
		boolean tuttoOk = true;
		String nextPage = "/mostraDati.jsp";
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);
		
		if(nome == null || nome.equals("")) {
			request.setAttribute("errNome", "Campo Obbligatorio");
			tuttoOk = false;
		}
		
		if(cognome == null || cognome.equals("")) {
			request.setAttribute("errCognome", "Campo Obbligatorio");
			tuttoOk = false;
		}
		
		if(tuttoOk == false)
			nextPage = "/index.jsp";
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}