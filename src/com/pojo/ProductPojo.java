package com.pojo;

import com.bean.Product;

public class ProductPojo extends Product{
	
    private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	   @Override
	    public String toString() {
	        return "ProductPojo [categoryName=" + categoryName ;
	    }
       
}
