package com.kkaplan.spring_mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kkaplan.spring_mvc.beans.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("select p from Product p where p.name like %:searchString%")
    public List<Product> searchByName(@Param("searchString") String keyword);
}