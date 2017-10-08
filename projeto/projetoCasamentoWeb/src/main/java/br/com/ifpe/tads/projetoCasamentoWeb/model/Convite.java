package br.com.ifpe.tads.projetoCasamentoWeb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_convite")
public class Convite {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_convite")
	private Integer idConvite;
	
	@Column (name = "txt_titulo")
	private String titulo;
	
	@Column (name = "txt_mensagem")
	private String mensagem;
	
	@Column (name = "txt_titulo")
	private List<String> destinatarios;
	
	@Column(name="fk_casamento")
	private Integer fkCasamento;
	
	public Convite() {
		
	}

	public Integer getIdConvite() {
		return idConvite;
	}

	public void setIdConvite(Integer idConvite) {
		this.idConvite = idConvite;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<String> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(List<String> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public Integer getFkCasamento() {
		return fkCasamento;
	}

	public void setFkCasamento(Integer fkCasamento) {
		this.fkCasamento = fkCasamento;
	}
	
}
