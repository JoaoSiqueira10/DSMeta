package com.vendas.dsmeta.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.dsmeta.entidades.Sale;
import com.vendas.dsmeta.repositorios.RepositorioVenda;

@Service
public class ServicoVenda {

	@Autowired
	private RepositorioVenda repositorio;
	
	public List<Sale> encontraVendas() {
		return repositorio.findAll();
	}
}
