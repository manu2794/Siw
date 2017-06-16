package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artista;
import model.Opera;
import service.ArtistaService;
import service.OperaService;
import validator.OperaValidator;

@WebServlet("/prodotto")
public class OperaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage = "/index.jsp";
		ArtistaService as = new ArtistaService();
		OperaService os = new OperaService();
		OperaValidator ov = new OperaValidator();

		if(request.getParameter("comand") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			Artista ar = as.getOneArtista(id);
			Opera nuovaOpera = new Opera();
			request.setAttribute("opera", nuovaOpera);
			boolean tuttoOk = ov.validate(request);
			if(tuttoOk) {
				os.inserisciOpera(nuovaOpera);
				request.setAttribute("opera", nuovaOpera);
			}
		}
		else {
			request.setAttribute("artisti", as.getArtisti());
		}
	}

}
