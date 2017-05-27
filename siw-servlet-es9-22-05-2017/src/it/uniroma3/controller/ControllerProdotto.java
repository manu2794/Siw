package it.uniroma3.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.model.Prodotto;
import it.uniroma3.service.ProductService;
import it.uniroma3.validator.ProductValidator;

@WebServlet("/prodotto") //nome applicazione
public class ControllerProdotto extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//abbiamo cambiato doGet in doPost perchè i dati delle form è meglio tenerli nascosti
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = "/prodotto.jsp";

		//rimuove prodotto
		if(request.getParameter("comand") != null){
			long id = Long.parseLong(request.getParameter("id"));
			ProductService service = new ProductService();
			Prodotto p = service.getOneProduct(id);
			service.delete(p);
			request.setAttribute("prodotti", service.getProdotti());
			nextPage="/prodotti.jsp";
		}

		else {

			//aggiunge prodotto dopo aver controllato la validità
			Prodotto nuovoProdotto = new Prodotto();
			request.setAttribute("prodotto", nuovoProdotto);

			ProductValidator validator = new ProductValidator();
			boolean tuttoOk = validator.validate(request);
			List<Prodotto> lista = new ArrayList<>();
			if(tuttoOk){  // se  i dati sono corretti chiede al servizio di inserire il prodotto creato
				ProductService service = new ProductService();
				service.inserisciProdotto(nuovoProdotto);
				lista.add(nuovoProdotto);
				request.setAttribute("prodotti", lista);
			} 
			else {
				nextPage = "/index.jsp";
			}
		}
		
		// inoltro: poichè gli oggetti servlet vivono nel contenitore, non abbiamo un riferimento ad essi.
				//			dunque l'operazione di "richiamo" della risposta deve essere fatta dal contenitore.
				
				//			Il contenitore ha un oggetto Dispatcher capace di inoltrare richieste ad altri oggetti servlet

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		// route della servlet al quale si vuole inosltrare la richiesta
		rd.forward(request, response);											// con la forward avviene l'inoltro della richiesta
		return; 
	}


	//servono altri controlli: che quello che abbiamo scritto per il prezzo sia veramente un numero, ma il codice diventa lungo
	//lo organizziamo meglio facendo un metodo (o una classe: ValidatorProdotto) che fa dei controlli
	//su quello che arriva da input

	//questo mi mostra la pagina con la descrizione del prodotto
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage="/prodotti.jsp";

		ProductService service = new ProductService();

		//se ho l'id stampo questo prodotto, sennò stampo tutti i prodotti
		if(request.getParameter("id") != null){
			long id = Long.parseLong(request.getParameter("id"));
			Prodotto p = service.getOneProduct(id);
			request.setAttribute("prodotto", p);
			nextPage="/prodotto.jsp";
		}
		else{
			List<Prodotto> prodotti = service.getProdotti();
			request.setAttribute("prodotti", prodotti);
		}

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}
}