package com.btl.web.controller;

import com.btl.web.model.dto.CompanyDTO;
import com.btl.web.model.dto.EmployeeDTO;
import com.btl.web.service.CompanyService;
import com.btl.web.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
@RequiredArgsConstructor
public class CompanyRestController {

    final private CompanyService companyService;
    final private EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable("id") int companyId) {
        CompanyDTO companyDTO = companyService.getCompanyById(companyId);
        return new ResponseEntity<>(companyDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeCompany(@PathVariable("id") int companyId) {
        List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployeeCompany(companyId);
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO createdCompany = companyService.addCompany(companyDTO);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable("id") int companyId,
                                                    @RequestBody CompanyDTO companyDTO) {
        CompanyDTO updatedCompany = companyService.updateCompany(companyId, companyDTO);
        if (updatedCompany!=null)
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable("id") int companyId) {
        boolean deleteResult = companyService.deleteCompany(companyId);
        if(deleteResult == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
