package validator;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import model.Opera;

public class OperaValidator {

	public boolean validate (HttpServletRequest request){
		String titolo = request.getParameter("titolo");
		String tecnica = request.getParameter("tecnica");
		String anno = request.getParameter("anno");
		String nomeArtista = request.getParameter("nome");
		Opera o = (Opera) request.getAttribute("opera");
		boolean tuttoOk = true;

		//vincoli: sono tutti campi obbligatori (nella form c'è *)
		if(titolo == null || titolo.equals("")){
			request.setAttribute("errTitolo", "Attenzione: campo obbligatorio");
			tuttoOk = false;
		}
		else {
			o.setTitolo(titolo);
		}
		
		if(tecnica == null || tecnica.equals("")){
			request.setAttribute("errTecnica", "Attenzione: campo obbligatorio");
			tuttoOk = false;
		}
		else {
			o.setTecnica(tecnica);
		}
		
		if(anno == null || anno.equals("")){
			request.setAttribute("errAnno", "Attenzione: campo obbligatorio");
			tuttoOk = false;
		}

		if(nomeArtista == null || nomeArtista.equals("")) {
			request.setAttribute("errNomeArtista", "Attenzione: campo obbligatorio");
			tuttoOk = false;
		}
		
		return tuttoOk;
	}
}
