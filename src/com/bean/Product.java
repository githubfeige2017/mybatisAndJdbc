package com.bean;

import java.util.Date;

public class Product {
	private int id;
	private int category_id;
	private String name;
	private String subtitle;
	private String main_image;
	private String sub_images;
	private String detail;
	private Double price;
	private int stock;
	private int status;
	private Date create_time;
	private Date update_time;
	
	
    private Mmall_category mmall_category;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getMain_image() {
		return main_image;
	}

	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}

	public String getSub_images() {
		return sub_images;
	}

	public void setSub_images(String sub_images) {
		this.sub_images = sub_images;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category_id=" + category_id + "]";
    }

	public Mmall_category getMmall_category() {
		return mmall_category;
	}

	public void setMmall_category(Mmall_category mmall_category) {
		this.mmall_category = mmall_category;
	}
    
    
    

}
