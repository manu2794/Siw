//package it.uniroma3.servlet;
//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import it.uniroma3.model.Prodotto;
//@WebServlet("/controllerDati")
//public class ControllerDati extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//
//		List<Prodotto> prodotti=new ArrayList<>();
//		Prodotto p=new Prodotto();
//		p.setNome("penna");
//		p.setPrezzo(2.0F);
//		prodotti.add(p);
//		Prodotto p2=new Prodotto();
//		p2.setNome("matita");
//		p2.setPrezzo(1.5F);
//		prodotti.add(p2);
//		request.setAttribute("prodotti",prodotti);
//		ServletContext application  = getServletContext();
//		RequestDispatcher rd = application.getRequestDispatcher("/prodotti.jsp");
//		rd.forward(request, response);
//		return; 
//	}
//
//
//}
//
//
