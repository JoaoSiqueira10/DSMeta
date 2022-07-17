package com.vendas.dsmeta.servicos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vendas.dsmeta.entidades.Sale;
import com.vendas.dsmeta.repositorios.RepositorioVenda;

@Service
public class ServicoVenda {

	@Autowired
	private RepositorioVenda repositorio;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {

		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		return repositorio.findSales(min, max, pageable);
	}
}
