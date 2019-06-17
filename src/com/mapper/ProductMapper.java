package com.mapper;

import java.util.List;

import com.bean.Product;
import com.pojo.MallCateGoryPojo;
import com.pojo.ProductPojo;

public interface ProductMapper {
	
	public void insertProduct(Product product);
	
	public void deleteProductById(int id);
	
	public void updateProductById(Product product);
	
	public Product  findpRoductById(int id);
	
	public List<Product>  findProductsByName(String name); 
	
	public List<ProductPojo> findProductsById(int id);
	
	
	public List<Product>  findProductsByIdresultMap(); 
	
	
	public   List<MallCateGoryPojo>  findProductBYCatName(String name);
	
	

}
