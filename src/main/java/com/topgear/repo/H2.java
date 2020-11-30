package com.topgear.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.topgear.entity.RegistrationService;

@Repository

public interface H2 extends JpaRepository<RegistrationService, Integer> {
@Query("SELECT userName FROM RegistrationService")
ArrayList<String> findAllUserName();

@Query("SELECT accountNumber FROM RegistrationService")
ArrayList<String> findAllUserAccountNo();

	RegistrationService findByUserName(String username);
	
	@Modifying
	@Query("UPDATE RegistrationService p SET p.amount= p.amount-:amount WHERE p.accountNumber= :accountNumber")
	int fundTransferFrom(@Param("accountNumber") int from,@Param("amount") int amount);
	
	@Modifying
	@Query("UPDATE RegistrationService p SET p.amount= p.amount+:amount WHERE p.accountNumber= :accountNumber")
	int fundTransferTo(@Param("accountNumber") int to,@Param("amount") int amount);
		
}
