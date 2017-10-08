package br.com.ifpe.tads.projetoCasamentoWeb.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_profissional")
@DiscriminatorValue(value = "pro")
@PrimaryKeyJoinColumn(name = "id_profissional", referencedColumnName = "id_usuario")
@Access(AccessType.FIELD)
public class Profissional implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
