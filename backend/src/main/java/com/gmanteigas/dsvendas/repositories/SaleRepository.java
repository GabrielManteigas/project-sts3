package com.gmanteigas.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmanteigas.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long>{

}
