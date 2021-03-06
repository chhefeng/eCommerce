package com.hef.service.impl;

import java.util.List;

import com.hef.dao.ProductRepository;
import com.hef.service.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hef.entity.Product;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional
	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public Product updateProduct(Product product, Long id) throws NotFoundException {
		Product prod = productRepository.getOne(id);
		if (prod == null) {
			throw new NotFoundException("该博客不存在");
		}
		BeanUtils.copyProperties(product, prod);
		return productRepository.save(prod);
	}


	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

}
