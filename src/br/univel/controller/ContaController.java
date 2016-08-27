package br.univel.controller;

import br.univel.dao.ContaDao;
import br.univel.model.Conta;

public class ContaController {
	
	
	public void add(Conta conta){
		new ContaDao().add(conta);
	}

}
