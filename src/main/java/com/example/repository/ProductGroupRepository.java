package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ProductGroup;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer> {

}
