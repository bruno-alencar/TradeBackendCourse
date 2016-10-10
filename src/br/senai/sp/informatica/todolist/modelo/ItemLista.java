package br.senai.sp.informatica.todolist.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("lista")
@Entity
public class ItemLista {
	// Variaveis
	@Id // Identificador
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // Faz o banco gerar o id automatico
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_ITEMLISTA")
	@SequenceGenerator(name="SEQ_ITEMLISTA", sequenceName="SEQ_ITEMLISTA")
	private Long id;
	private String descricao;
	private boolean feito;
	@ManyToOne //Muitos para um *Muitos itens para uma lista*
	@JoinColumn(name="lista_id")
	private Lista lista;

	// Gets e Sets
	
	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFeito() {
		return feito;
	}

	public void setFeito(boolean feito) {
		this.feito = feito;
	}
}
