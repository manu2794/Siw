package it.uniroma3.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name="findAll",query="SELECT p FROM Prodotto p")
})
public class Prodotto {
	@Id

	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	private String descrizione;
	private float prezzo;
	private Date dataScadenza;

	public Prodotto(){
		//costruttore di default
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}


	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}


	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
