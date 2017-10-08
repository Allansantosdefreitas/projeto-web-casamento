package br.com.ifpe.tads.projetoCasamentoWeb.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_convidado")
@DiscriminatorValue(value = "con")
@PrimaryKeyJoinColumn(name = "id_convidado", referencedColumnName = "id_usuario")
@Access(AccessType.FIELD)
public class Convidado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StatusConvidado statusConvidado;
	
	public String responderConvite() {
		String mensagem = "Convite respondido com sucesso";
		
		return mensagem;
	}

	public StatusConvidado getStatusConvidado() {
		return statusConvidado;
	}

	public void setStatusConvidado(StatusConvidado statusConvidado) {
		this.statusConvidado = statusConvidado;
	}
	
}
