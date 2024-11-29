package com.cg.controller;
 
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Product;
import com.cg.exception.ResourceNotFound;
import com.cg.service.IProductService;
 
@RequestMapping("/api")
@RestController
public class ProductController {
	@Autowired
	IProductService productService;

	// FIND ALL PRODUCTS
//	@GetMapping("/products")
//    public List<Product> getAllProducts() {
//        return productService.findAllProducts();                 
//    }
	@GetMapping(path = "/products")
	public List<Product> getProducts(@ RequestHeader("Authorization") String token){
		System.out.println("Hello");
		if (productService.hasPermission(token))
			  return productService.findAllProducts();
		else
			return null;
	    }
	
	// FIND PRODUCT BY ID (?id=_)
	@GetMapping(path = "/products/myProduct")
	public Optional<Product> getProductByParamId(@RequestParam int id) {
		return productService.findProductById(id);
	}
	
	// FIND PRODUCT BY ID WITH EXCEPTION 
	@GetMapping("/products/{id}")
	Optional<Product>findByProductIdFromDBWithException(@PathVariable int id) throws ResourceNotFound
	{	Optional<Product> product = productService.findProductById(id);
    	product.orElseThrow(() -> new ResourceNotFound("Product not found for this id :: " + id));
    	System.out.println(id);
    return product;	
	}
	
	// FIND PRODUCT BY ID WITH ERROR MESSAGE
	@Value("${app.name}")
	private String appName;
	@GetMapping(path = "/product/{id}")
    public String getProductById(@PathVariable int id) {
        Optional<Product> product = productService.findProductById(id);

        if (product.isPresent()) {
            return product.get().toString();  
        } else {
            System.out.println(appName);
            return appName;
        }
    }
	
	
	// CREATE PRODUCT
	@PostMapping("/prodpost")
	public Product CreateProduct( @RequestBody Product product) {
        return productService.createProduct(product); 
	}
	
	// DELETE PRODUCT
	@DeleteMapping("/products/{id}")
	public void DeleteProduct(@PathVariable int id) {
		 productService.deleteProduct(id);
	}
	
	// UPDATE PRODUCT
	@PutMapping("/prodput")
	public Product UpdateProduct(@RequestBody Product p1) throws ResourceNotFound{
		int id = p1.getId();
		return productService.updateProduct(id,p1);
	}
	
	// FIND PRODUCT BY NAME
	@GetMapping(path="/products/getproductbyName/{name}")
	public List<Product> getProductByname(@PathVariable String name) {
		return productService.getProductByname(name);
	}
	
	// COUNT TOTAL NUMBER OF PRODUCTS
	@GetMapping(path="/products/count/{name}")
	public int getCountByProduct(@PathVariable String name){
		return productService.getCountByProductname(name);
	}
	
	
}