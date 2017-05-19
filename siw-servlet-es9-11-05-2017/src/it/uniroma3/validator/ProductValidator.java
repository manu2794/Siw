package it.uniroma3.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

public class ProductValidator {

	public boolean validate(HttpServletRequest request) {
		
		boolean tuttoOk = true;
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		String dataScadenza = request.getParameter("dataScadenza");
		
		//vincoli: sono tutti obbligatori(nella forma c'è *)
		if(nome == null || nome.equals("")) { //se il nome è null
			request.setAttribute("errNome", "Campo Obbligatorio");
			tuttoOk = false;
		}
		
		if(descrizione == null || descrizione.equals("")) {
			request.setAttribute("errDescrizione", "Campo Obbligatorio");
			tuttoOk = false;
		}
		
		if(prezzo == null || prezzo.equals("")) {
			request.setAttribute("errPrezzo", "Campo Obbligatorio");
			tuttoOk = false;
		}
		
		if(dataScadenza == null || dataScadenza.equals("")) {
			request.setAttribute("errDataScadenza", "Campo Obbligatorio");
			tuttoOk = false;
		}
		
		//verifichiamo che la stringa sia un float con il metodo parseFloat(String s)
		//return NullPointer se s è null
		//return NumberFormatException se la stringa non contiene un float
		try {
			Float.parseFloat(prezzo); //ritorna il prezzo(dalla stringa ritorna un float, se non è un float lancia un'eccezione
		}
		catch (NumberFormatException ext) {
			request.setAttribute("errPrezzo", "Prezzo non valido: deve essere un numero!");
			tuttoOk = false;
		}
		
		//verifichiamo che la stringa sia una data
		try {
			//il metodo di DateFormat che ci serve non è static, devi definire un oggetto DateFormat
			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			dateFormat.parse(dataScadenza);
		}
		catch (ParseException ext) {
			request.setAttribute("errDataScadenza", "Formato data non valido");
			tuttoOk = false;
		}
		
		return tuttoOk;
	}
}
