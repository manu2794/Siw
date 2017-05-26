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

@WebServlet("/processa")
public class MostraParametriRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo e manipolo i parametri
		String nome = request.getParameter("nome").toUpperCase();
		String cognome = request.getParameter("cognome").toUpperCase();
		
		
		//La sessione avviene in questo modo: il server gestisce una mappa dove ogni riga rappresenta una sessione distinta.
		//La chiave è un ID di sessione e il valore è una mappa di oggetti.
		//In tutte le risposte al client il server aggiunge automaticamente un cookie che contiene un ID di sessione.
		//Cosi ad ogni richiesta il server è in grado di recuperare l'oggetto con le info associate alla sessione
		
		//metto i valori nella sessione
		HttpSession session = request.getSession();
		session.setAttribute("NOME", nome);
		session.setAttribute("COGNOME", cognome);

		
		//inoltro: poichè gli oggetti servlet vivono nel contenitore, non abbiamo un riferimento ad essi.
		//dunque l'operazione di "richiamo" della risposta deve essere fatta dal contenitore.
				
		//Il contenitore ha un oggetto Dispatcher capace di inoltrare richieste ad altri oggetti servlet
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/conferma");		// route della servlet al quale si vuole inoltrare la richiesta
		rd.forward(request, response);		// con la forward avviene l'inoltro della richiesta
		return; 
	}
}

