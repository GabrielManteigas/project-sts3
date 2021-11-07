package com.gmanteigas.dsvendas.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmanteigas.dsvendas.dto.SellerDTO;
import com.gmanteigas.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		return repository
				.findAll()
				.stream()
				.map(s-> new SellerDTO(s))
				.collect(Collectors.toList());
	}

}
