package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Staff;
import com.example.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public List<Staff> getStaffList() {
		return staffRepository.findAll();
	}

	@Override
	public void addStaff(Staff staff) {
		staffRepository.save(staff);
	}
	
	@Override
	public void updateStaff(Staff staff) {
		staffRepository.save(staff);
	}
	
	@Override
	public void deleteStaff(String nvId) {
		staffRepository.deleteById(nvId);
	}

	@Override
	public Staff getStaff(String nvId) {
		return staffRepository.findById(nvId).orElse(null);
	}

}
