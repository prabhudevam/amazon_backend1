package com.bezkoder.springjwt.products;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import org.springframework.stereotype.Component;

import com.bezkoder.springjwt.models.User;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonFormat;
//@JsonFormat(shape=JsonFormat.Shape.ARRAY)
@Entity
@Component
public class cartdetails {
	@Id
	@GeneratedValue
	int cid;
	@OneToOne
public User user;
@OneToMany
	public List<product_page> products;

}
