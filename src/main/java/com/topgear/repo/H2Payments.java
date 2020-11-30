package com.topgear.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topgear.entity.Payments;
@Repository
public interface H2Payments extends JpaRepository<Payments, Integer>{

	
	ArrayList<Payments> findAllByfromAccount(int Debittedfrom);
	ArrayList<Payments> findAllBytoAccount(int Creditedto);


	
	
}
