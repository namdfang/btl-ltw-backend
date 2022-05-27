package com.btl.web.controller;

import com.btl.web.model.dto.StaffDTO;
import com.btl.web.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staffs")
@RequiredArgsConstructor
public class StaffRestController {

    final private StaffService staffService;

    @PostMapping
    public ResponseEntity<StaffDTO> addStaff(@RequestBody StaffDTO staffDTO) {
        StaffDTO addedStaff = staffService.addStaff(staffDTO);
        return new ResponseEntity<>(addedStaff, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StaffDTO> updateStaff(@PathVariable("id") int staffId,
                                                @RequestBody StaffDTO staffDTO) {
        StaffDTO updatedStaff = staffService.updateStaff(staffId, staffDTO);
        if(updatedStaff!=null)
            return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable("id") int staffId) {
        boolean result = staffService.deleteStaff(staffId);
        if(result) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable("id") int staffId) {
        StaffDTO staff = staffService.getStaffById(staffId);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
}
