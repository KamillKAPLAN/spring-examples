package com.kkaplan.spring_mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kkaplan.spring_mvc.beans.Product;
import com.kkaplan.spring_mvc.dao.ProductRepository;

@Controller
public class ProductController {

	private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
	@PostMapping("/search")
    public String search(@RequestParam("searchString") String keyword, Model model){
		
		List<Product> products = productRepository.searchByName(keyword);
        model.addAttribute("products", products);
        model.addAttribute("searchedFor", keyword);
        return "search-results";
    }
}
