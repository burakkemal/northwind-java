package kodlamaio.nortwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.nortwind.business.abstracts.ProductService;
import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.entities.concretes.Product;
import kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto;

@RestController //controller oldugunu belirtiyoruz
@RequestMapping("/api/products")  //karşılayacak controller adını veririz
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired  //bir nevi Ioc dediğimiz yapılandırmadır. newlememize gerek kalmıyor.
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Product product) { //datayı da birlikte göndermek için requestbody kullanırız..
		return this.productService.add(product);
	}
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByProductNameAndCategory(productName,categoryId);
	}
	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo,int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByNameAndCategory(productName,categoryId);
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
}
