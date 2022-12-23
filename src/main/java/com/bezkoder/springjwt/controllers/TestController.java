package com.bezkoder.springjwt.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.products.cartDTOFromAngular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.response.JwtResponse;
import com.bezkoder.springjwt.products.cartdetails;
//import com.bezkoder.springjwt.payload.response.JwtResponse;
import com.bezkoder.springjwt.products.product_page;
import com.bezkoder.springjwt.repository.ProductRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.repository.cartrepo;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;
import com.bezkoder.springjwt.security.services.UserDetailsServiceImpl;

import java.lang.String;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	 ProductRepository pr;
		@Autowired
	UserRepository ur;
	
	@Autowired
	cartrepo cr;
	
	UserDetails ud;
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/home")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<product_page> userAccess() {
		
		 return pr.findAll();
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/adminhome")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<product_page> adminhome() {
		
		 return pr.findAll();
	}
	@PostMapping("/addpro")
	@PreAuthorize("hasRole('ADMIN')")
	public String addpro(@RequestBody product_page pp) {
		pr.save(pp);
		return "succesfully added";
	}
	@GetMapping("/editpro")
	@PreAuthorize("hasRole('ADMIN')")
	public String editpro(@RequestBody product_page pp) {
		pr.save(pp);
		return "succesfully edited";
	}
	@GetMapping("/delpro")
	@PreAuthorize("hasRole('ADMIN')")
	public String delpro(@RequestBody product_page pp) {
		pr.delete(pp);
		return "succesfully deleted";
	}

	@GetMapping("/testing")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public  String testing() {
		String x="sjsjs";
		return x;
	}
	
	@GetMapping("/getpbid/{pid}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Optional<product_page> getprobid(@PathVariable int pid) {
		return pr.findById(pid);
	}
	@GetMapping("/getubid/{uid}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Optional<User> getubid(@PathVariable String uid) {
		return ur.findByUsername(uid);
		
	}
	@PostMapping("/addtocart")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public  cartdetails addtocart(@RequestBody cartDTOFromAngular cd) {
		//int quant=cd.quantity;
		product_page pp=cd.product_page;
		//int pid=pp.prod_id;
		cartdetails cart=cr.findByUser(cd.user);
		if(cart==null){
			cart=new cartdetails();
			cart.user=cd.user;
			cart.products=new ArrayList<>();
			cart.products.add(cd.product_page);
		}
		else{
			cart.products.add(cd.product_page);
		}
		return cr.save(cart);
	}
     @GetMapping("/getcd/{u}")
     @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<product_page> getcartprods(@PathVariable Long u){
		System.out.println(u);
		return cr.findByUser(ur.findById(u).get()).products;
	}
	
	
}