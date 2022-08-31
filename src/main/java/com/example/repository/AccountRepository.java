package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query(value = "select a from Account a where a.tkTen = ?1")
	public Account findByUsername(String tkTen);
}
