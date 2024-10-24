package com.modal_app.model.service;


import com.modal_app.model.dto.ProductDTO;
import com.modal_app.model.entity.Product;
import com.modal_app.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //convert entity to dto
    private ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }


    //convert dto to entity

    private Product mapToEntity(ProductDTO productDTO){

        Product product =new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        return product;

    }

    // add new product

    public void addProduct(ProductDTO productDTO){
        Product product = mapToEntity(productDTO);
        productRepository.save(product);;

    }




}
