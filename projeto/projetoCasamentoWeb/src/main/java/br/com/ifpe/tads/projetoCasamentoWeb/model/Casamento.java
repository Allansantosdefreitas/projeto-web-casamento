package br.com.ifpe.tads.projetoCasamentoWeb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "tb_casamento")
public class Casamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	@Column (name = "id_casamento")
	private Integer idCasamento;
	
	@NotNull
	@Column (name = "dou_orcamento_Total")
	private Double orcamentoTotal;
	
	@OneToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_casamento", referencedColumnName="fk_casamento")
	private Convite convite;
	
	@OneToMany(mappedBy="casamento", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private List<Tarefa> tarefas;

	public Casamento () {
		
	}
	
	public Casamento(Double orcamentoTotal) {
		this.orcamentoTotal = orcamentoTotal;
	}

	public Integer getIdCasamento() {
		return idCasamento;
	}

	public void setIdCasamento(Integer idCasamento) {
		this.idCasamento = idCasamento;
	}

	public Double getOrcamentoTotal() {
		return orcamentoTotal;
	}

	public void setOrcamentoTotal(Double orcamentoTotal) {
		this.orcamentoTotal = orcamentoTotal;
	}

	public Convite getConvite() {
		return convite;
	}

	public void setConvite(Convite convite) {
		this.convite = convite;
	}

}
