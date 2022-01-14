package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public  ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
    public List<Product> getAllProducts(){
    	List<Product> products =  productRepository.findAll();
        return products;
    }

    public List<ProductType> getAllProductsType(){
    	return this.productRepository.findAllProductTypes();
    }
    public List<Product> getProductsCheaperThan(double price) {
        return this.productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return this.productRepository.getProductType(typeName);
    }

    
    public Product save(Product p){
        return this.productRepository.save(p);       
    }

   
    
}
