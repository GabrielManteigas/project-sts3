package com.gmanteigas.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmanteigas.dsvendas.dto.SaleDTO;
import com.gmanteigas.dsvendas.dto.SaleSuccessDTO;
import com.gmanteigas.dsvendas.dto.SaleSumDTO;
import com.gmanteigas.dsvendas.entities.Sale;
import com.gmanteigas.dsvendas.repositories.SaleRepository;
import com.gmanteigas.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	//evita fazer lock quando se faz a consulta
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		//faz cache dos sellers para evitar novas consultas na base de dados
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(s-> new SaleDTO(s));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}

	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
}
