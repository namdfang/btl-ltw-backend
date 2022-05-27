package com.btl.web.model.mapper;

import com.btl.web.model.Company;
import com.btl.web.model.Employee;
import com.btl.web.model.dto.EmployeeDTO;
import com.btl.web.repository.CompanyRepository;
import com.btl.web.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    final private CompanyRepository companyRepository;

    public EmployeeDTO convertToDTO(Employee employee) {
        return EmployeeDTO.builder()
                .employeeCode(employee.getEmployeeCode())
                .employeeName(employee.getEmployeeName())
                .employeeDob(employee.getEmployeeDob())
                .employeePhoneNumber(employee.getEmployeePhoneNumber())
                .companyId(employee.getCompany().getId())
                .build();
    }

    public Employee convertToEntity(EmployeeDTO employeeDTO) {
        Company company = companyRepository.findById(employeeDTO.getCompanyId()).orElse(null);//throw exception
        return Employee.builder()
                .employeeName(employeeDTO.getEmployeeName())
                .employeeDob(employeeDTO.getEmployeeDob())
                .employeeCode(employeeDTO.getEmployeeCode())
                .employeePhoneNumber(employeeDTO.getEmployeePhoneNumber())
                .company(company)
                .build();
    }
}
