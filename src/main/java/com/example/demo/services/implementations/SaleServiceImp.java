package com.example.demo.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.SaleDTO;
import com.example.demo.exceptions.ResourceDuplicatedException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Sale;
import com.example.demo.repository.SaleRepository;
import com.example.demo.services.SaleService;

@Service
public class SaleServiceImp  implements SaleService{

	@Autowired
	SaleRepository saleRepository;
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<SaleDTO> GetAllSales() {
		List<Sale> sales= saleRepository.findAll();
		return  sales.stream().map((sale)-> mapper.map(sale, SaleDTO.class)).collect(Collectors.toList());
	}

	@Override
	public SaleDTO FindById(long id) {
	
		  Sale sale= saleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id",Long.toString(id)));
		return mapper.map(sale, SaleDTO.class);
	}

	@Override
	public SaleDTO AddSale(SaleDTO sale) {
	 
		Sale saleVerified= SaleSaved( sale);
		return mapper.map(saleVerified, SaleDTO.class);
		
	}

	@Override
	public SaleDTO UpdateSale(SaleDTO sale, long id) {
			
		Sale saleExist= saleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id",Long.toString(id)));
		Sale saleVerified= SaleUpdated(saleExist, sale);
		return mapper.map(saleVerified, SaleDTO.class);
		
	}

	@Override
	public SaleDTO DeleteSale(Long id) {
		Sale sale = saleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("id",Long.toString(id)));
		saleRepository.delete(sale);
		return mapper.map(sale, SaleDTO.class);
	}
	
	
	private Sale SaleUpdated(Sale sale, SaleDTO saleDTO)
	{
		Sale saleStatus= saleRepository.findByDni(saleDTO.getDni()).orElse(null);
		//actualizar
		if(saleStatus!=null)
			
		{
			if(!saleStatus.getId().equals(sale.getId()))
			{
				throw new ResourceDuplicatedException("dni",saleDTO.getDni());
			}
		}
		
		//valida que si el dni que esta en la bd y el que introduce el usuario son iguals, se le pase el del usuario
		if(!saleDTO.getDni().equals(sale.getDni()))
		{
		 sale.setDni(saleDTO.getDni());
		}
		sale.setName(saleDTO.getName());
		return saleRepository.save(sale);
		
	}
	private Sale SaleSaved(SaleDTO saleDTO)
	{
		//agregar
		Sale saleStatus= saleRepository.findByDni(saleDTO.getDni()).orElse(null);
		if(saleStatus!=null)
		{
			throw new ResourceDuplicatedException("dni", saleDTO.getDni());
		}
		Sale saleCre= new Sale();
		saleCre.setDni(saleDTO.getDni());
		saleCre.setName(saleDTO.getName());
		return saleRepository.save(saleCre);
	}
}
