package it.uniroma3.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Prodotto;

public class ProductValidator {

	public boolean validate (HttpServletRequest request){
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		String dataScadenza = request.getParameter("dataScadenza");
		Prodotto p = (Prodotto) request.getAttribute("prodotto");
		boolean tuttoOk=true;

		//vincoli: sono tutti campi obbligatori (nella form c'è *)
		if(nome==null ||nome.equals("")){
			request.setAttribute("errNome", "Attenzione: campo obbligatorio");
			tuttoOk=false;
		}
		else {
			p.setNome(nome);
		}
		
		if(descrizione==null ||descrizione.equals("")){
			request.setAttribute("errDescrizione", "Attenzione: campo obbligatorio");
			tuttoOk=false;
		}
		else {
			p.setDescrizione(descrizione);
		}
		
		try{
			float pre=Float.parseFloat(prezzo);
			p.setPrezzo(pre);
		}
		
		catch (NumberFormatException e){
			request.setAttribute("errPrezzo", "Prezzo non valido, DEVE essere un numero!!!");
			tuttoOk=false;
		}
		
		//PREZZO --> verifichiamo che sia veramente un float
		if(prezzo==null ||prezzo.equals("")){
			request.setAttribute("errPrezzo", "Attenzione: campo obbligatorio");
			tuttoOk=false;
		}

		try{
			
			DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
			Date d=df.parse(dataScadenza);
			if(d.compareTo(new Date())>0)
				p.setDataScadenza(d);
			else {
				request.setAttribute("errDataScadenza", "Prodotto gia scaduto");
				tuttoOk=false;
			}
		}
		catch(ParseException e){
			request.setAttribute("errDataScadenza", "Data di Scadenza non valida");
			tuttoOk=false;	
		}
		if(dataScadenza==null ||dataScadenza.equals("")){
			request.setAttribute("errDataScadenza", "Attenzione: campo obbligatorio");
			tuttoOk=false;
		}
		return tuttoOk;
	}
}
