package it.uniroma3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processaDatiUpper")
public class LeggiParametri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo i parametri
		String nome = request.getParameter("nome").toUpperCase();
		String cognome = request.getParameter("cognome").toUpperCase();

		// leggo (alcune) intestazioni http della richiesta
		String address = (String)request.getRemoteAddr();
		String host = (String)request.getRemoteHost();
		String userAgent = request.getHeader("User-Agent");

		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);
		request.setAttribute("address", address);
		request.setAttribute("host", host);
		request.setAttribute("userAgent", userAgent);
		
		// inoltro: poichè gli oggetti servlet vivono nel contenitore, non abbiamo un riferimento ad essi.
		//			dunque l'operazione di "richiamo" della risposta deve essere fatta dal contenitore.
		
		//			Il contenitore ha un oggetto Dispatcher capace di inoltrare richieste ad altri oggetti servlet
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/mostraDati");		// route della servlet al quale si vuole inosltrare la richiesta
		rd.forward(request, response);		// con la forward avviene l'inoltro della richiesta
		return; 
	}
}
