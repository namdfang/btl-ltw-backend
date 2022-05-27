package com.btl.web.service;

import com.btl.web.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
     public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
     public EmployeeDTO updateEmployee(int employeeId, EmployeeDTO employeeDTO);
     public boolean deleteEmployee(int employeeId);
     public EmployeeDTO getEmployeeById(int employeeId);
     public List<EmployeeDTO> getAllEmployeeCompany(int companyId);
}
