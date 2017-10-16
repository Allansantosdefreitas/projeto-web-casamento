package br.com.ifpe.tads.projetoCasamentoWeb.model;

import java.util.ArrayList;
import java.util.Collection;

public enum StatusTarefa {
	
	CONCLUIDA, PENDENTE, CANCELADA;
	
	public static Collection<StatusTarefa> valores(){
		
		Collection<StatusTarefa> valores = new ArrayList<StatusTarefa>();
		valores.add(CANCELADA);
		valores.add(PENDENTE);
		valores.add(CONCLUIDA);
		
		return valores;
	}
}
