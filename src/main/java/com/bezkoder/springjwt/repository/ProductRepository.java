package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.products.product_page;
@Repository
@Component
public interface ProductRepository extends JpaRepository<product_page, Integer>{


}
