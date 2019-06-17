package com.dao;

import java.util.List;

import com.bean.Product;

//传统Dao方法开发
public interface ProductDao {
	
	public void insertProduct(Product product);
	
	public void deleteProductById(int id);
	
	public void updateProductById(Product product);
	
	public Product  findpRoductById(int id);
	public List<Product>  findProductsByName(String name); 
	
	
	
	

}
