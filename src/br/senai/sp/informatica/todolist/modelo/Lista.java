package br.senai.sp.informatica.todolist.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Lista {

	// Variaveis
	@Id //Identificador
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Faz o banco gerar o id automatico
	private Long id;
	@Column(length=100) //Column define as informações da coluna como se fosse no banco de dados
	private String titulo;
	@OneToMany(mappedBy="lista",cascade=CascadeType.ALL,orphanRemoval=true, fetch=FetchType.EAGER) //Um para muitos - *Uma lista para varios itens*
	private List<ItemLista> itens;

	//Gets e Sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<ItemLista> getItens() {
		return itens;
	}

	public void setItens(List<ItemLista> itens) {
		this.itens = itens;
	}
	
	@JsonProperty("feito")
	public boolean isRealizada(){
		
		for(ItemLista item : itens){
			if(!item.isFeito()){
				return false;
			}
		}
		return true;
	}

}
