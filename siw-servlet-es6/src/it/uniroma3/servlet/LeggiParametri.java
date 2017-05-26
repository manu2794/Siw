package it.uniroma3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// stesso progetto dell'es 3 ma usiamo pagine JSP al 
// posto delle servlet che producono la risposta
@WebServlet("/processa")
public class LeggiParametri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo i parametri
		String nome = request.getParameter("nome").toUpperCase();
		String cognome = request.getParameter("cognome").toUpperCase();

		
//		// leggo (alcune) intestazioni http della richiesta
//		String address = (String)request.getRemoteAddr();
//		String host = (String)request.getRemoteHost();
//		String userAgent = request.getHeader("User-Agent");
//
//		request.setAttribute("nome", nome);
//		request.setAttribute("cognome", cognome);
//		request.setAttribute("address", address);
//		request.setAttribute("host", host);
//		request.setAttribute("userAgent", userAgent);
//		
		HttpSession session = request.getSession(); /*restituisce la sessione a cui
													appartiene la richiesta o
		                                            ne crea una nuova se non c'è richiesta*/
		session.setAttribute("nome", nome);
		session.setAttribute("cognome", cognome);
		
		// inoltro
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/MostraDati.jsp");
		rd.forward(request, response);
		return; 
	}
}
