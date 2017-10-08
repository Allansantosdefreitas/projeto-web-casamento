package br.com.ifpe.tads.projetoCasamentoWeb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_servico")
public class Servico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_servico")
	private Integer idServico;
	
	@Column (name = "txt_titulo")
	private String titulo;
	
	@Column (name = "txt_descricao")
	private String descricao;
	
	@Column (name = "flo_preco")
	private Float preco;
	
	@Column (name = "boo_disponibilizado")
	private Boolean disponibilizado;
	
	public Servico() {
		
	}

	public Servico(String titulo, String descricao, Float preco, Boolean disponibilizado) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.preco = preco;
		this.disponibilizado = disponibilizado;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Boolean getDisponibilizado() {
		return disponibilizado;
	}

	public void setDisponibilizado(Boolean disponibilizado) {
		this.disponibilizado = disponibilizado;
	}
	
	public void disponibilizarServico() {
		
		if(this.disponibilizado = Boolean.TRUE) {
			this.disponibilizado = Boolean.FALSE;
		} else {
			this.disponibilizado = Boolean.TRUE;
		}
	}
	
	public void gerenciarServico() {
		
	}
}
