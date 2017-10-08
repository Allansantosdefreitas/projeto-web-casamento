package br.com.ifpe.tads.projetoCasamentoWeb.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tb_tarefa")
public class Tarefa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_tarefa")
	private Integer idTarefa;
	
	@Column (name = "txt_titulo")
	private String titulo;
	
	@Column (name = "txt_descricao")
	private String descricao;
	
	@Column (name = "dat_data")
	@Temporal (TemporalType.DATE)
	private Date data;
	
	@Column (name = "sta_status")
	private StatusTarefa statusTarefa;
	
	@ManyToOne (cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY)
	@JoinColumn(name="fk_casamento")
	private Casamento casamento;
	
	public Tarefa() {
		
	}

	public Tarefa(Integer idTarefa, String titulo, String descricao, Date data, StatusTarefa statusTarefa) {
		super();
		this.idTarefa = idTarefa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.statusTarefa = statusTarefa;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public StatusTarefa getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(StatusTarefa statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
}
