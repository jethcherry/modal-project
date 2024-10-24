package com.modal_app.model.controller;

import com.modal_app.model.dto.ProductDTO;
import com.modal_app.model.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")  // Adding base mapping for products
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Display all products
    @GetMapping
    public String showProducts(Model model) {
        List<ProductDTO> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product";  // Return the view name
    }

    // Add a new product
    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return "redirect:/products";  // Redirect after adding
    }
}
