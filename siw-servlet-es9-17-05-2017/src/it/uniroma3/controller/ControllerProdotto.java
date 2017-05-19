package it.uniroma3.controller;

import java.io.IOException;

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


@WebServlet("/prodotto")
public class ControllerProdotto extends HttpServlet {

	public ControllerProdotto() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage;
		
		Prodotto prodotto = new Prodotto();
		request.setAttribute("prodotto", prodotto);
		
		ProductValidator validator = new ProductValidator();

		if(validator.validate(request)) {
			ProductService service = new ProductService();
			service.inserisciProdotto(prodotto);
			nextPage = "/MostraDati.jsp";
		}
		else
			nextPage = "/index.jsp";

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
