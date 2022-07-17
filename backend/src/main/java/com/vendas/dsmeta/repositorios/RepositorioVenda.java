package com.vendas.dsmeta.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.dsmeta.entidades.Sale;

public interface RepositorioVenda extends JpaRepository<Sale, Long>{

}
