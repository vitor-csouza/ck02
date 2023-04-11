package br.com.fiap.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MarcaModel {
	
	private long idMarca;
	private String nomeMarca;
	
	
	public MarcaModel() {
		super();
	}


	public MarcaModel(long idMarca, String nomeMarca) {
		super();
		this.idMarca = idMarca;
		this.nomeMarca = nomeMarca;
	}


	public long getIdMarca() {
		return idMarca;
	}


	public void setIdMarca(long idMarca) {
		this.idMarca = idMarca;
	}


	@NotNull(message="Nome da marca é obrigatório")
	@Size(min=2, max=50, message="Nome da marca deve ter entre 2 e 50 cracateres")
	public String getNomeMarca() {
		return nomeMarca;
	}


	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	
	

}
