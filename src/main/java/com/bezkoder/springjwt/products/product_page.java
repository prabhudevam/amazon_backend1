package com.bezkoder.springjwt.products;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="products")
public class product_page {
	@Id
public int prod_id;
	public String prod_img_link;
	public 	String prod_name;
	public int prod_cost;
	public int prod_stock;
	public String prod_desc;
	
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_img_link() {
		return prod_img_link;
	}
	public void setProd_img_link(String prod_img_link) {
		this.prod_img_link = prod_img_link;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_cost() {
		return prod_cost;
	}
	public void setProd_cost(int prod_cost) {
		this.prod_cost = prod_cost;
	}
	public int getProd_stock() {
		return prod_stock;
	}
	public void setProd_stock(int prod_stock) {
		this.prod_stock = prod_stock;
	}
	public String getProd_desc() {
		return prod_desc;
	}
	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}

}
