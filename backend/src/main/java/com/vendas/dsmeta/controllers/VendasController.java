package com.vendas.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vendas.dsmeta.entidades.Sale;
import com.vendas.dsmeta.servicos.ServicoSMS;
import com.vendas.dsmeta.servicos.ServicoVenda;

@RestController
@RequestMapping(value = "/sales")
public class VendasController {
	
	@Autowired
	private ServicoVenda servico;
	@Autowired
	private ServicoSMS servicoSMS;
	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable){
		return servico.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notificaSMS(@PathVariable Long id) {
		servicoSMS.sendSms(id);
	}
}
