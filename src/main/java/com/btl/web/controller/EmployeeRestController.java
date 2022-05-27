package com.btl.web.controller;

import com.btl.web.model.dto.EmployeeDTO;
import com.btl.web.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeRestController {

    final private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO addedEmployee = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") int employeeId,
                                                      @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeId, employeeDTO);
        if (updatedEmployee!=null)
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int employeeId) {
        boolean result = employeeService.deleteEmployee(employeeId);
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> getEmployedById(@PathVariable("id") int employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }
}
