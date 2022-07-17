package com.vendas.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.dsmeta.entidades.Sale;
import com.vendas.dsmeta.servicos.ServicoVenda;

@RestController
@RequestMapping(value = "/sales")
public class VendasController {
	
	@Autowired
	private ServicoVenda servico;
	
	@GetMapping
	public List<Sale> encontraVendas(){
		return servico.encontraVendas();
	}
}
