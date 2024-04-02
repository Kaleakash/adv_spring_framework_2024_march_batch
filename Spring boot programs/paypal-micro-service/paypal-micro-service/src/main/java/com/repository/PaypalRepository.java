package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Paypal;

@Repository
public interface PaypalRepository extends JpaRepository<Paypal, Integer>{

}
