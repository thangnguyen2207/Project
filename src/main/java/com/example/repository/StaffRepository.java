package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {

}
