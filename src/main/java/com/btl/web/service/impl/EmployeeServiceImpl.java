package com.btl.web.service.impl;

import com.btl.web.model.Employee;
import com.btl.web.model.dto.EmployeeDTO;
import com.btl.web.model.mapper.EmployeeMapper;
import com.btl.web.repository.EmployeeRepository;
import com.btl.web.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final private EmployeeRepository employeeRepository;
    final private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.convertToDTO(employeeRepository.save(employeeMapper.convertToEntity(employeeDTO)));
    }

    @Override
    public EmployeeDTO updateEmployee(int employeeId, EmployeeDTO employeeDTO) {
        Employee updatedEmployee = employeeRepository.findById(employeeId).orElse(null);
        if (updatedEmployee != null) {
            updatedEmployee = employeeMapper.convertToEntity(employeeDTO);
            updatedEmployee.setId(employeeId);
            return employeeMapper.convertToDTO(employeeRepository.save(updatedEmployee));
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        Employee deletedEmployee = employeeRepository.findById(employeeId).orElse(null);
        if (deletedEmployee != null) {
            employeeRepository.delete(deletedEmployee);
            return true;
        }
        return false;
    }

    @Override
    public EmployeeDTO getEmployeeById(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        return employee==null ? null : employeeMapper.convertToDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployeeCompany(int companyId) {
        return employeeRepository.findByCompanyId(companyId)
                .stream().map(e -> employeeMapper.convertToDTO(e))
                .collect(Collectors.toList());
    }
}
