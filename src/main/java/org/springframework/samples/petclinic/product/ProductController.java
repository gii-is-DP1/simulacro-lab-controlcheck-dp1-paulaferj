package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ProductController {
    
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	
	@GetMapping(value="product/create")
	public String initCreationForm(Map<String,Object> model) {
		
		Product product= new Product();
		List<ProductType> pType= this.productService.getAllProductsType();
		
		model.put("product", product);
		model.put("productType", pType);
		
		return "products/createOrUpdateProductForm";
		
	}
	
	@PostMapping(value="product/create")
	public String processCreationForm(@Valid Product product,  BindingResult result) {
		
		if(result.hasErrors()) {
			return "products/createOrUpdateProductForm";
		}else {
			this.productService.save(product);
			return "welcome";
		}
	}
}
