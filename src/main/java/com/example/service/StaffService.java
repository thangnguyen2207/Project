package com.example.service;

import java.util.List;

import com.example.model.Staff;

public interface StaffService {
	
	public List<Staff> getStaffList();
	
	public Staff getStaff(String nvId);
	
	public void addStaff(Staff staff);
	
	public void updateStaff(Staff staff);
	
	public void deleteStaff(String nvId);
	
}
