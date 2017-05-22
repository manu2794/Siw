package it.uniroma3.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.model.Prodotto;
import it.uniroma3.service.ProductService;
import it.uniroma3.validator.ProductValidator;
@WebServlet("/prodotto")
public class ControllerProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage="/prodotti.jsp";
		if(request.getParameter("comand")!=null){
			long id = Long.parseLong(request.getParameter("id"));
			ProductService pv=new ProductService();
			Prodotto p = pv.getOneProduct(id);
			pv.delete(p);
			request.setAttribute("prodotti", pv.getProdotti());
			nextPage="/linkProdotti.jsp";
		}
		else{
			Prodotto nuovoProdotto=new Prodotto();
			request.setAttribute("prodotto", nuovoProdotto);

			ProductValidator validator=new ProductValidator();
			boolean tuttoOk=validator.validate(request);
			List<Prodotto> lista=new ArrayList<>();
			if(tuttoOk){
				ProductService pv=new ProductService();
				pv.inserisciProdotto(nuovoProdotto);
				lista.add(nuovoProdotto);
				request.setAttribute("prodotti", lista);
			}
			if(!tuttoOk)
				nextPage="/index.jsp";
		}
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage="/linkProdotti.jsp";

		ProductService service = new ProductService();

		if(request.getParameter("id")!=null){
			long id=Long.parseLong(request.getParameter("id"));
			Prodotto p=service.getOneProduct(id);
			request.setAttribute("prodotto", p);
			nextPage="/prodotto.jsp";
		}
		else{
			List<Prodotto> prodotti=service.getProdotti();
			request.setAttribute("prodotti", prodotti);
		}

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}

}


